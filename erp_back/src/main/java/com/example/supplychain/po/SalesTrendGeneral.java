package com.example.supplychain.po;

public class SalesTrendGeneral {

    String time;

    Double salesAmount;

    public SalesTrendGeneral(String time, Double salesAmount) {
        this.time = time;
        this.salesAmount = salesAmount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }
}
