package com.example.supplychain.po;

public class SalesByProductId {

    String year;

    Double salesAmount;

    public SalesByProductId(String year, Double salesAmount) {
        this.year = year;
        this.salesAmount = salesAmount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }
}
