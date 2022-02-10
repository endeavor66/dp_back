package com.example.supplychain.mapper;

import com.example.supplychain.po.Product;
import com.example.supplychain.po.ProductRawMaterial;
import com.example.supplychain.po.ProductType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WareHouseMapper {
    //获取所有成品类别id(对应数据库)
    List<String> selectAllProductTypeId();

    //根据成品类别id获得成品库存类别对象
    ProductType selectProductTypeByProductTypeId(String productTypeId);

    //根据成品类别id从productlist_c中获取name
    String selectNameById(String id);

    //根据productId从product_material_relation_c中获取materialId
    List<String> selectMaterialIdByProductId(String productId);

    //根据materialId从materiallist_c中获取name
    String selectMaterialNameByMaterialId(String id);

    //获取所有门店产品id
    List<String> selectAllProductId();

    //根据ID获得成品Id
    Product selectProductIdById(String id);

    //根据成品id获得成品名称
    ProductType selectProductNameByProductId(String productId);

    //根据产品id获得产品库存对象
    Product selectWareHouseByProductId(String productId);

    //新增成品原料关系表
    void insertProductRawMaterial(ProductRawMaterial productRawMaterial);

    //新增成品库存类
    void insertProductWareHouseType(ProductType productType);

    //新增成品库存记录
    void insertWareHouse(Product product);

    //根据id删除成品类别库存记录
    void deleteWareHouseTypeList(String id);

    //根据id删除成品库存记录
    void deleteWareHouseList(String id);

    //更新成品库存类别
    void updateProductWareHouseTypeList(String id, String productName);

    //更新成品库存
    void updateQuantityById(String id, int quantity);


}
