package com.example.supplychain.vo;

import com.example.supplychain.po.RawMaterialType;

public class RawMaterialWareHosueTypeVO {
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

    public RawMaterialWareHosueTypeVO(RawMaterialType rawMaterialType){
        this.id=rawMaterialType.getId();
        this.rawMaterialName =rawMaterialType.getRawMaterialName();
    }
}
