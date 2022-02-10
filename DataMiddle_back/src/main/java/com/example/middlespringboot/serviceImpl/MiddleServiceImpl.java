package com.example.middlespringboot.serviceImpl;

import com.example.middlespringboot.mapper.MiddleMapper;
import com.example.middlespringboot.po.Material;
import com.example.middlespringboot.po.Shop;
import com.example.middlespringboot.po.Supplier;
import com.example.middlespringboot.service.MiddleService;
import com.example.middlespringboot.vo.*;
import com.example.middlespringboot.vo.form.LoginForm;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiddleServiceImpl implements MiddleService {

    @Autowired
    private RestTemplate template;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private static final String url = "http://172.19.241.99:9001/dppresent";

    //private static final String url = "http://172.19.241.210:9001/dppresent";



    @Override
    public ResponseVO login(LoginForm loginForm){
        try{
            boolean result = template.getForObject(url+"/login?id="+loginForm.getUserName()+"&code="+loginForm.getPassWord(), boolean.class);
            if(result){
                Object loginVO=template.getForObject(url+"/loginData?managerId="+loginForm.getUserName(), Object.class);
                System.out.println(loginVO);
                return ResponseVO.buildSuccess(loginVO);
            }
            else{
                return ResponseVO.buildFailure("密码错误");
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getShopInfo(String id){
        try{
            ShopVObyD shopInfoVO=template.getForObject(url+"/getShopInfo?id="+id,ShopVObyD.class);
            return ResponseVO.buildSuccess(shopInfoVO);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getRecommendProduct(String storeId){
        try{
            RecommendProductListVO recommendProductListVO=template.getForObject(url+"/getRecommendProduct?storeId="+storeId,RecommendProductListVO.class);
            return ResponseVO.buildSuccess(recommendProductListVO.getRecomendProductVOS());
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getPredictSales(String storeId, String commodityId, String type){
        try{
            GetPredictSalesVO predictSalesVO=template.getForObject(url+"/getPredictSales?storeId="+storeId+"&commodityId="+commodityId+"&type="+type,GetPredictSalesVO.class);
            return ResponseVO.buildSuccess(predictSalesVO);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getPredictReturn(String storeId,String commodityId){
        try{
            PredictReturnVO predictReturnVO=template.getForObject(url+"/getPredictReturn?storeId="+storeId+"&commodityId="+commodityId,PredictReturnVO.class);
            return ResponseVO.buildSuccess(predictReturnVO);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getAllPredictSales(List<String> storeId,String type){
        try{
            GetPredictSalesVO predictSalesVO=template.getForObject(url+"/getAllPredictSales?storeId="+storeId+"&type="+type,GetPredictSalesVO.class);
            return ResponseVO.buildSuccess(predictSalesVO);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getAllPredictReturn(List<String> storeId){
        try{
            GetAllPredictReturnVO allPredictReturnVO=template.getForObject(url+"/getAllPredictReturn?storeId="+storeId,GetAllPredictReturnVO.class);
            return ResponseVO.buildSuccess(allPredictReturnVO);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO getAllShopInfo(List<String> storeId){
        try{
            AllShopInfoListVO allShopInfoListVO=template.getForObject(url+"/getAllShopInfo?storeId="+storeId,AllShopInfoListVO.class);
            return ResponseVO.buildSuccess(allShopInfoListVO);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    @Override
    public ResponseVO importData(String fileContent,String type,String shopId){
        try {
            String result=template.getForObject(url+"/importData?fileContent="+fileContent+"&type="+type+"&shopId="+shopId,String.class);
            if(result.equals("Success")){
                return ResponseVO.buildSuccess(result);
            }else{
                return ResponseVO.buildFailure(result);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }
}
