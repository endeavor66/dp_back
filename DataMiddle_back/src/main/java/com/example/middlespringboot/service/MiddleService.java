package com.example.middlespringboot.service;

import com.example.middlespringboot.vo.ResponseVO;
import com.example.middlespringboot.vo.form.LoginForm;

import java.util.List;

public interface MiddleService {

    ResponseVO login(LoginForm loginForm);

    ResponseVO getShopInfo(String id);

    ResponseVO getRecommendProduct(String storeId);

    ResponseVO getPredictSales(String storeId, String commodityId, String type);

    ResponseVO getPredictReturn(String storeId,String commodityId);

    ResponseVO getAllPredictSales(List<String> storeId,String type);

    ResponseVO getAllPredictReturn(List<String> storeId);

    ResponseVO getAllShopInfo(List<String> storeId);

    ResponseVO importData(String fileContent,String type,String shopId);
}
