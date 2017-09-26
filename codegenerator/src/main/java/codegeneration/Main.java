package codegeneration;

import com.google.common.base.CaseFormat;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ClassName hashMapClassName = ClassName.get("java.util", "HashMap");
        ClassName mapClassName = ClassName.get("java.util", "Map");
        ClassName listClassName = ClassName.get("java.util", "List");
        ClassName stringClassName = ClassName.get("java.lang", "String");
        ClassName intergerClassName = ClassName.get("java.lang", "Integer");
        List<String> boxedClassesNames = Arrays.asList("Integer", "Boolean", "String");

        new codegeneration.Wrapper().forEachSchema((fileString) -> {

            JsonObject json = new Gson().fromJson(fileString, JsonObject.class);
            String newClassName = json.get("_class_").getAsString();
            String packageName = json.get("_package_").getAsString();

            ClassName fieldsOnHash = ClassName.get("me.pagar.generickeyvalueobject", "FieldsOnHash");
            ClassName resourceObject = ClassName.get("me.pagar.objecttraits", "ResourceObject");

            ClassName referencedClassName = ClassName.get(packageName, newClassName);
            TypeSpec.Builder classBuilder = TypeSpec.classBuilder(newClassName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .superclass(fieldsOnHash)
                .addSuperinterface(resourceObject)
                .addMethod(MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addStatement("super(new $T())", ParameterizedTypeName.get(hashMapClassName, stringClassName, ClassName.OBJECT))
                    .build()
                )
                .addMethod(MethodSpec.constructorBuilder()
                    .addParameter(ParameterizedTypeName.get(mapClassName, stringClassName, ClassName.OBJECT), "parameters")
                    .addModifiers(Modifier.PUBLIC)
                    .addStatement("super(parameters)")
                    .build()
                )
                .addMethod(MethodSpec.constructorBuilder()
                    .addParameter(stringClassName, "jsonString")
                    .addModifiers(Modifier.PUBLIC)
                    .addStatement("super(jsonString)")
                    .build()
                );

            //Make object() method for requests
            if(packageName.contains("request")) {
                MethodSpec objectMethod = MethodSpec.methodBuilder("object")
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return \"" + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, newClassName) + "\"")
                        .build();
                classBuilder.addMethod(objectMethod);
            }

            json.get("properties").getAsJsonObject().entrySet().forEach(((entry) -> {

                TypeName propertyName = null;
                String entryValue = entry.getValue().getAsString();

                String superClassMethodName = "getParameterAsString";
                String superClassSetMethodName = "setParameter";
                if(entryValue.contains("List")){
                    String pojoName = entryValue.replace("List<", "").replace(">", "");
                    if(!boxedClassesNames.contains(pojoName)){
                        ClassName pojoClassName = ClassName.get(packageName, pojoName);
                        propertyName = ParameterizedTypeName.get(listClassName, pojoClassName);
                        superClassMethodName = "getParameterAsObjectList";
                    }
                }

                if(propertyName == null) {
                    switch (entry.getValue().getAsString().replace(" ", "")) {
                        case "String":
                            propertyName = stringClassName;
                            break;

                        case "Boolean":
                            propertyName = ClassName.get("java.lang", "Boolean");
                            superClassMethodName = "getParameterAsBoolean";
                            break;

                        case "Integer":
                            propertyName = ClassName.get("java.lang", "Integer");
                            superClassMethodName = "getParameterAsInteger";
                            break;

                        case "Map<String,Object>":
                            propertyName = ParameterizedTypeName.get(mapClassName, stringClassName, ClassName.OBJECT);
                            superClassMethodName = "getParameterAsMap";
                            break;

                        case "List<String>":
                            propertyName = ParameterizedTypeName.get(listClassName, stringClassName);
                            superClassMethodName = "getParameterAsStringList";
                            superClassSetMethodName = "setParameterCollection";
                            break;

                        default:
                            propertyName = ClassName.get(packageName, entry.getValue().getAsString());
                            superClassMethodName = "getParameterCasted";
                            break;
                    }
                }




                MethodSpec.Builder getMethodBuilder = MethodSpec.methodBuilder(
                    CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entry.getKey()))
                    .addModifiers(Modifier.PUBLIC)
                    .returns(propertyName);
                if(superClassMethodName.equals("getParameterCasted")){
                    getMethodBuilder.addStatement("return super.getParameterCasted(\"" + entry.getKey() + "\", new $T())", propertyName);
                } else if(superClassMethodName.equals("getParameterAsObjectList")) {
                    getMethodBuilder.addStatement("return super.getParameterAsObjectList(\"" + entry.getKey() + "\", $T.class)", ((ParameterizedTypeName)propertyName).typeArguments.get(0));
                }else {
                    getMethodBuilder.addStatement("return super." + superClassMethodName + "(\"" + entry.getKey() + "\")");
                }
                MethodSpec getMethod = getMethodBuilder.build();

                if(packageName.contains("requestobject")){
                    MethodSpec setMethod = MethodSpec.methodBuilder(
                        CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entry.getKey()))
                        .addModifiers(Modifier.PUBLIC)
                        .returns(referencedClassName)
                        .addParameter(String.class, "parameterName")
                        .addParameter(propertyName, "parameterValue")
                        .addStatement("super." + superClassSetMethodName + "(parameterName, parameterValue)")
                        .addStatement("return this")
                        .build();
                    classBuilder.addMethod(setMethod);
                }


                classBuilder.addMethod(getMethod);

                JavaFile javaFile = JavaFile.builder(packageName, classBuilder.build())
                    .indent("    ")
                    .build();

                OutputStream fos = null;
                try {
                    File file = new File("target/generated-sources/");
//                    file.getParentFile().mkdirs();
                    javaFile.writeTo(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));

        });

    }

    public static String parentPackage(String packageName) {
        return packageName.replaceAll("\\.[^\\.]+$", "");
    }

}
