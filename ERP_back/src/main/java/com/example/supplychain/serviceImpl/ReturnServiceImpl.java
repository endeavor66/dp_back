package com.example.supplychain.serviceImpl;

import com.example.supplychain.mapper.ReturnMapper;
import com.example.supplychain.po.Return;
import com.example.supplychain.service.ReturnService;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public ResponseVO getReturnInfo() {
        try{
            List<ReturnVO> result = returnMapper.selectReturn();

            return ResponseVO.buildSuccess(result);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");

        }
    }

    @Override
    public ResponseVO postReturnInfo(String salesId , String reason){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            //新增退货表
            /**
             * @id 格式定义：从1开始，自动补齐到八位String "00000001"
             */
            List<String> newestId=returnMapper.getNewestReturnId();
            String id;
            if(newestId.size()==0)
                id="00000001";
            else {
                id = autoIdAddOne(newestId.get(0));
            }
            Return salesInfo = new Return(id,salesId,simpleDateFormat.format(date),reason);
            returnMapper.insertReturnInfo(salesInfo);
            returnMapper.updateSalesReturnSate(salesId);
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
