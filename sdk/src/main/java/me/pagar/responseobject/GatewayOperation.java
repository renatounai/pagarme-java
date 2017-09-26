package me.pagar.responseobject;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.ResourceObject;

public final class GatewayOperation extends FieldsOnHash implements ResourceObject {
    public GatewayOperation() {
        super(new HashMap<String, Object>());
    }

    public GatewayOperation(Map<String, Object> parameters) {
        super(parameters);
    }

    public GatewayOperation(String jsonString) {
        super(jsonString);
    }

    public String id() {
        return super.getParameterAsString("id");
    }

    public String dateCreated() {
        return super.getParameterAsString("date_created");
    }

    public String dateUpdated() {
        return super.getParameterAsString("date_updated");
    }

    public String status() {
        return super.getParameterAsString("status");
    }

    public String failReason() {
        return super.getParameterAsString("fail_reason");
    }

    public String type() {
        return super.getParameterAsString("type");
    }

    public Boolean rollbacked() {
        return super.getParameterAsBoolean("rollbacked");
    }

    public String model() {
        return super.getParameterAsString("model");
    }

    public String modelId() {
        return super.getParameterAsString("model_id");
    }

    public String groupId() {
        return super.getParameterAsString("group_id");
    }

    public String nextGroupId() {
        return super.getParameterAsString("next_group_id");
    }

    public String requestId() {
        return super.getParameterAsString("request_id");
    }

    public String startedAt() {
        return super.getParameterAsString("started_at");
    }

    public String endedAt() {
        return super.getParameterAsString("ended_at");
    }

    public String processor() {
        return super.getParameterAsString("processor");
    }

    public String processorResponseCode() {
        return super.getParameterAsString("processor_response_code");
    }

    public Map<String, Object> metadata() {
        return super.getParameterAsMap("metadata");
    }

    public String object() {
        return "operation";
    }
}
