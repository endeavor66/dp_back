package com.example.supplychain.vo;

import com.example.supplychain.po.ProductRawMaterial;

public class Product_RawMaterialVO {
    String productTypeId;
    String rawMaterialTypeId;

    public Product_RawMaterialVO(ProductRawMaterial product_rawMaterial){
        this.productTypeId=product_rawMaterial.getProductTypeId();
        this.rawMaterialTypeId=product_rawMaterial.getRawMateerialTypeId();
    }
}
