package com.dhunjam.backend.entity;

import jakarta.persistence.*;
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String location;
    private boolean chargeCustomers;
    private String email;
    private String serverErrMsg;
    private String uiErrMsg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isChargeCustomers() {
        return chargeCustomers;
    }

    public void setChargeCustomers(boolean chargeCustomers) {
        this.chargeCustomers = chargeCustomers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServerErrMsg() {
        return serverErrMsg;
    }

    public void setServerErrMsg(String serverErrMsg) {
        this.serverErrMsg = serverErrMsg;
    }

    public String getUiErrMsg() {
        return uiErrMsg;
    }

    public void setUiErrMsg(String uiErrMsg) {
        this.uiErrMsg = uiErrMsg;
    }

    public Person(int id, String fullName, String location, boolean chargeCustomers, String email, String serverErrMsg, String uiErrMsg) {
        this.id = id;
        this.fullName = fullName;
        this.location = location;
        this.chargeCustomers = chargeCustomers;
        this.email = email;
        this.serverErrMsg = serverErrMsg;
        this.uiErrMsg = uiErrMsg;
    }

    public Person(){

    }
}
