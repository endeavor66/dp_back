package com.example.supplychain.vo;

import com.example.supplychain.po.RawMaterialSupplier;

import java.util.List;

public class RawMaterial2SupplierVO {

    /**
     * 原材料id
     */
    String materialId;

    /**
     * 供应商对象列表
     */
    List<RawMaterialSupplierVO> suppliers;

    public RawMaterial2SupplierVO(String materialId,List<RawMaterialSupplierVO> suppliers){
        this.materialId=materialId;
        this.suppliers=suppliers;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public List<RawMaterialSupplierVO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<RawMaterialSupplierVO> suppliers) {
        this.suppliers = suppliers;
    }
}
