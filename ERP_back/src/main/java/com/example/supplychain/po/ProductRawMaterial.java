package com.example.supplychain.po;

public class ProductRawMaterial {
    String productTypeId;
    String rawMateerialTypeId;

    public ProductRawMaterial(String productTypeId, String rawMateerialTypeId) {
        this.productTypeId = productTypeId;
        this.rawMateerialTypeId = rawMateerialTypeId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getRawMateerialTypeId() {
        return rawMateerialTypeId;
    }

    public void setRawMateerialTypeId(String rawMateerialTypeId) {
        this.rawMateerialTypeId = rawMateerialTypeId;
    }
}
