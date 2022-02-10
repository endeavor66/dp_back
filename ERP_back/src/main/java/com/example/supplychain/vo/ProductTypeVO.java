package com.example.supplychain.vo;

import com.example.supplychain.po.ProductType;

import java.util.List;

public class ProductTypeVO {
    String id;
    String productName;
    List<MaterialNeedVO> materials;


    public ProductTypeVO(String id, String productName, List<MaterialNeedVO> materials) {
        this.id = id;
        this.productName = productName;
        this.materials = materials;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<MaterialNeedVO> getMaterials() {
        return materials;
    }

    public void setMaterials(List<MaterialNeedVO> materials) {
        this.materials = materials;
    }
}
