package com.example.supplychain.vo;

import com.example.supplychain.po.RawMaterialSupplier;

public class RawMaterialSupplierVO {
    /**
     * id
     */
    String id;
    /**
     * 名称
     */
    String name;
    /**
     * 供应商位置
     */
    String location;
    /**
     * 合作分值(每次收货成功就+1)
     */
    int star;
    /**
     * 运输时间系数
     */
    double time_parameter;
    /**
     * 运输价格系数
     */
    double fare_parameter;

    /**
     * 对应原料的价格
     */
    double price;

    public RawMaterialSupplierVO(RawMaterialSupplier rawMaterialSupplier,double price){
        this.id=rawMaterialSupplier.getId();
        this.name=rawMaterialSupplier.getName();
        this.location=rawMaterialSupplier.getLocation();
        this.star=rawMaterialSupplier.getStar();
        this.time_parameter=rawMaterialSupplier.getTime_parameter();
        this.fare_parameter=rawMaterialSupplier.getFare_parameter();
        this.price=price;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public double getTime_parameter() {
        return time_parameter;
    }

    public void setTime_parameter(double time_parameter) {
        this.time_parameter = time_parameter;
    }

    public double getFare_parameter() {
        return fare_parameter;
    }

    public void setFare_parameter(double fare_parameter) {
        this.fare_parameter = fare_parameter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
