package com.example.supplychain.po;

public class SalesInfo {
    /**
     * 销售订单id
     */
    String id;

    /**
     * 类型
     */
    String productId;

    /**
     * 类型
     */
    int num;


    /**
     * 类型
     */
    String  date;

    public SalesInfo(String id, String productId, int num,  String date) {
        this.id = id;
        this.productId = productId;
        this.num = num;

        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
