package me.pagar.route;

public enum ApiResources {
    TRANSACTIONS("transactions"),
    SUBSCRIPTIONS("subscriptions"),
    POSTBACKS("postbacks"),
    BALANCE("balance"),
    OPERATIONS("operations"),
    PAYABLES("payables"),
    REFUNDS("refund"),
    SPLIT_RULES("split_rules"),
    CARDS("cards"),
    PLANS("plans");

    private String resourceName;

    private ApiResources(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
