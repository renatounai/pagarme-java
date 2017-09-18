package codegeneration;

import com.google.common.base.CaseFormat;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.javapoet.*;
import me.pagar.route.FieldsOnHash;

import javax.lang.model.element.Modifier;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CreatePojos {

    public static void main(String[] args) throws IOException {

        ClassName mapClassName = ClassName.get("java.util", "Map");
        ClassName listClassName = ClassName.get("java.util", "List");
        ClassName stringClassName = ClassName.get("java.lang", "String");
        ClassName intergerClassName = ClassName.get("java.lang", "Integer");
        List<String> boxedClassesNames = Arrays.asList("Integer", "Boolean", "String");


        new codegeneration.Wrapper().forEachSchema((fileString) -> {

            JsonObject json = new Gson().fromJson(fileString, JsonObject.class);
            String newClassName = json.get("_class_").getAsString();
            String packageName = json.get("_package_").getAsString();

            ClassName referencedClassName = ClassName.get(packageName, newClassName);
            TypeSpec.Builder classBuilder = TypeSpec.classBuilder(newClassName)
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .superclass(FieldsOnHash.class);


            json.get("properties").getAsJsonObject().entrySet().forEach(((entry) -> {

                TypeName propertyName = null;
                String entryValue = entry.getValue().getAsString();


                if(entryValue.contains("List")){
                    String pojoName = entryValue.replace("List<", "").replace(">", "");
                    if(!boxedClassesNames.contains(pojoName)){
                        ClassName pojoClassName = ClassName.get(packageName, pojoName);
                        propertyName = ParameterizedTypeName.get(listClassName, pojoClassName);
                    }
                }

                if(propertyName == null) {
                    switch (entry.getValue().getAsString().replace(" ", "")) {
                        case "String":
                            propertyName = stringClassName;
                            break;

                        case "Boolean":
                            propertyName = ClassName.get("java.lang", "Boolean");
                            break;

                        case "Integer":
                            propertyName = ClassName.get("java.lang", "Integer");
                            break;

                        case "Map<String,Object>":
                            propertyName = ParameterizedTypeName.get(mapClassName, stringClassName, ClassName.OBJECT);
                            break;

                        case "List<String>":
                            propertyName = ParameterizedTypeName.get(listClassName, stringClassName);
                            break;

                        case "List<Integer>":
                            propertyName = ParameterizedTypeName.get(listClassName, intergerClassName);
                            break;

                        default:
                            propertyName = ClassName.get(packageName, entry.getValue().getAsString());
                            break;
                    }
                }

                if(propertyName == null){
                    System.out.print(propertyName);
                }

                MethodSpec getMethod = MethodSpec.methodBuilder(
                        CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entry.getKey()))
                        .addModifiers(Modifier.PUBLIC)
                        .returns(propertyName)
                        .addParameter(String.class, "parameterName")
                        .addStatement("super.getParameterAsString(parameterName)")
                        .build();

                if(packageName.contains("requestobject")){
                    MethodSpec setMethod = MethodSpec.methodBuilder(
                            CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entry.getKey()))
                            .addModifiers(Modifier.PUBLIC)
                            .returns(referencedClassName)
                            .addParameter(String.class, "parameterName")
                            .addParameter(propertyName, "parameterValue")
                            .addStatement("super.setParameter(parameterValue)")
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
                    File file = new File("./src/main/java" + packageName);
                    file.getParentFile().mkdirs();
                    javaFile.writeTo(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));

        });

    }


}
