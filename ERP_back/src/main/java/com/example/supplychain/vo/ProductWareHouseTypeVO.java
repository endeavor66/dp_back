package com.example.supplychain.vo;

import java.util.List;

public class ProductWareHouseTypeVO {
    String id;
    String productName;
    List<String> materials;
    int price;

//<<<<<<< HEAD
    public ProductWareHouseTypeVO(ProductWareHouseTypeVO productWareHouseTypeVO) {
        this.id = productWareHouseTypeVO.getId();
        this.productName = productWareHouseTypeVO.getProductName();
        this.materials = productWareHouseTypeVO.getMaterials();
        this.price = productWareHouseTypeVO.getPrice();
    }
//=======
//
//
////    public ProductWareHouseTypeVO(ProductWareHouseTypeVO productWareHouseTypeVO) {
////        this.id = productWareHouseTypeVO.getId();
////        this.productName = productWareHouseTypeVO.getProductName();
////        this.materials = productWareHouseTypeVO.getMaterials();
////        this.price = productWareHouseTypeVO.getPrice();
////    }
//>>>>>>> 436bd6a005e527f51e0f3e5ed0416b0b8c0c2863

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

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
