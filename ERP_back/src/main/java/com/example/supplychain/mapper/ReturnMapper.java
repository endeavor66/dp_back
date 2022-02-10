package com.example.supplychain.mapper;

import com.example.supplychain.po.Return;
import com.example.supplychain.vo.ReturnVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnMapper {


    List<ReturnVO> selectReturn();

    List<String> getNewestReturnId();

    void insertReturnInfo(Return ReturnInfo);

    void updateSalesReturnSate(String salesId);
}
