package com.example.supplychain.mapper;

import com.example.supplychain.po.SalesByProductId;
import com.example.supplychain.po.SalesList;
import com.example.supplychain.po.SalesRateTime;
import com.example.supplychain.po.SalesTrendGeneral;
import com.example.supplychain.vo.SalesPredictVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesPresentMapper {

    //获取销售总额
    Double selectTotalSale();

    //获取总订单数
    int selectOrderCount();

    //成品类型总数
    int selectCommodityCount();

    //根据年份查找销售额
    List<SalesTrendGeneral> selectSalesOrderByYear();

    //根据月份查找销售额
    List<SalesTrendGeneral> selectSalesOrderByMonth();

    //根据天查找销售额
    List<SalesTrendGeneral> selectSalesOrderByDay();

    //根据年份查销量前十
    List<SalesRateTime> selectSalesRateYear(String year);

    //根据月份查销量前5
    List<SalesRateTime> selectSalesRateMonth(@Param("year") String year , @Param("month")String month);


    //根据成品id查找成品名字
    String selectProductNameById(String product_id);

    //根据成品id查销售记录
    List<SalesByProductId> selectSalesByProductId(String product_id);

    //根据月份查找销售记录
    List<SalesList> selectSalesListByMonth(@Param("year")String year , @Param("month")String month);

    //获取特定天数的销售总额
    Double selectTotalSaleRecent(int days);

    //获取特定天数的总订单数
    int selectOrderCountRecent(int days);

    //根据特定天数查销售记录
    List<SalesList> selectSalesRecent(int days);

    //根据特定天数查成品销售额比率
    List<SalesRateTime> selectSalesRateRecent(int days);

    //根据特定天数查预测记录
    List<SalesPredictVO> selectSalesPredictRecent(int days);






}
