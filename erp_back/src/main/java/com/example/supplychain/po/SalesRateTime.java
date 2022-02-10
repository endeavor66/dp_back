package com.example.supplychain.po;

public class SalesRateTime {
    String time;

    Double salesAmount;

    String product_id;

    public SalesRateTime(String time, Double salesAmount, String product_id) {
        this.time = time;
        this.salesAmount = salesAmount;
        this.product_id = product_id;
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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
