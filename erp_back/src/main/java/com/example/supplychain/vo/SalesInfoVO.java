package com.example.supplychain.vo;

public class SalesInfoVO {
    /**
     * 销售订单id
     */
    String id;

    /**
     * 类型
     */
    String productName;


    /**
     * 类型
     */
    String productId;

    /**
     * 类型
     */
    String num;

    /**
     * 类型
     */
    String price;

    /**
     * 类型
     */
    String totalPrice;

    /**
     * 类型
     */
    String  date;

    /**
     * 类型
     */
    boolean state ;

    public SalesInfoVO(String id, String productName, String productId, String num, String price, String totalPrice, String date,boolean state ) {
        this.id = id;
        this.productName = productName;
        this.productId = productId;
        this.num = num;
        this.price = price;
        this.totalPrice = totalPrice;
        this.date = date;
        this.state = state;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
