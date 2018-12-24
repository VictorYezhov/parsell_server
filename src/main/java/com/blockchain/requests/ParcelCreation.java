package com.blockchain.requests;

import com.blockchain.model.Coordinates;

/**
 * Created by Victor on 22.12.2018.
 */
public class ParcelCreation {
    private Long fromId;
    private Coordinates addressTo;
    private double price;


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

    @Override
    public String toString() {
        return "ParcelCreation{" +
                "fromId=" + fromId +
                ", addressTo=" + addressTo +
                ", price=" + price +
                '}';
    }
}
