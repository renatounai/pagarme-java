package unit;

import me.pagar.FieldsOnHash;
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
        map.put("map", childMap);
    }

    @Before
    public void setup() {
        testSubject = new FieldsOnHashImpl();
        testSubject.setParameter("integer", 123);
        testSubject.setParameter("integerString", "123");
        testSubject.setParameter("string", "string");
        testSubject.setParameter("map", map);
        testSubject.setParameter("boolean", true);
        testSubject.setParameter("objectList", list);
        testSubject.setParameterCollection("stringList", stringList);

    }

    @Test
    public void testIntegerValues() {
        Integer value = testSubject.getParameterAsInteger("integer", null);
        Assert.assertEquals(Integer.valueOf(123), value);
    }

    @Test
    public void testStringIntegerValues() {
        Integer value = testSubject.getParameterAsInteger("integerString", null);
        Assert.assertEquals(Integer.valueOf(123), value);
    }

    @Test
    public void testIntegerValuesDoesntExists() {
        Integer value = testSubject.getParameterAsInteger("notInteger", 1337);
        Assert.assertEquals(Integer.valueOf(1337), value);
    }

    @Test
    public void testIntegerValuesError() {
        Integer value = testSubject.getParameterAsInteger("map", 1337);
        Assert.assertEquals(Integer.valueOf(1337), value);
    }

    @Test
    public void testBooleanValues() {
        Boolean value = testSubject.getParameterAsBoolean("boolean", null);
        Assert.assertTrue(value);
    }

    @Test
    public void testBooleanValuesDoesntExists() {
        Boolean value = testSubject.getParameterAsBoolean("notBoolean", null);
        Assert.assertNull(value);
    }

    @Test
    public void testBooleanValuesError() {
        Boolean value = testSubject.getParameterAsBoolean("map", null);
        Assert.assertNull(value);
    }

    @Test
    public void testMapValue() {
        Map<String, Object> value = testSubject.getParameterAsMap("map", new HashMap<>());
        Assert.assertEquals(map, value);
        Assert.assertEquals(childMap, value.get("map"));
    }

    @Test
    public void testMapValueDoesntExists() {
        Map<String, Object> defaultValue = new HashMap<>();
        Map<String, Object> value = testSubject.getParameterAsMap("notMap", defaultValue);
        Assert.assertEquals(defaultValue, value);
    }

    @Test
    public void testMapValueError() {
        Map<String, Object> defaultValue = new HashMap<>();
        Map<String, Object> value = testSubject.getParameterAsMap("string", defaultValue);
        Assert.assertEquals(defaultValue, value);
    }

    @Test
    public void testStringListValue() {
        List<String> defaultValue = new ArrayList<>();
        List<String> value = testSubject.getParameterAsStringList("stringList", defaultValue);
        Assert.assertEquals(stringList, value);
    }

    @Test
    public void testStringListValueDoesntExists() {
        List<String> defaultValue = new ArrayList<>();
        List<String> value = testSubject.getParameterAsStringList("notStringList", defaultValue);
        Assert.assertEquals(defaultValue, value);
    }

    @Test
    public void testStringListValueError() {
        List<String> defaultValue = new ArrayList<>();
        List<String> value = testSubject.getParameterAsStringList("string", defaultValue);
        Assert.assertEquals(defaultValue, value);
    }

    @Test
    public void testObjectListValue() throws NoSuchFieldException {
        List<FieldsOnHashImpl> defaultValue = new ArrayList<>();
        List<FieldsOnHashImpl> value = testSubject.getParameterAsObjectList("objectList", FieldsOnHashImpl.class, defaultValue);
        for (int i = 0; i < value.size(); i++) {
            Assert.assertTrue(list.get(i).equals(value.get(i)));
        }
    }

    @Test
    public void testObjectListValueError() throws NoSuchFieldException {
        List<FieldsOnHashImpl> defaultValue = new ArrayList<>();
        List<FieldsOnHashImpl> value = testSubject.getParameterAsObjectList("notObjectList", FieldsOnHashImpl.class, defaultValue);
        Assert.assertEquals(defaultValue, value);
    }

    @Test
    public void testCastedValueValue() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        FieldsOnHashImpl defaultValue = new FieldsOnHashImpl();
        FieldsOnHashImpl value = testSubject.<FieldsOnHashImpl>getParameterCasted("map", new FieldsOnHashImpl(), defaultValue);
        Map<String, Object> valueMap = testSubject.getParameterAsMap("map", null);
        Assert.assertEquals(valueMap, value.fields());
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
        Map<String, Object> fields = testSubject.fields();

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
}
