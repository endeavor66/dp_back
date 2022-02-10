package com.example.supplychain.vo;

import com.example.supplychain.po.Shop;

import java.util.Date;
import java.util.List;

public class ShopVo {
    String id;//id
    String name;//店铺名称
    String location;//店铺位置
    String type;//店铺类型
    String synopsis;//店铺简介
    String found;//店铺成立日期
    String director;//店铺负责人
    int capital;//注册资本

    public ShopVo(Shop shop){
        this.id=shop.getId();
        this.name=shop.getName();
        this.location=shop.getLocation();
        this.type=shop.getType();
        this.synopsis=shop.getSynopsis();
        this.found=shop.getFound();
        this.director=shop.getDirector();
        this.capital=shop.getCapital();
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

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getDirector(){return director;}

    public void setDirector(String director){this.director=director;}

    public int getCapital(){return capital;}

    public void setCapital(int capital){this.capital=capital;}
}
