package com.example.supplychain.service;

import com.example.supplychain.vo.ResponseVO;

public interface rawMaterialWareHouseService {

    //原料类别信息查看
    ResponseVO getRawMaterialWareHouseType();

    //原料类别的增加
    ResponseVO addRawMaterialWareHouseType(String name);

    //原料类别的删除
    ResponseVO deleteRawMaterialWareHouseType(String productId);

    //原料类别的更新
    ResponseVO updateRawMaterialWareHouseType(String id, String name);

    //原料仓库信息查看
    ResponseVO getRawMaterialWareHouse();

    //原料仓库增加
    ResponseVO addRawMaterialWareHouse(String rawMaterialId, String rawMaterialName, String quantity);

    //原料仓库删除
    ResponseVO deleteRawMaterialWareHouse(String id);

    //原料仓库更新
    ResponseVO updateRawMaterialWareHouse(String id, String quantity);
}
