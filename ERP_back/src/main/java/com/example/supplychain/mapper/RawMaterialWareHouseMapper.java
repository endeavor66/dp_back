package com.example.supplychain.mapper;

import com.example.supplychain.po.ProductRawMaterial;
import com.example.supplychain.po.PurchaseListC;
import com.example.supplychain.po.RawMaterial;
import com.example.supplychain.po.RawMaterialType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RawMaterialWareHouseMapper {
    //获取原料类别id
    List<String> selectAllRawMateerialTypeId();
    //根据原料类别id获得原料类别对象
    RawMaterialType selectRawMaterialTypeByRawMaterialTypeId(String rawMaterialTypeId);

    //根据成品类别id获得原料类别id
    List<ProductRawMaterial> selectRawMaterialTypeIdByProductTypeId(String productId);

    //根据原料类别id从原料类别类中获得原料名字
    RawMaterialType selectRawMaterialNameByRawMaterialTypeId(String rawMaterialTypeId);

    //根据原料名称按照进货时间顺序从原料类中获得原料数量的一个list
    List<RawMaterial> selectNumByRawMaterialName(String rawMaterialName);

    //删除原料库存类别
    void deleteRawMaterialType(String rawMaterialTypeId);

    //新增原料库存类别
    void insertRawMaterialType(RawMaterialType rawMaterialType);

    //更新原料库存类别
    void updateRawMaterialType(String id, String rawMaterialName);

    //删除原料库存
    void deleteRawMaterial(String rawMaterialName);

    //新增原料库存
    void insertRawMaterial(RawMaterial rawMaterial);

    //更新原料库存
    void updateRawMaterial(String id, String quantity);

    //获取原料id
    List<String> selectAllId();

    //根据原料id获得原料对象
    RawMaterial selectRawMaterialById(String id);

    //根据原料名称更改原料库存数量
    void updateRawMaterialNumByRawMaterialName(String name, String quantity);

    //根据id删除原料库存
    void deleteRawMaterialById(String id);

    //根据原料id从purchaselistc中获得到货日期
    List<Date> selectDateByRawMaterialId(String materialId);

    //根据id从warehouse_material_c中获得material_name
    String selectMaterialNameById(String id);
}
