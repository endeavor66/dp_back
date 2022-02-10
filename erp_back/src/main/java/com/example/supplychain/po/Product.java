package com.example.supplychain.po;

import java.util.Date;

public class Product {
    //成品仓库
    String id;
    String productId;
    int num;
    String madeTime;

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

    public String getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(String madeTime) {
        this.madeTime = madeTime;
    }

    public Product(String id, String productId, int num, String madeTime){
        this.id=id;
        this.productId=productId;
        this.num=num;
        this.madeTime =madeTime;
    }
}
