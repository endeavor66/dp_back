package com.example.supplychain.mapper;

import com.example.supplychain.po.Shop;
import com.example.supplychain.vo.ShopVo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopInfMapper {
    //获取所有门店id
    List<String> selectAllShopId();

    //根据门店id获得门店对象
    Shop selectShopByShopId(String shopId);

    /*根据店铺id获得店铺的名字
    String getShopNameById(String id);
    //根据店铺id获得店铺的位置
    String getShopLocationById(String id);
    //根据店铺id获得店铺的类型
    String getShopTypeById(String id);
    //根据店铺id获得店铺的成立日期
    Date getFoundDateById(String id);
    //根据店铺id获得店铺的简介
    String getShopSynopsisById(String id);
    //根据店铺id获得店铺的负责人的名字
    String getShopDirectorById(String id);
    //根据店铺id获得店铺的注册资本
    int getShopCapitalById(String id);*/
}
