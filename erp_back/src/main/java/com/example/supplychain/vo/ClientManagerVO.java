package com.example.supplychain.vo;

import com.example.supplychain.po.ClientManager;

import java.util.List;
public class ClientManagerVO {

    private String id;
    private String name;
    private String code;
    private int power;

    public ClientManagerVO(String id, String name, String code, int power) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.power = power;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
