package com.example.supplychain.serviceImpl;

import com.example.supplychain.mapper.ProcurementMapper;
import com.example.supplychain.po.*;
import com.example.supplychain.service.ProcurementService;
import com.example.supplychain.vo.*;
import com.example.supplychain.vo.form.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProcurementServiceImpl implements ProcurementService {

    @Autowired
    private ProcurementMapper procurementMapper;

    @Override
    public ResponseVO getSupplier(List<String> materialId){
        try{
            //List<String> MaterialIdList=procurementMapper.selectAllRawMaterialId();
            List<String> MaterialIdList=materialId;
            List<RawMaterial2SupplierVO> result=new ArrayList<>();
            for (String m : MaterialIdList){
                //获取所有供应商id列表
                List<String> supplierIdList=procurementMapper.selectSupplierIdByRawMaterialId(m);
                //获取供应商对象数组
                List<RawMaterialSupplier> rawMaterialSuppliers=new ArrayList<>();
                for(String s : supplierIdList){
                    rawMaterialSuppliers.add(procurementMapper.selectSupplierBySupplierId(s));
                }
                //POtoVO
                List<RawMaterialSupplierVO> rawMaterialSupplierVOS=new ArrayList<>();
                for(RawMaterialSupplier rawMaterialSupplier:rawMaterialSuppliers){
                    double price=procurementMapper.getPriceBySupplierAndMaterialId(rawMaterialSupplier.getId(),m);
                    rawMaterialSupplierVOS.add(new RawMaterialSupplierVO(rawMaterialSupplier,price));
                }
                //转换为返回格式
                RawMaterial2SupplierVO r2=new RawMaterial2SupplierVO(m,rawMaterialSupplierVOS);
                result.add(r2);
            }
            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO submitPurchaseOrder(MaterialOverOrderForm materialOverOrderForm){
        try{
            List<MaterialOrderForm> materialOrderForms=materialOverOrderForm.getMaterialOrderForms();
            //新增采购表
            /**
             * @id 格式定义：从1开始，自动补齐到八位String "00000001"
             */
            List<String> newestId=procurementMapper.getNewestPurchaseAppId();
            String id;
            if(newestId.size()==0)
                id="00000001";
            else {
                id = autoIdAddOne(newestId.get(0));
            }
            String managerName=materialOverOrderForm.getManagerName();
            //日期获取
            Date dateStr = new Date(System.currentTimeMillis());
            //state设置为1
            String state="1";
            procurementMapper.insertPurchaseApplication(new PurchaseApplicationC(id,dateStr,managerName,state));

            for (MaterialOrderForm m : materialOrderForms){
                //新增采购商品表
                String materialId=m.getId();
                double num=m.getNums();
                //供应商id
                String supplierId=m.getSupplierId();
                //根据supplierId和materialId获取price
                double price=procurementMapper.getPriceBySupplierAndMaterialId(supplierId,materialId);
                String purchaseListState="0";
                Date inDate=new Date(System.currentTimeMillis());
                procurementMapper.insertPurchaseList(new PurchaseListC(id,materialId,num,price,supplierId,purchaseListState,inDate));
            }
            return ResponseVO.buildSuccess("采购清单提交成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO cancelPurchase(String purchaseId){
        try{
            procurementMapper.deletePurchaseAcceptance(purchaseId);
            procurementMapper.deletePurchaseList(purchaseId);
            procurementMapper.deletePurchaseApplication(purchaseId);
            return ResponseVO.buildSuccess("采购清单取消成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO submitAudit(String userId,boolean result,String date,String info,String pId){
        try{
            List<String> newestId=procurementMapper.getNewestPurchaseAccId();
            String id;
            if(newestId.size()==0)
                id="00000001";
            else {
                id = autoIdAddOne(newestId.get(0));
            }
            String purchaseId=pId;
            String auditClass=String.valueOf(procurementMapper.getPowerByManagerId(userId));
            String auditResult=String.valueOf(result);
            String managerName=procurementMapper.getManagerNameById(userId);
            //没有使用前端传过来的date, 使用当前时间, 方便格式转化
            Date auditDate=new Date(System.currentTimeMillis());
            String note=info;
            //新增采购审核表
            procurementMapper.insertPurchaseAcceptance(new PurchaseAcceptanceC(id,purchaseId,auditClass,auditResult,managerName,auditDate,note));
            //更新采购表状态
            //更新采购商品表状态
            if(result) {
                if(procurementMapper.getPowerByManagerId(userId)==3) {
                    procurementMapper.updatePurchaseApplication(pId, "3");
                }
            }
            else {
                procurementMapper.updatePurchaseApplication(pId,"2");
            }
            return ResponseVO.buildSuccess("提交审核完成");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO checkCommodity(MaterialOverCheckResultForm materialOverCheckResultForm){
        try{
            //采购表state改为6(已完成)
            String id=materialOverCheckResultForm.getPurchaseId();
            List<MaterialCheckResultForm> materialCheckResultForms=materialOverCheckResultForm.getMaterialCheckResultForms();
            procurementMapper.updatePurchaseApplication(id,"6");
            for(MaterialCheckResultForm m:materialCheckResultForms){
                if(m.getResult()){
                    procurementMapper.updatePurchaseList(m.getId(),id,"1");
                    //更新仓库库存
                    //获取该原材料的数量
                    double num=procurementMapper.getNumByPurchaseIdAndMaterialId(id,m.getId());
                    int quantity=(int)num;
                    //1、生成id
                    List<String> newestId=procurementMapper.getNewestWarehouseMaterialId();
                    String warehouseId;
                    if(newestId.size()==0)
                        warehouseId="00000001";
                    else {
                        warehouseId = autoIdAddOne(newestId.get(0));
                    }
                    //2、根据原料id获取原料名
                    String materialName=procurementMapper.getMaterialNameByMaterialId(m.getId());
                    //3、由于外键原因，需要修改采购商品表的时间
                    Date inDate=new Date(System.currentTimeMillis());
                    procurementMapper.updatePurchaseListDate(new PurchaseListDateUpdate(id,m.getId(),inDate));
                    //4、写入原料仓库
                    procurementMapper.insertMaterialWarehouse(new WarehouseMaterialC(warehouseId,materialName,quantity,inDate));
                }
                else{
                    procurementMapper.updatePurchaseList(m.getId(),id,"-1");
                }
            }
            return ResponseVO.buildSuccess("送货进检成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getPurchaseNowOrderList(){
        try{
            List<PurchaseApplicationC> purchaseApplicationCS=procurementMapper.getPurchasingApplication();
            List<OrderForShowVO> orderForShowVOS=new ArrayList<>();
            for (PurchaseApplicationC p:purchaseApplicationCS){
                OrderForShowVO orderForShowVO=new OrderForShowVO();
                orderForShowVO.setId(p.getId());
                orderForShowVO.setInDate(p.getSubDate());
                orderForShowVO.setOperator(p.getManagerName());
                orderForShowVO.setStatus(p.getState());
                //审核状态
                List<PurchaseAcceptanceC> purchaseAcceptanceCList=procurementMapper.getPurchaseAcceptance(p.getId());
                List<PurchaseCheckInfoVO> purchaseCheckInfoVOS=new ArrayList<>();
                for(PurchaseAcceptanceC a:purchaseAcceptanceCList){
                    PurchaseCheckInfoVO purchaseCheckInfoVO=new PurchaseCheckInfoVO();
                    purchaseCheckInfoVO.setLevel(Integer.valueOf(a.getAuditClass()));
                    purchaseCheckInfoVO.setOperator(a.getManagerName());
                    purchaseCheckInfoVO.setDate(a.getDate());
                    String auditResult=a.getResult();
                    if(auditResult.equals("true")||auditResult.equals("True")||auditResult.equals("TRUE"))
                        purchaseCheckInfoVO.setResult(true);
                    else
                        purchaseCheckInfoVO.setResult(false);
                    purchaseCheckInfoVO.setComment(a.getNote());
                    purchaseCheckInfoVOS.add(purchaseCheckInfoVO);
                }
                orderForShowVO.setCheckInfo(purchaseCheckInfoVOS);
                //原料对象
                List<MaterialForShowVO> materialForShowVOS=new ArrayList<>();
                List<PurchaseListC> tmp=procurementMapper.getPurchasingList(p.getId());
                for(PurchaseListC l:tmp){
                    MaterialForShowVO m=new MaterialForShowVO();
                    m.setMaterialId(l.getMaterialId());
                    m.setNum((int)l.getNum());
                    m.setName(procurementMapper.getMaterialNameByMaterialId(l.getMaterialId()));
                    RawMaterialSupplierVO r=new RawMaterialSupplierVO(procurementMapper.selectSupplierBySupplierId(l.getSupplierId()),procurementMapper.getPriceBySupplierAndMaterialId(l.getSupplierId(),l.getMaterialId()));
                    m.setSupplier(r);
                    materialForShowVOS.add(m);
                }
                orderForShowVO.setMaterials(materialForShowVOS);
                orderForShowVOS.add(orderForShowVO);
            }
            return ResponseVO.buildSuccess(orderForShowVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getPurchaseDoneOrderList(String year,String month){
        try{
            List<PurchaseApplicationC> purchaseApplicationCS=procurementMapper.getPurchasedApplication(year,month);
            List<OrderForShowVO> orderForShowVOS=new ArrayList<>();
            for (PurchaseApplicationC p:purchaseApplicationCS){
                OrderForShowVO orderForShowVO=new OrderForShowVO();
                orderForShowVO.setId(p.getId());
                orderForShowVO.setInDate(p.getSubDate());
                orderForShowVO.setOperator(p.getManagerName());
                orderForShowVO.setStatus(p.getState());
                List<MaterialForShowVO> materialForShowVOS=new ArrayList<>();
                List<PurchaseListC> tmp=procurementMapper.getPurchasedList(p.getId());
                for(PurchaseListC l:tmp){
                    MaterialForShowVO m=new MaterialForShowVO();
                    m.setMaterialId(l.getMaterialId());
                    m.setNum((int)l.getNum());
                    m.setName(procurementMapper.getMaterialNameByMaterialId(l.getMaterialId()));
                    RawMaterialSupplierVO r=new RawMaterialSupplierVO(procurementMapper.selectSupplierBySupplierId(l.getSupplierId()),procurementMapper.getPriceBySupplierAndMaterialId(l.getSupplierId(),l.getMaterialId()));
                    m.setSupplier(r);
                    if(l.getPurchaseListState().equals("1"))
                        m.setCheckedResult(true);
                    else
                        m.setCheckedResult(false);
                    materialForShowVOS.add(m);
                }
                orderForShowVO.setMaterials(materialForShowVOS);
                orderForShowVOS.add(orderForShowVO);
            }
            return ResponseVO.buildSuccess(orderForShowVOS);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getMaterial(String id){
        try{
            RawMaterialName rawMaterial=procurementMapper.getMaterialInfo(id);
            return ResponseVO.buildSuccess(new RawMaterialVO(rawMaterial));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO changePurchaseState(String id,String state){
        try{
            procurementMapper.updatePurchaseAppState(id,state);
            return ResponseVO.buildSuccess("修改状态成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getPurchaseStatus(String purchaseId,String userId){
        try{
            int re=9;
            int managerPower=procurementMapper.getPowerByManagerId(userId);
            String purchaseState=procurementMapper.getPurchaseAppState(purchaseId);
            if(purchaseState.equals("2"))
                re=2;
            else if(purchaseState.equals("3"))
                re=4;
            else if(purchaseState.equals("4"))
                re=5;
            else if(purchaseState.equals("5"))
                re=6;
            else {
                //获取指定采购表id的最新的一条审核记录
                List<PurchaseAcceptanceC> purchaseAcceptanceC = procurementMapper.getNewestPurchaseAcceptanceC(purchaseId);
                if (purchaseAcceptanceC.size() == 0) {
                    if (managerPower == 1) {
                        re = 1;
                    } else {
                        re = 0;
                    }
                } else {
                    String lastManagerName = purchaseAcceptanceC.get(0).getManagerName();
                    int lastManagerPower = procurementMapper.getManagerPowerByName(lastManagerName);
                    if (managerPower-lastManagerPower==1) {
                        re=1;
                    }
                    else{
                        re=0;
                    }
                }
            }
            return ResponseVO.buildSuccess(re);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO updatePurchaseOrder(MaterialOverOrderForm2 materialOverOrderForm2){
        try{
            //更新采购表
            Date inDate=new Date(System.currentTimeMillis());
            procurementMapper.updateNewPurchaseApplication(new PurchaseApplicationUpdate(materialOverOrderForm2.getId(),inDate,materialOverOrderForm2.getManagerName()));
            //更新采购商品表
            List<MaterialOrderForm> materialOrderForms=materialOverOrderForm2.getMaterialOrderForms();
            for(MaterialOrderForm m:materialOrderForms){
                double price=procurementMapper.getPriceBySupplierAndMaterialId(m.getSupplierId(),m.getId());
                procurementMapper.updateNewPurchaseList(new PurchaseListUpdate(materialOverOrderForm2.getId(),m.getId(),m.getNums(),price,m.getSupplierId()));
            }
            return ResponseVO.buildSuccess("更新清单成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }




    /**
     * 自动生成ID的方法
     * @param oldId
     * @return
     */
    private String autoIdAddOne(String oldId){
        int num=Integer.parseInt(oldId);
        num=num+1;
        String numStr=String.valueOf(num);
        String zeroIn="";
        for (int i=0;i<8-numStr.length();i++){
            zeroIn=zeroIn+"0";
        }
        numStr=zeroIn+numStr;
        return numStr;
    }
}
