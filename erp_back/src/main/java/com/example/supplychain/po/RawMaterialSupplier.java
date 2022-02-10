package com.example.supplychain.po;

/**
 * 供应商对象
 * RawMaterialSupplier
 */
public class RawMaterialSupplier {

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
}
