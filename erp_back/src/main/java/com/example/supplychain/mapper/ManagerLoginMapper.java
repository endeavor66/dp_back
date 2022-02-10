package com.example.supplychain.mapper;

import com.example.supplychain.po.ClientManager;
import com.example.supplychain.po.ReturnC;
import com.example.supplychain.po.SalesC;
import com.example.supplychain.vo.ClientManagerVO;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

@Repository
public interface ManagerLoginMapper {

    ClientManagerVO selectManagerInfoById(String managerId);

    //获取已经导出的销售数据的日期
    List<Date> selectSalesDatesDone();

    //获取已经导出的退货数据的日期
    List<Date> selectReturnDatesDone();

    //获取所有销售数据的日期
    List<Date> selectSalesDates();

    //获取所有的退货数据的日期
    List<Date> selectReturnDates();

    //根据年月日获取SalesC对象
    List<SalesC> getSalesC(String year,String month,String day);

    //根据年月日获取ReturnC对象
    List<ReturnC> getReturnC(String year,String month,String day);

    //将已导出的销售数据写入sales_date数据库
    int insertSalesDate(Date date);

    //将已导出的退货数据写入return_date数据库
    int insertReturnDate(Date date);

}
