package com.example.supplychain.po;

public class RawMaterialType {
    String id;
    String rawMaterialName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public RawMaterialType(String id, String rawMaterialName){
        this.id=id;
        this.rawMaterialName=rawMaterialName;
    }
}
