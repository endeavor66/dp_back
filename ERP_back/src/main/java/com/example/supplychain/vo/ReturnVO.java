package com.example.supplychain.vo;

public class ReturnVO {

    /**
     * 销售订单id
     */
    String salesId;

    /**
     * 销售订单id
     */
    String productName;

    /**
     * 销售订单id
     */
    String productId;

    /**
     * 销售订单id
     */
    int num;

    /**
     * 销售订单id
     */
    String date;

    /**
     * 销售订单id
     */
    String price;

    /**
     * 销售订单id
     */
    String totalPrice;

    /**
     * 销售订单id
     */
    String reason;

    public ReturnVO(String salesId, String productName, String productId, int num, String date, String price, String totalPrice, String reason) {
        this.salesId = salesId;
        this.productName = productName;
        this.productId = productId;
        this.num = num;
        this.date = date;
        this.price = price;
        this.totalPrice = totalPrice;
        this.reason = reason;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
