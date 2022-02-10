package com.example.supplychain.vo;

import com.example.supplychain.po.RawMaterial;
import com.example.supplychain.po.RawMaterialName;

public class RawMaterialVO {
    /**
     * id
     */
    String id;
    /**
     * 名称
     */
    String name;

    public RawMaterialVO(RawMaterialName rawMaterial){
        this.id=rawMaterial.getId();
        this.name=rawMaterial.getName();
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
}
