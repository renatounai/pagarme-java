package unit;

import me.pagar.FieldsOnHash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by henriquekano on 9/19/17.
 */
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