package com.blockchain.requests;

/**
 * Created by Victor on 22.12.2018.
 */
public class RegistrationRequest {
    private String email;
    private String password;
    private String name;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
