package com.example.supplychain.mapper;

import com.example.supplychain.po.SalesInfo;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.SalesInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesMapper {
    // 获取所有销量信息
    List<SalesInfoVO> selectSalesInfo();

    //增加销量
    void insertSalesInfo(SalesInfo salesInfo);

    List<String> getNewestSalesId();

    void updateWareHouse(SalesInfo salesInfo);
}
