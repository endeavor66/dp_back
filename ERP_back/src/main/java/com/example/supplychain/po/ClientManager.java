package com.example.supplychain.po;

/**
 * 管理员对象
 */
public class ClientManager {
    private String id;
    private String name;
    private String code;
    private int power;

    public ClientManager(String id, String name, String code, int power) {
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
