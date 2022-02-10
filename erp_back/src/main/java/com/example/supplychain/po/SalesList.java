package com.example.supplychain.po;

import java.util.Date;

public class SalesList {

    String id;

    String product_id;

    String product_name;

    int num;

    Double price;

    String sales_date;

    public SalesList(String id, String product_id, String product_name , int num, Double price,String sales_date) {
        this.id = id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.sales_date = sales_date;
        this.num = num;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSales_date() {
        return sales_date;
    }

    public void setSales_date(String sales_date) {
        this.sales_date = sales_date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
