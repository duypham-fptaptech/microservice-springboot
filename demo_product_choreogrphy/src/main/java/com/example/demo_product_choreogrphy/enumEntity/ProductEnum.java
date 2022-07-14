package com.example.demo_product_choreogrphy.enumEntity;

public enum ProductEnum {
    exist(1),
    soldOut(0),
    deleted(-1);

    public final Integer numStatus;

    private ProductEnum(Integer numStatus) {
        this.numStatus = numStatus;
    }
}
