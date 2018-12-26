package com.blockchain.model;

/**
 * Created by Victor on 26.12.2018.
 */
public enum ParcelStates {
    CREATED("Created"),
    COURIER_FOUND("Courier found"),
    DELIVERED("Delivered");

    private String name;

    private ParcelStates(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
