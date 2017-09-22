package unit;

import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.exception.IncompatibleClass;
import me.pagar.exception.NoFieldWithName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FieldsOnHashTest {

    public FieldsOnHashImpl testSubject;
    public List<FieldsOnHash> list = Arrays.asList(new FieldsOnHashImpl(), new FieldsOnHashImpl());
    public List<String> stringList = Arrays.asList("1", "2");
    public Map<String, Object> map = new HashMap<>();
    public Map<String, Object> childMap = new HashMap<>();
    {
        childMap.put("integer", 123);
        map.put("map", childMap);
    }

    @Before
    public void setup() {
        testSubject = new FieldsOnHashImpl();
        testSubject.setParameter("integer", 123);
        testSubject.setParameter("integerString", "123");
        testSubject.setParameter("booleanString", "true");
        testSubject.setParameter("string", "string");
        testSubject.setParameter("map", map);
        testSubject.setParameter("boolean", true);
        testSubject.setParameter("objectList", list);
        testSubject.setParameterCollection("stringList", stringList);
        testSubject.setParameter("null", (String) null);
    }

    @Test
    public void testStringNullValue() throws NoFieldWithName {
        String value = testSubject.getParameterAsString("null");
        Assert.assertEquals("null", value);
    }

    @Test
    public void testIntegerNullValue() throws NoFieldWithName, IncompatibleClass {
        Integer value = testSubject.getParameterAsInteger("null");
        Assert.assertEquals(null, value);
    }

    @Test
    public void testBooleanNullValue() throws IncompatibleClass, NoFieldWithName {
        Boolean value = testSubject.getParameterAsBoolean("null");
        Assert.assertEquals(null, value);
    }

    @Test
    public void testObjectListNullValue() throws IncompatibleClass, NoFieldWithName {
        Object value = testSubject.getParameterAsObjectList("null", FieldsOnHashImpl.class);
        Assert.assertEquals(null, value);
    }

    @Test
    public void testMapNullValue() throws IncompatibleClass, NoFieldWithName {
        Map<String, Object> value = testSubject.getParameterAsMap("null");
        Assert.assertEquals(null, value);
    }

    @Test
    public void testStringListNullValue() throws IncompatibleClass, NoFieldWithName {
        List<String> value = testSubject.getParameterAsStringList("null");
        Assert.assertEquals(null, value);
    }

    @Test
    public void testCastedObjectNullValue() throws IncompatibleClass, NoFieldWithName {
        FieldsOnHash value = testSubject.getParameterCasted("null", new FieldsOnHashImpl());
        Assert.assertEquals(null, value);
    }

    @Test
    public void testIntegerValues() throws NoFieldWithName, IncompatibleClass {
        Integer value = testSubject.getParameterAsInteger("integer");
        Assert.assertEquals(Integer.valueOf(123), value);
    }

    @Test
    public void testStringIntegerValues() throws NoFieldWithName, IncompatibleClass {
        Integer value = testSubject.getParameterAsInteger("integerString");
        Assert.assertEquals(Integer.valueOf(123), value);
    }

    @Test(expected = NoFieldWithName.class)
    public void testIntegerValuesDoesntExists() throws NoFieldWithName, IncompatibleClass {
        Integer value = testSubject.getParameterAsInteger("notInteger");
    }

    @Test(expected = IncompatibleClass.class)
    public void testIntegerValuesError() throws NoFieldWithName, IncompatibleClass {
        Integer value = testSubject.getParameterAsInteger("map");
    }

    @Test
    public void testBooleanValues() throws IncompatibleClass, NoFieldWithName {
        Boolean value = testSubject.getParameterAsBoolean("boolean");
        Assert.assertTrue(value);
    }

    @Test
    public void testBooleanStringValues() throws IncompatibleClass, NoFieldWithName {
        Boolean value = testSubject.getParameterAsBoolean("booleanString");
        Assert.assertTrue(value);
    }

    @Test(expected = NoFieldWithName.class)
    public void testBooleanValuesDoesntExists() throws IncompatibleClass, NoFieldWithName {
        Boolean value = testSubject.getParameterAsBoolean("notBoolean");
    }

    @Test(expected = IncompatibleClass.class)
    public void testBooleanValuesError() throws IncompatibleClass, NoFieldWithName {
        Boolean value = testSubject.getParameterAsBoolean("map");
    }

    @Test
    public void testMapValue() throws IncompatibleClass, NoFieldWithName {
        Map<String, Object> value = testSubject.getParameterAsMap("map");
        Assert.assertEquals(map, value);
        Assert.assertEquals(childMap, value.get("map"));
    }

    @Test(expected = NoFieldWithName.class)
    public void testMapValueDoesntExists() throws IncompatibleClass, NoFieldWithName {
        Map<String, Object> value = testSubject.getParameterAsMap("notMap");
    }

    @Test(expected = IncompatibleClass.class)
    public void testMapValueError() throws IncompatibleClass, NoFieldWithName {
        Map<String, Object> value = testSubject.getParameterAsMap("string");
    }

    @Test
    public void testStringListValue() throws IncompatibleClass, NoFieldWithName {
        List<String> value = testSubject.getParameterAsStringList("stringList");
        Assert.assertEquals(stringList, value);
    }

    @Test(expected = NoFieldWithName.class)
    public void testStringListValueDoesntExists() throws IncompatibleClass, NoFieldWithName {
        List<String> value = testSubject.getParameterAsStringList("notStringList");
    }

    @Test(expected = IncompatibleClass.class)
    public void testStringListValueError() throws IncompatibleClass, NoFieldWithName {
        List<String> value = testSubject.getParameterAsStringList("string");
    }

    @Test
    public void testObjectListValue() throws NoSuchFieldException, IncompatibleClass, NoFieldWithName {
        List<FieldsOnHashImpl> value = testSubject.getParameterAsObjectList("objectList", FieldsOnHashImpl.class);
        for (int i = 0; i < value.size(); i++) {
            Assert.assertTrue(list.get(i).equals(value.get(i)));
        }
    }

    @Test(expected = NoFieldWithName.class)
    public void testObjectListValueError() throws NoSuchFieldException, IncompatibleClass, NoFieldWithName {
        List<FieldsOnHashImpl> value = testSubject.getParameterAsObjectList("notObjectList", FieldsOnHashImpl.class);
    }

    @Test
    public void testCastedValueValue() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IncompatibleClass, NoFieldWithName {
        FieldsOnHashImpl value = testSubject.<FieldsOnHashImpl>getParameterCasted("map", new FieldsOnHashImpl());
        Map<String, Object> valueMap = testSubject.getParameterAsMap("map");
        Assert.assertEquals(valueMap, value.toMap());
    }

    @Test
    public void fieldSerialization() {
        Map<String, Object> childMap = new HashMap<>();
        childMap.put("string", "string");

        List<String> childStringlist = new ArrayList<>();
        childStringlist.add("string");

        List<Integer> childIntegerlist = new ArrayList<>();
        childIntegerlist.add(123);

        Map<String, Object> map = new HashMap<>();
        map.put("integer", 123);
        map.put("string", "string");
        map.put("boolean", true);
        map.put("null", null);
        map.put("map", childMap);
        map.put("stringList", childStringlist);
        map.put("integerList", childIntegerlist);


        FieldsOnHash testSubject = new FieldsOnHashImpl(map);
        String jsonString = testSubject.toJson().replace(" ", "");
        Assert.assertTrue(jsonString.contains("\"integer\":123"));
        Assert.assertTrue(jsonString.contains("\"string\":\"string\""));
        Assert.assertTrue(jsonString.contains("\"boolean\":true"));
        Assert.assertTrue(jsonString.contains("\"null\":null"));
        Assert.assertTrue(jsonString.contains("\"map\":{\"string\":\"string\"}"));
        Assert.assertTrue(jsonString.contains("\"stringList\":[\"string\"]"));
        Assert.assertTrue(jsonString.contains("\"integerList\":[123]"));

    }

    @Test
    public void testLoadJsonString() {
        String jsonString = "{" +
            "\"integer\":123," +
            "\"string\":\"string\"," +
            "\"boolean\":true," +
            "\"null\":null," +
            "\"map\":{\"string\":\"string\"}," +
            "\"stringList\":[\"string\"]," +
            "\"integerList\":[123]" +
        "}";
        FieldsOnHash testSubject = new FieldsOnHashImpl(jsonString);
        Map<String, Object> fields = testSubject.toMap();

        Assert.assertTrue(
    fields.get("integer").equals(123) ||
            fields.get("integer").equals(123.0)
        );
        Assert.assertEquals("string", fields.get("string"));
        Assert.assertNull(fields.get("null"));
        Assert.assertEquals("string", ((Map<String, Object>)fields.get("map")).get("string"));
        Assert.assertArrayEquals(Arrays.asList("string").toArray(), ((List<String>)fields.get("stringList")).toArray());
        Assert.assertTrue(
    Arrays.asList(123).equals((List<String>)fields.get("integerList")) ||
            Arrays.asList(123.0).equals((List<String>)fields.get("integerList"))
        );

    }


//    public FieldsOnHashImpl testSubject;
//    public List<FieldsOnHash> list = Arrays.asList(new FieldsOnHashImpl(), new FieldsOnHashImpl());
//    public List<String> stringList = Arrays.asList("1", "2");
//    public Map<String, Object> map = new HashMap<>();
//    public Map<String, Object> childMap = new HashMap<>();

//    testSubject = new FieldsOnHashImpl();
//        testSubject.setParameter("integer", 123);
//        testSubject.setParameter("integerString", "123");
//        testSubject.setParameter("string", "string");
//        testSubject.setParameter("map", map);
//        testSubject.setParameter("boolean", true);
//        testSubject.setParameter("objectList", list);
//        testSubject.setParameterCollection("stringList", stringList);

    @Test
    public void testToQueryString() {
        String queryParams = testSubject.toQueryString();
        List<String> actualParameters = Arrays.asList(queryParams.split("&"));

        List<String> expectedParameters = Arrays.asList("integer=123", "integerString=123", "string=string",
            "map[map][integer]=123", "boolean=true", "objectList[0]=", "objectList[1]=",
            "stringList[0]=1", "stringList[1]=2", "booleanString=true");

        Assert.assertEquals(expectedParameters.size(), actualParameters.size());
        for (String expectedValue : expectedParameters) {
            Assert.assertTrue(actualParameters.contains(expectedValue));
        }
    }

}
