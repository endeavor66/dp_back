package com.example.supplychain.serviceImpl;

import com.example.supplychain.mapper.SalesMapper;
import com.example.supplychain.po.SalesInfo;
import com.example.supplychain.service.SalesService;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.SalesInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesMapper salesMapper;

    /**
     * (1) 获取门店销量信息
     * 已测试
     */
    @Override
    public ResponseVO getSalesInfo(){
        try{
            List<SalesInfoVO> result = salesMapper.selectSalesInfo();
            return ResponseVO.buildSuccess(result);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");

        }
    }

    /**
     * (2) 增加销量
     */
    @Override
    public ResponseVO postSalesInfo(String productId, int num){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            //新增采购表
            /**
             * @id 格式定义：从1开始，自动补齐到八位String "00000001"
             */
            List<String> newestId=salesMapper.getNewestSalesId();
            String id;
            if(newestId.size()==0)
                id="00000001";
            else {
                id = autoIdAddOne(newestId.get(0));
            }
            SalesInfo salesInfo = new SalesInfo(id,productId,num,simpleDateFormat.format(date));
            //先插入
            salesMapper.insertSalesInfo(salesInfo);
            //同步更新库存
            salesMapper.updateWareHouse(salesInfo);
            return ResponseVO.buildSuccess("添加数据成功");
        }
        catch (Exception e){
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
