package com.blockchain.requests;

import com.blockchain.model.Coordinates;

/**
 * Created by Victor on 22.12.2018.
 */
public class ParcelCreation {
    private Long fromId;
    private Long userToId;
    private Coordinates addressTo;
    private Coordinates from;
    private double price;
    private String description;


    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Coordinates getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(Coordinates addressTo) {
        this.addressTo = addressTo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Coordinates getFrom() {
        return from;
    }

    public void setFrom(Coordinates from) {
        this.from = from;
    }

    public Long getUserToId() {
        return userToId;
    }

    public void setUserToId(Long userToId) {
        this.userToId = userToId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ParcelCreation{" +
                "fromId=" + fromId +
                ", addressTo=" + addressTo +
                ", price=" + price +
                '}';
    }
}
