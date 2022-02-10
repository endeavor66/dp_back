package com.example.supplychain.po;

import java.util.Date;

/**
 * 门店对象
 */
public class Shop {
    private String id;//id
    private String name;//店铺名称
    private String location;//店铺位置
    private String type;//店铺类型
    private String synopsis;//店铺简介
    private String found;//店铺成立日期
    private String director;//店铺负责人
    private int capital;//注册资本

    public Shop(String id,String name,String location,String type,String synopsis,String found,String director,int capital){
        this.id =id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.synopsis = synopsis;
        this.found=found;
        this.director=director;
        this.capital=capital;
    }

    public String getId(){return id;}

    public void setId(String id){this.id=id;}

    public String getName(){return name;}

    public void setName(String name){this.name=name;}

    public String getLocation(){ return location;}

    public void setLocation(String location){this.location=location;}

    public String getType(){return type;}

    public void setType(String type){this.type=type;}

    public String getSynopsis(){return synopsis;}

    public void setSynopsis(String synopsis){this.synopsis=synopsis;}

    public String getFound(){return found;}

    public void setFound(String found){this.found=found;}

    public String getDirector(){return director;}

    public void setDirector(String director){this.director=director;}

    public int getCapital(){return capital;}

    public void setCapital(){this.capital=capital;}



}
