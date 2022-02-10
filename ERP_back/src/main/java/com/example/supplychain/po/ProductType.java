package com.example.supplychain.po;

public class ProductType {
    String id;
    String productName;
    int price;

    public int getPrice() {
        return price;
    }

    public ProductType(String id, String productName, int price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


}
