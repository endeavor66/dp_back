package com.example.supplychain.serviceImpl;


import com.example.supplychain.mapper.SalesPresentMapper;
import com.example.supplychain.po.SalesByProductId;
import com.example.supplychain.po.SalesList;
import com.example.supplychain.po.SalesRateTime;
import com.example.supplychain.po.SalesTrendGeneral;
import com.example.supplychain.service.SalesPresentService;
import com.example.supplychain.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.groups.ConvertGroup;
import java.util.ArrayList;
import java.util.List;



@Service
public class SalesPresentServiceImpl implements SalesPresentService {

    @Autowired
    private SalesPresentMapper salesPresentMapper;

    //@Autowired
    //private RestTemplate template;

    //private static final String url = "http://localhost:9001/client";
    /**
     * (1) 获取门店总销量基本信息
     * 已完成测试
     */
    @Override
    public ResponseVO getBasicSalesInfo(){
        try{

            Double totalSale = salesPresentMapper.selectTotalSale();
            int orderCount = salesPresentMapper.selectOrderCount();
            int commodityCount = salesPresentMapper.selectCommodityCount();

            SalesBasicInfoVO result  = new SalesBasicInfoVO(totalSale,orderCount,commodityCount);

            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * (2) 获取销售金额走势
     * 已完成测试
     */
    @Override
    public ResponseVO getSalesTrend(String type){
        try{
            //显示范围  年：全部；月份：12；天：15天
            List<SalesTrendGeneral> sqlResult = null;
            List<String> time = new ArrayList<>();
            List<Double> trend = new ArrayList<>();

            if(type.equals("year"))
                sqlResult = salesPresentMapper.selectSalesOrderByYear();
            else if(type.equals("month"))
                sqlResult = salesPresentMapper.selectSalesOrderByMonth();
            else
                sqlResult = salesPresentMapper.selectSalesOrderByDay();

            for(SalesTrendGeneral m : sqlResult){
                time.add(m.getTime());
                trend.add(m.getSalesAmount());
            }

            SalesTrendVO result = new SalesTrendVO(type,time,trend);

            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }
    }

    /**
     * (3) 根据指定年份获取Top10商品的销售金额占比
     * 已完成测试
     * TODO
     */
    @Override
    public ResponseVO getYearSalesRate(String year){
        try{
            //TODO:
            List<SalesRateTime> sqlResult = salesPresentMapper.selectSalesRateYear(year);

            List<String> commocity = new ArrayList<>();
            List<Double> rate = new ArrayList<>();
            Double sum = 0.0, temp;

            //拿成品名称

            for(SalesRateTime m : sqlResult){
                commocity.add(salesPresentMapper.selectProductNameById(m.getProduct_id()));
                sum += m.getSalesAmount();

            }

            //算销售额比率
            for(SalesRateTime p : sqlResult){
                temp = p.getSalesAmount()/sum;
                rate.add(temp*100);

            }

            SalesTop10InYearVO result = new SalesTop10InYearVO(year,commocity,rate);

            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("该年份无销售记录");
        }
    }



    /**
     * (4) 根据指定月份获取Top5商品的销售占比
     * 已完成测试
     * TODO 数据量不足
     */
    @Override
    public ResponseVO getMonthSalesRate(String year , String month){
        try{
            List<SalesRateTime> sqlResult = salesPresentMapper.selectSalesRateMonth(year,month);

            List<String> commocity = new ArrayList<>();
            List<Double> rate = new ArrayList<>();
            Double sum = 0.0, temp;

            //拿成品名称

            for(SalesRateTime m : sqlResult){
                commocity.add(salesPresentMapper.selectProductNameById(m.getProduct_id()));
                sum += m.getSalesAmount();

            }

            //算销售额比率
            for(SalesRateTime p : sqlResult){
                temp = p.getSalesAmount()/sum;
                rate.add(temp*100);

            }

            SalesTop5InMonthVO result = new SalesTop5InMonthVO(year,month,commocity,rate);

            return ResponseVO.buildSuccess(result);

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }

    /**
     * (5) 获取指定商品近年的销售额走势
     * 已完成测试
     */
    @Override
    public ResponseVO getCommoditySalesTrend(String product_id){
        try{

            List<SalesByProductId> sqlResult = salesPresentMapper.selectSalesByProductId(product_id);

            return ResponseVO.buildSuccess(sqlResult);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }

    /**
     * (6) 获取销售订单
     * 已完成测试
     */
    @Override
    public ResponseVO getOrderList(String year , String mouth){
        try{
            List<SalesList> sqlResult = salesPresentMapper.selectSalesListByMonth(year,mouth);

            return ResponseVO.buildSuccess(sqlResult);

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }

    /**
     * (7) 获取近日销量基本信息
     * 预测值结构可能会和前端不一致
     * 已完成测试
     */
    @Override
    public ResponseVO getRecentSalesInfo(String type){
        try{
            Double totalSale ;

            int orderCount ;

            List<String> commocity = new ArrayList<>();
            List<Double> rate = new ArrayList<>();
            List<SalesRateTime> sqlResult;

            List<String> times = new ArrayList<>();

            List<Double> actual = new ArrayList<>();

            List<Double> predict = new ArrayList<>();

            SalesPredictListVO sqlResultP;

            Double sum = 0.0, temp;



            List<SalesList> salesLists = null;


            if(type.equals("day")){
                totalSale = salesPresentMapper.selectTotalSaleRecent(1);
                orderCount = salesPresentMapper.selectOrderCountRecent(1);

                //sqlResultP=template.getForObject(url+"/getStoreSalePredict?id="+id+"&days=1",SalesPredictListVO.class);
                //sqlResultP = salesPresentMapper.selectSalesPredictRecent(1);

                salesLists = salesPresentMapper.selectSalesRecent(1);

                sqlResult = salesPresentMapper.selectSalesRateRecent(1);

            }
            else if(type.equals("week")){
                totalSale = salesPresentMapper.selectTotalSaleRecent(7);
                orderCount = salesPresentMapper.selectOrderCountRecent(7);

                //sqlResultP=template.getForObject(url+"/getStoreSalePredict?id="+id+"&days=7",SalesPredictListVO.class);

                sqlResult = salesPresentMapper.selectSalesRateRecent(7);

                salesLists = salesPresentMapper.selectSalesRecent(7);

            }
            else{
                totalSale = salesPresentMapper.selectTotalSaleRecent(30);
                orderCount = salesPresentMapper.selectOrderCountRecent(30);

                //sqlResultP=template.getForObject(url+"/getStoreSalePredict?id="+id+"&days=30",SalesPredictListVO.class);

                sqlResult = salesPresentMapper.selectSalesRateRecent(30);

                salesLists = salesPresentMapper.selectSalesRecent(30);

            }
            try {

                //拿成品名称
                for (SalesRateTime m : sqlResult) {
                    commocity.add(salesPresentMapper.selectProductNameById(m.getProduct_id()));
                    sum += m.getSalesAmount();

                }

                //算销售额比率
                for (SalesRateTime p : sqlResult) {
                    temp = p.getSalesAmount() / sum;
                    rate.add(temp * 100);

                }

            }
            catch (Exception e){
                System.out.println("无销售数据");
                return ResponseVO.buildFailure("Impl failed");
            }

            /*
            for(SalesPredictVO p : sqlResultP.getSalesPredictVOS()){
                times.add(p.getTimes());
                actual.add(p.getActual());
                predict.add(p.getPredict());
            }
            */

            SalesRecentVO result = new SalesRecentVO();

            result.setTotalSale(totalSale);
            result.setOrderCount(orderCount);
            result.setTimes(times);
            result.setActual(actual);
            result.setPredict(predict);
            result.setSalesLists(salesLists);
            result.setCommocity(commocity);
            result.setRate(rate);

            System.out.println(commocity);
            System.out.println(sqlResult.size());
            System.out.println(" ");


            return ResponseVO.buildSuccess(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("Impl failed");
        }

    }


}
