package me.pagar.model;

import com.google.common.base.CaseFormat;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.atteo.evo.inflector.English;
import org.joda.time.DateTime;

public class SplitRule {
    
    private String className;

    public SplitRule(){
                className = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, English.plural(getClass().getSimpleName()));

    }
    @Expose
    private String id;

    @Expose
    @SerializedName("recipient_id")
    private String recipientId;

    @Expose
    @SerializedName("charge_processing_fee")
    private Boolean chargeProcessingFee;

    @Expose
    private Boolean liable;

    @Expose
    private Integer percentage;

    @Expose
    private Integer amount;

    @Expose(serialize = false)
    @SerializedName("date_updated")
    private DateTime updatedAt;
    
    @Expose(serialize = false)
    @SerializedName("date_created")
    private DateTime createdAt;
    
    public String getRecipientId() {
        return recipientId;
    }

    public Boolean getChargeProcessingFee() {
        return chargeProcessingFee;
    }

    public Boolean getLiable() {
        return liable;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public Integer getAmount() {
        return amount;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public void setChargeProcessingFee(Boolean chargeProcessingFee) {
        this.chargeProcessingFee = chargeProcessingFee;
    }

    public void setLiable(Boolean liable) {
        this.liable = liable;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "SplitRule{"  + "id=" + id + ", recipientId=" + recipientId + ", chargeProcessingFee=" + chargeProcessingFee + ", liable=" + liable + ", percentage=" + percentage + ", amount=" + amount + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt +'}';
    }
    
    

}
