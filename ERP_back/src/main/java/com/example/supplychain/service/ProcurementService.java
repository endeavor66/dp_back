package com.example.supplychain.service;

import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.form.*;

import java.util.List;

public interface ProcurementService {

    //获取所有原料对应的供应商
    ResponseVO getSupplier(List<String> materialId);

    //提交采购清单
    ResponseVO submitPurchaseOrder(MaterialOverOrderForm materialOverOrderForms);

    //取消采购
    ResponseVO cancelPurchase(String purchaseId);

    //提交审核
    ResponseVO submitAudit(String userId,boolean result,String date,String info,String purchaseId);

    //送货进检
    ResponseVO checkCommodity(MaterialOverCheckResultForm materialOverCheckResultForm);

    //获取正在进行的采购清单
    ResponseVO getPurchaseNowOrderList();

    //获取已经完成的采购清单
    ResponseVO getPurchaseDoneOrderList(String year,String month);

    //根据id获取原料信息
    ResponseVO getMaterial(String id);

    //根据id更改采购表状态
    ResponseVO changePurchaseState(String id,String state);

    //根据管理员级别和采购id获取状态
    ResponseVO getPurchaseStatus(String purchaseId,String userId);

    //更新采购清单
    ResponseVO updatePurchaseOrder(MaterialOverOrderForm2 materialOverOrderForm2);
}
