package com.example.supplychain.mapper;

import com.example.supplychain.po.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProcurementMapper {

    //获取所有原料id
    List<String> selectAllRawMaterialId();

    //根据原料id获取该原料所有供应商对象Id
    List<String> selectSupplierIdByRawMaterialId(String materialId);

    //根据供应商id获取供应商对象
    RawMaterialSupplier selectSupplierBySupplierId(String supplierId);


    //获取最近的一个采购表id
    List<String> getNewestPurchaseAppId();

    //新增采购表
    int insertPurchaseApplication(PurchaseApplicationC purchaseApplicationC);

    //根据供应商id和原料id获取价格
    Double getPriceBySupplierAndMaterialId(@Param("sId") String sId, @Param("mId") String mId);

    //新增采购商品表
    int insertPurchaseList(PurchaseListC purchaseListC);


    //根据id删除采购表
    int deletePurchaseApplication(String id);

    //根据id删除采购商品表
    int deletePurchaseList(String id);

    //根据id删除采购审核表
    int deletePurchaseAcceptance(String id);


   //获取最近的一个审核表id
    List<String> getNewestPurchaseAccId();

    //根据管理员id获取他的权限等级
    int getPowerByManagerId(String managerId);

    //根据管理员id获取他的名字
    String getManagerNameById(String id);

    //新增采购审核表
    int insertPurchaseAcceptance(PurchaseAcceptanceC purchaseAcceptanceC);

    //更新采购表状态
    int updatePurchaseApplication(@Param("id") String id,@Param("state") String state);

    //更新采购商品表状态
    int updatePurchaseList(@Param("id") String id,@Param("pId") String pId,@Param("state") String state);


    //根据采购表id和原料id获取采购商品表中该原料的数量
    Double getNumByPurchaseIdAndMaterialId(@Param("pId") String pId,@Param("mId") String mId);

    //获取最近的一个原料仓库id
    List<String> getNewestWarehouseMaterialId();

    //根据原料id获取原料名
    String getMaterialNameByMaterialId(String id);

    //更新采购商品表in_date
    int updatePurchaseListDate(PurchaseListDateUpdate purchaseListDateUpdate);

    //更新仓库库存
    int insertMaterialWarehouse(WarehouseMaterialC warehouseMaterialC);


    //获取正在进行的采购表（state=12345）
    List<PurchaseApplicationC> getPurchasingApplication();

    //根据采购表的id获取采购商品表（采购清单）
    List<PurchaseListC> getPurchasingList(String id);

    //根据采购表id获取审核表
    List<PurchaseAcceptanceC> getPurchaseAcceptance(String id);


    //获取已经完成的采购表（state=6）
    List<PurchaseApplicationC> getPurchasedApplication(@Param("year") String year,@Param("month") String month);

    //根据年份和月份获取已完成的采购商品表（采购清单）
    List<PurchaseListC> getPurchasedList(String id);


    //根据原料id获取原料信息
    RawMaterialName getMaterialInfo(String id);


    //根据采购表id修改state
    int updatePurchaseAppState(@Param("id") String id,@Param("state") String state);


    //根据采购表id获取状态
    String getPurchaseAppState(String id);

    //根据管理员名字获取他的power
    int getManagerPowerByName(String name);

    //获取最新的一条审核记录
    List<PurchaseAcceptanceC> getNewestPurchaseAcceptanceC(String purchaseId);


    //更新采购表
    int updateNewPurchaseApplication(PurchaseApplicationUpdate purchaseApplicationUpdate);

    //更新采购清单
    int updateNewPurchaseList(PurchaseListUpdate purchaseListUpdate);
}
