package com.example.supplychain.po;

import java.util.Date;

public class RawMaterial {
    /**
     * id
     */
    String id;
    /**
     * 名称
     */
    String name;
    /**
     * 数量
     */
    int nums;
    /**
     * 进货日期
     */
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
    public RawMaterial(String id ,String name,int nums,String date){
        this.id =id;
        this.name =name;
        this.nums =nums;
        this.date =date;
    }
}
