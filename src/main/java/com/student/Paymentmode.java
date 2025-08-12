package com.student;

public enum Paymentmode {
    CASH("payment via cash"),UPI("payment via UPI"),CHEQUE("payment via cheque"),CARD("payment via card");
    private String description;

    private Paymentmode(String description) {
        this.description = description;
    }
    public String getDescritpion(){
        return description;
    }
}
