package com.example.supplychain.controller;

import com.example.supplychain.service.ProcurementService;
import com.example.supplychain.vo.DateVO;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.SubmitAuditVO;
import com.example.supplychain.vo.form.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "采购模块测试", tags = "采购模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProcurementController {

    @Autowired
    private ProcurementService procurementService;

    /**
     * 获取传入原料id列表的供应商(done)
     */

    @ApiOperation(value = "获取传入原料id列表的供应商", notes = "getSupplier")
    @PostMapping("/purchase/getSupplier")
    public ResponseVO getSupplier(@RequestBody List<String> materialId){
       //return ResponseVO.buildSuccess(new )
        return procurementService.getSupplier(materialId);

    }

    /**
     * 提交采购清单(done)
     */
    @ApiOperation(value = "提交采购清单", notes = "submitPurchaseOrder")
    @ResponseBody
    @PostMapping("/purchase/submitPurchaseOrder")
    public ResponseVO submitPurchaseOrder(@RequestBody MaterialOverOrderForm materialOverOrderForms ){

        return procurementService.submitPurchaseOrder(materialOverOrderForms);
    }

    /**
     * 取消采购(done)
     */
    @ApiOperation(value = "取消采购", notes = "cancelPurchase")
    @GetMapping("/purchase/cancelPurchase")
    public ResponseVO cancelPurchase(@RequestParam String purchaseId){
        return procurementService.cancelPurchase(purchaseId);
    }

    /**
     * 提交审核(done)
     */
    @ApiOperation(value = "提交审核", notes = "submitAudit")
    @PostMapping("/purchase/submitAudit")
    public ResponseVO submitAudit(@RequestBody SubmitAuditVO submitAuditVO ){
        return procurementService.submitAudit(submitAuditVO.getUserId(),submitAuditVO.isResult(),submitAuditVO.getDate(),submitAuditVO.getInfo(),submitAuditVO.getPurchaseId());
    }

    /**
     * 送货进检(done)
     */
    @ApiOperation(value = "送货进检", notes = "checkCommodity")
    @PostMapping("/purchase/checkCommodity")
    public ResponseVO checkCommodity(@RequestBody MaterialOverCheckResultForm materialOverCheckResultForm){
        return procurementService.checkCommodity(materialOverCheckResultForm);
    }

    /**
     * 获取正在进行的采购清单(done)
     */
    @ApiOperation(value = "获取正在进行的采购清单", notes = "getPurchaseNowOrderList")
    @GetMapping("/purchase/getPurchaseNowOrderList")
    public ResponseVO getPurchaseNowOrderList(){
        return procurementService.getPurchaseNowOrderList();
    }

    /**
     * 获取已经完成的采购清单(done)
     */
    @ApiOperation(value = "获取已经完成的采购清单", notes = "getPurchaseDoneOrderList")
    @GetMapping("/purchase/getPurchaseDoneOrderList")
    public ResponseVO getPurchaseDoneOrderList(@RequestParam String year,@RequestParam String month){
        return procurementService.getPurchaseDoneOrderList(year,month);
    }

    /**
     * 根据id获取原料信息(done)
     */
    @ApiOperation(value = "根据id获取原料信息", notes = "getMaterial")
    @GetMapping("/purchase/getMaterial")
    public ResponseVO getMaterial(@RequestParam String id){
        return procurementService.getMaterial(id);
    }

    /**
     * 根据采购表id修改state状态(done)
     */
    @ApiOperation(value = "根据采购表id修改state状态", notes = "changePurchaseState")
    @GetMapping("/purchase/changePurchaseState")
    public ResponseVO changePurchaseState(@RequestParam String id,@RequestParam String state){
        return procurementService.changePurchaseState(id,state);
    }

    /**
     * 根据管理员级别和采购id获取状态(done)
      */
    @ApiOperation(value = "根据管理员级别和采购id获取状态", notes = "getPurchaseStatus")
    @GetMapping("/purchase/getPurchaseStatus")
    public ResponseVO getPurchaseStatus(@RequestParam String purchaseId,@RequestParam String userId){
        return procurementService.getPurchaseStatus(purchaseId,userId);
    }

    /**
     * 更新采购清单(done)
     */
    @ApiOperation(value = "更新采购清单", notes = "/purchase/updatePurchaseOrder")
    @PostMapping("/purchase/updatePurchaseOrder")
    public ResponseVO updatePurchaseOrder(@RequestBody MaterialOverOrderForm2 materialOverOrderForm2){
        return procurementService.updatePurchaseOrder(materialOverOrderForm2);
    }

}
