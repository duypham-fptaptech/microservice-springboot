package com.example.demo_order_choreogrphy.enumEntity;

public enum ProductErrorEnum {
    emptyProduct("emptyProduct"),
    soldOutProduct("soldOutProduct");

    public final String errorStatus;

    private ProductErrorEnum(String errorStatus) {
        this.errorStatus = errorStatus;
    }
}
