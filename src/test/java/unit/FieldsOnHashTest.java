package unit;

import me.pagar.route.FieldsOnHash;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FieldsOnHashTest {

    public class FieldsOnHashImpl extends FieldsOnHash {

        public FieldsOnHashImpl(){
            super(new HashMap<String, Object>());
        }
        public FieldsOnHashImpl(Map<String, Object> parameters){
            super(parameters);
        }
        public FieldsOnHashImpl(String jsonString){
            super(jsonString);
        }
    }

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
        testSubject.setParameter("string", "string");
        testSubject.setParameter("map", map);
        testSubject.setParameter("boolean", true);
        testSubject.setParameter("objectList", list);
        testSubject.setParameterCollection("stringList", stringList);

    }

    @Test
    public void testIntegerValues() {
        Integer value = testSubject.getParameterAsInteger("integer");
        Assert.assertEquals(Integer.valueOf(123), value);
    }

    @Test(expected = NumberFormatException.class)
    public void testIntegerValuesError() {
        Integer value = testSubject.getParameterAsInteger("notInteger");
    }

    @Test
    public void testBooleanValues() {
        Boolean value = testSubject.getParameterAsBoolean("boolean");
        Assert.assertEquals(true, value);
    }

    @Test(expected = Exception.class)
    public void testBooleanValuesError() {
        Boolean value = testSubject.getParameterAsBoolean("notBoolean");
    }

    @Test
    public void testMapValue() {
        Map<String, Object> value = testSubject.getParameterAsMap("map");
        Assert.assertEquals(map, value);
        Assert.assertEquals(childMap, value.get("map"));
    }

    @Test(expected = ClassCastException.class)
    public void testMapValueError() {
        Map<String, Object> value = testSubject.getParameterAsMap("notMap");
    }

    @Test
    public void testStringListValue() {
        List<String> value = testSubject.getParameterAsStringList("stringList");
        Assert.assertEquals(stringList, value);
    }

    @Test(expected = ClassCastException.class)
    public void testStringListValueError() {
        List<String> value = testSubject.getParameterAsStringList("notStringList");
    }

    @Test
    public void testObjectListValue() {
        List<FieldsOnHash> value = testSubject.getParameterAsObjectList("objectList");
        Assert.assertEquals(list, value);
    }

    @Test
    public void testObjectListValueError() {
        List<FieldsOnHash> value = testSubject.getParameterAsObjectList("notObjectList");
        Assert.assertNull(value);
    }

    @Test
    public void testCastedValueValue() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        FieldsOnHashImpl value = testSubject.getParameterCasted("map", new FieldsOnHashImpl());
        Map<String, Object> valueMap = testSubject.getParameterAsMap("map");
        Assert.assertEquals(valueMap, value.fields());
    }

}
