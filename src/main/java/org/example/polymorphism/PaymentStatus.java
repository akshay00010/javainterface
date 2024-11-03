package org.example.polymorphism;

public enum PaymentStatus {

    success("Transaction is success"),

    failed("Transaction is failed"),

    pending("Transaction is pending");

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    PaymentStatus(String label){
        this.label=label;


    }

    }
