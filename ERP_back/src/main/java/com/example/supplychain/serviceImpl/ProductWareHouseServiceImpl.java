package com.example.supplychain.serviceImpl;

import com.example.supplychain.mapper.RawMaterialWareHouseMapper;
import com.example.supplychain.mapper.WareHouseMapper;
import com.example.supplychain.po.*;
import com.example.supplychain.service.ProductWareHouseService;
import com.example.supplychain.vo.MaterialNeedVO;
import com.example.supplychain.vo.ProductTypeVO;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.WareHouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
    public class ProductWareHouseServiceImpl implements ProductWareHouseService {
    @Autowired
    private WareHouseMapper wareHouseMapper;

    @Autowired
    private RawMaterialWareHouseMapper rawMaterialWareHouseMapper;

    /**
     *成品类别信息查看
     * @return
     */
    @Override
    public ResponseVO getProductWareHouseType() {
        try {
            //获取所有成品库存类别的id
            List<String> ProductTypeIdList = wareHouseMapper.selectAllProductTypeId();
            List<ProductTypeVO> result = new ArrayList<>();
            List<MaterialNeedVO> materials = new ArrayList<>();

            for(int i =0 ;i<ProductTypeIdList.size();i++){
                String productTypeId = ProductTypeIdList.get(i);
                String productTypeName = wareHouseMapper.selectNameById(productTypeId);
                //根据productId获取materialId,注意这边是一对多的关系
                List<String> materialId = wareHouseMapper.selectMaterialIdByProductId(productTypeId);
                for(int j =0;j<materialId.size();j++){
                    String id = materialId.get(j);
                    String materialName = wareHouseMapper.selectMaterialNameByMaterialId(id);
                    materials.add(new MaterialNeedVO(id,materialName));
                }
                result.add(new ProductTypeVO(productTypeId,productTypeName,materials));
            }
            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * 成品仓库的查看
     * @return
     */
    @Override
    public ResponseVO getProductWareHouse() {
        try {
            List<String> WareHouseIdList = wareHouseMapper.selectAllProductId();
            List<WareHouseVo> result = new ArrayList<>();
            List<Product> productIdList =new ArrayList<>();
            List<ProductType> productNameList =new ArrayList<>();
            //获取门店对象数组
            List<Product> wareHouses = new ArrayList<>();
            for(int i=0;i<WareHouseIdList.size();i++){
                productIdList.add(wareHouseMapper.selectProductIdById(WareHouseIdList.get(i)));
            }
            for(int i=0;i<productIdList.size();i++){
                Product product=productIdList.get(i);
                String productId=product.getProductId();
                ProductType productType=wareHouseMapper.selectProductNameByProductId(productId);
                productNameList.add(productType);
            }
            for (String s : WareHouseIdList) {
                wareHouses.add(wareHouseMapper.selectWareHouseByProductId(s));
            }
            //potovo
            for(int i=0;i<WareHouseIdList.size();i++){

                result.add(new WareHouseVo(productIdList.get(i),(productNameList.get(i)).getProductName()));
            }
            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * 成品类别的增加
     * @param productName
     * @param materials
     * @param price
     * @return
     */
    @Override
    public ResponseVO addProductWareHouseType(String productName,List<String> materials,int price) {
        try{

            List<String> productWareHouseTypeIdList = wareHouseMapper.selectAllProductTypeId();
            int []IdList =new int[productWareHouseTypeIdList.size()];
            int max=0;
            for(int i =0;i<IdList.length;i++){
                IdList[i]=Integer.parseInt(productWareHouseTypeIdList.get(i));
                if(IdList[i]>max){
                    max= IdList[i];
                }
            }
            int num =IdList[IdList.length-1]+1;
            String id =String.valueOf(num);

            char[]ary1=id.toCharArray();
            char[]ary2={'0','0','0','0'};
            System.arraycopy(ary1,0,ary2,ary2.length-ary1.length,ary1.length);
            String newId=new String(ary2);//获得新增成品类id

            ProductType temp =new ProductType(newId,productName,price);

            wareHouseMapper.insertProductWareHouseType(temp);
            //需要增加成品原料关系表的数据
            for(int i = 0;i<materials.size();i++){
                String materialId = materials.get(i);
                ProductRawMaterial result =new ProductRawMaterial(newId,materialId);
                wareHouseMapper.insertProductRawMaterial(result);
            }


            return ResponseVO.buildSuccess("写入数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * 成品仓库增加
     * @param productId
     * @param name
     * @param quantity
     * @return
     */
    @Override
    public ResponseVO addProductWareHouse(String productId,String name,String quantity) {
        try{
            //根据成品类别id获得原料类别id
            List<ProductRawMaterial> rawMaterialTypeId=new ArrayList<>() ;
            rawMaterialTypeId =rawMaterialWareHouseMapper.selectRawMaterialTypeIdByProductTypeId(productId);
            List<String> newRawMaterialTypeId =new ArrayList<>();
            List<String> newRawMaterialName =new ArrayList<>();
            int []number = new int[10000];
            for(ProductRawMaterial s:rawMaterialTypeId){
                newRawMaterialTypeId.add(s.getRawMateerialTypeId());
            }
            //根据原料类别id从原料类别表中获得原料名称
            for(int i =0;i<newRawMaterialTypeId.size();i++) {
                RawMaterialType rawMaterialName = rawMaterialWareHouseMapper.selectRawMaterialNameByRawMaterialTypeId(newRawMaterialTypeId.get(i));
                String newName = rawMaterialName.getRawMaterialName();
                newRawMaterialName.add(newName);
            }

            //根据原料名称从原料库存表中获取原料的数量，与quantity比较
            for(int i=0;i<newRawMaterialName.size();i++) {
                int numTotal =0;
                List<RawMaterial> num1 = rawMaterialWareHouseMapper.selectNumByRawMaterialName(newRawMaterialName.get(i));
                for(int j =0;j<num1.size();j++){
                    numTotal = numTotal+num1.get(j).getNums();//先对全部求和

                }
                if(numTotal<Integer.parseInt(quantity)){
                    return ResponseVO.buildFailure("Impl failed");
                }
                else {
                    int temp =Integer.parseInt(quantity);
                    for(int i1=0;i1<num1.size();i1++){
                        int a =num1.get(i1).getNums();
                        String b =newRawMaterialTypeId.get(i1);//获得对应的原料名称
                        String c =num1.get(i1).getId();
                        if(temp<=a){
                            rawMaterialWareHouseMapper.updateRawMaterialNumByRawMaterialName(b,String.valueOf(a-temp));
                            break;
                        }
                        else {
                            temp=temp-a;
                            rawMaterialWareHouseMapper.deleteRawMaterialById(c);
                        }
                    }
                }
            }

            //取出所有的id
            List<String> productWareHouseIdList = wareHouseMapper.selectAllProductId();
            int []IdList =new int[productWareHouseIdList.size()];
            int max=0;
            for(int i =0;i<IdList.length;i++){
                IdList[i]=Integer.parseInt(productWareHouseIdList.get(i));
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
            int quantity1=Integer.parseInt(quantity);
            //获取日期
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateStr = new Date(System.currentTimeMillis());

            Product temp1 =new Product(newId,productId,Integer.parseInt(quantity),simpleDateFormat.format(dateStr));

            wareHouseMapper.insertWareHouse(temp1);
            //记录的同时要删去消耗的原料
            //rawMaterialWareHouseMapper.updateRawMaterial(newRawMaterialTypeId,String.valueOf(num2-Quantity));
            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO deleteProductWareHouseType(String productId) {
        try{
            String id =String.valueOf(productId);
            //根据商品Id直接删除成品类别
            wareHouseMapper.deleteWareHouseTypeList(id);
            return ResponseVO.buildSuccess("删除数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }

    @Override
    public ResponseVO deleteProductWareHouse(String id) {
        try{
            //id不是成品种类的id
            //根据商品Id直接删除成品
            wareHouseMapper.deleteWareHouseList(id);
            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }

    @Override
    public ResponseVO updateProductWareHouseType(String id,String name,List<String> materials) {
        try{
            //根据商品Id直接更新产品类别
            wareHouseMapper.updateProductWareHouseTypeList(id,name);
            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO updateProductWareHouse(String id,String quantity) {
        try{
            int num =Integer.parseInt(quantity);
            //Date dateStr = new Date(System.currentTimeMillis());
            wareHouseMapper.updateQuantityById(id,num);
            return ResponseVO.buildSuccess("更新数据成功");
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }
}
