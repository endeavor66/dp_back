package com.example.supplychain.service;

import com.example.supplychain.po.Product;
import com.example.supplychain.vo.ResponseVO;

import java.util.List;

public interface ProductWareHouseService {
    //成品库存类别信息查看
    ResponseVO getProductWareHouseType();

    //成品库存信息查看
    ResponseVO getProductWareHouse();

    //成品库存类别的添加
    ResponseVO addProductWareHouseType(String productName,List<String> materials,int price);

    //成品仓库的添加
    ResponseVO addProductWareHouse(String productId,String name,String quantity);

    //成品库存类型的删除
    ResponseVO deleteProductWareHouseType(String productID);

    //成品仓库的删除
    ResponseVO deleteProductWareHouse(String id);

    //成品库存类别的更新
    ResponseVO updateProductWareHouseType(String id,String name,List<String> materials);

    //成品库存更新数量
    ResponseVO updateProductWareHouse(String id,String quantity);
}
