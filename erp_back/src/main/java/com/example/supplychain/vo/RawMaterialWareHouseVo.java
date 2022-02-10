package com.example.supplychain.vo;

import com.example.supplychain.po.RawMaterial;

import java.util.Date;

public class RawMaterialWareHouseVo {
    String id;
    String name;
    int nums;
    String date;

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

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RawMaterialWareHouseVo(RawMaterial rawMaterial){
        this.id =rawMaterial.getId();
        this.name=rawMaterial.getName();
        this.nums=rawMaterial.getNums();
        this.date=rawMaterial.getDate();
    }
}
