package com.example.supplychain.vo;

import com.example.supplychain.po.Product;

import java.util.Date;

public class WareHouseVo {
    String id;
    String productId;
    int num;
    String madeTime;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public WareHouseVo(Product wareHouse,String name){
        this.id=wareHouse.getId();
        this.productId=wareHouse.getProductId();
        this.num=wareHouse.getNum();
        this.madeTime=wareHouse.getMadeTime();
        this.name = name;

    }
}
