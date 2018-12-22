package com.blockchain.responses;

/**
 * Created by Victor on 22.12.2018.
 */
public enum ErrorCodes {

    EMAIL_PRESENT(23),
    NOT_FULL_FORM(1337);

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    ErrorCodes(int code) {
        this.code = code;
    }
}
