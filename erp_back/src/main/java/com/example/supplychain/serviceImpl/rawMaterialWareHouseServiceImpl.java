package com.example.supplychain.serviceImpl;

import com.example.supplychain.mapper.RawMaterialWareHouseMapper;
import com.example.supplychain.po.PurchaseListC;
import com.example.supplychain.po.RawMaterial;
import com.example.supplychain.po.RawMaterialType;
import com.example.supplychain.service.rawMaterialWareHouseService;
import com.example.supplychain.vo.RawMaterialWareHosueTypeVO;
import com.example.supplychain.vo.RawMaterialWareHouseVo;
import com.example.supplychain.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
    public class rawMaterialWareHouseServiceImpl implements rawMaterialWareHouseService {
    @Autowired
    private RawMaterialWareHouseMapper rawMaterialWareHouseMapper;

    /**
     * 原料仓库查看
     * @return
     */
    @Override
    public ResponseVO getRawMaterialWareHouseType() {
        try {

            //获得的是原材料类别id
            List<String> rawMaterialWareHouseTypeIdList = rawMaterialWareHouseMapper.selectAllRawMateerialTypeId();
            List<RawMaterialWareHosueTypeVO> result = new ArrayList<>();
            //获取原料类别对象数组
            List<RawMaterialType> rawMaterialTypes = new ArrayList<>();
            for (String s : rawMaterialWareHouseTypeIdList) {
                rawMaterialTypes.add(rawMaterialWareHouseMapper.selectRawMaterialTypeByRawMaterialTypeId(s));
            }
            //potovo
            for(RawMaterialType rawMaterialType:rawMaterialTypes){
                result.add(new RawMaterialWareHosueTypeVO(rawMaterialType));
            }
            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * 原料仓库增加
     * @param name
     * @return
     */
    @Override
    public ResponseVO addRawMaterialWareHouseType(String name) {
        try{
            System.out.println(name);
            //取出所有的原料类别id
            List<String> rawMaterialTypeIdList = rawMaterialWareHouseMapper.selectAllRawMateerialTypeId();
            int []IdList =new int[rawMaterialTypeIdList.size()];
            int max=0;
            for(int i =0;i<IdList.length;i++){
                IdList[i]=Integer.parseInt( rawMaterialTypeIdList.get(i));
                if(IdList[i]>max){
                    max= IdList[i];
                }
            }
            int num =max+1;
            String id =String.valueOf(num);

            char[]ary1=id.toCharArray();
            char[]ary2={'0','0','0','0'};
            System.arraycopy(ary1,0,ary2,ary2.length-ary1.length,ary1.length);
            String newId=new String(ary2);//获得新增原料类别id

            RawMaterialType temp = new RawMaterialType(newId,name);

            rawMaterialWareHouseMapper.insertRawMaterialType(temp);
            return ResponseVO.buildSuccess("写入数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * 原料仓库类别的删除
     * @param productId
     * @return
     */
    @Override
    public ResponseVO deleteRawMaterialWareHouseType(String productId) {
        try{

            /*//传过来的必须是成品类别id
            String id =String.valueOf(productId);
            //根据成品类别id获得原料类别id
            ProductRawMaterial rawMaterialTypeId =rawMaterialWareHouseMapper.selectRawMaterialTypeIdByProductTypeId(id);
            String newId =rawMaterialTypeId.getRawMateerialTypeId();
            //根据商品Id直接删除成品类别
            rawMaterialWareHouseMapper.deleteRawMaterialType(newId);*/
            rawMaterialWareHouseMapper.deleteRawMaterialType(productId);
            return ResponseVO.buildSuccess("删除数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }

    @Override
    public ResponseVO updateRawMaterialWareHouseType(String id,String name) {
        try{
            //根据id直接更新产品类别
            rawMaterialWareHouseMapper.updateRawMaterialType(id,name);
            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getRawMaterialWareHouse() {
        try {
            List<String> rawMaterialWareHouseIdList = rawMaterialWareHouseMapper.selectAllId();
            List<RawMaterialWareHouseVo> result = new ArrayList<>();
            //获取原料对象数组
            List<RawMaterial> rawMaterialwareHouses = new ArrayList<>();
            for (String s : rawMaterialWareHouseIdList) {
                rawMaterialwareHouses.add(rawMaterialWareHouseMapper.selectRawMaterialById(s));
            }
            //potovo
            for(RawMaterial rawMaterialwareHouse:rawMaterialwareHouses){
                result.add(new RawMaterialWareHouseVo(rawMaterialwareHouse));
            }
            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO addRawMaterialWareHouse(String rawMaterialId,String name,String quantity) {
        try{
            //取出所有的id
            List<String> rawMaterialIdList = rawMaterialWareHouseMapper.selectAllId();

            int []IdList =new int[rawMaterialIdList.size()];
            int max=0;
            for(int i =0;i<IdList.length;i++){
                IdList[i]=Integer.parseInt(rawMaterialIdList.get(i));
                if(IdList[i]>max){
                    max= IdList[i];
                }
            }
            int num =max+1;
            String id =String.valueOf(num);

            char[]ary1=id.toCharArray();
            char[]ary2={'0','0','0','0'};
            System.arraycopy(ary1,0,ary2,ary2.length-ary1.length,ary1.length);
            String newId=new String(ary2);//获得新增的id
            //获取日期


            int quantity1 =Integer.parseInt(quantity);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date inDate = new Date(System.currentTimeMillis());
            RawMaterial temp1 =new RawMaterial(newId,name,quantity1,simpleDateFormat.format(inDate));
            rawMaterialWareHouseMapper.insertRawMaterial(temp1);


            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * 原料仓库的删除
     * @param id
     * @return
     */
    @Override
    public ResponseVO deleteRawMaterialWareHouse(String id) {
        try{
            //id是库存编号id
            String material_name =rawMaterialWareHouseMapper.selectMaterialNameById(id);
            //根据库存编号id获得原料名称
            //RawMaterialType rawMaterialName = rawMaterialWareHouseMapper.selectRawMaterialNameByRawMaterialTypeId(rawMaterialId);
            //String newRawMaterialName = rawMaterialName.getRawMaterialName();
            //根据原料名称删除
            rawMaterialWareHouseMapper.deleteRawMaterial(material_name);
            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }
    @Override
    public ResponseVO updateRawMaterialWareHouse(String id,String quantity) {
        try{
            //Date dateStr = new Date(System.currentTimeMillis());
            rawMaterialWareHouseMapper.updateRawMaterial(id,quantity);
            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }
}
