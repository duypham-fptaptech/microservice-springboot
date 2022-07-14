package com.example.demo_product_choreogrphy.enumEntity;

public enum ErrorEnum {
    emptyProduct("emptyProduct"),
    soldOutProduct("soldOutProduct");

    public final String errorStatus;

    private ErrorEnum(String errorStatus) {
        this.errorStatus = errorStatus;
    }
}
