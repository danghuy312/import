package com.vnpt.model;

import java.io.Serializable;

public class CDR implements Serializable {

    private String phoneNumber;
    private String code;
    private String dateTime;

    public CDR() {
    }

    public CDR(String phoneNumber, String code, String dateTime) {
        this.phoneNumber = phoneNumber;
        this.code = code;
        this.dateTime = dateTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return phoneNumber + "," + code + "," + dateTime;
    }
}
