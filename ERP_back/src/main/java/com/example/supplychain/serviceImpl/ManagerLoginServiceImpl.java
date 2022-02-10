package com.example.supplychain.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.supplychain.config.Tool;
import com.example.supplychain.mapper.ManagerLoginMapper;
import com.example.supplychain.po.ReturnC;
import com.example.supplychain.po.SalesC;
import com.example.supplychain.po.UnExportDate;
import com.example.supplychain.service.ManagerLoginService;
import com.example.supplychain.vo.ClientManagerVO;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.form.ExportDataForm;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedWriter;


@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {

    @Autowired
    private ManagerLoginMapper managerLoginMapper;

    @Override
    public ResponseVO submitManagerLoginInfo(String userName ,String passWord){
        try {
                ClientManagerVO result = managerLoginMapper.selectManagerInfoById(userName);

            if(result.getCode().equals(passWord))
                return ResponseVO.buildSuccess(result);
            else
                return ResponseVO.buildFailure("passWord not correct");
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("ID not exits");
        }
    }

    @Override
    public ResponseVO getUnExportDate(){
        try {
            List<Date> salesDatesDone=managerLoginMapper.selectSalesDatesDone();
            List<Date> returnDatesDone=managerLoginMapper.selectReturnDatesDone();
            List<Date> salesDates=managerLoginMapper.selectSalesDates();
            List<Date> returnDates=managerLoginMapper.selectReturnDates();
            List<Date> l1=salesDates;
            List<Date> l2=returnDates;

            DateFormat df1=DateFormat.getDateInstance();
            for(int i=0;i<salesDatesDone.size();i++){
                for(int j=0;j<salesDates.size();j++){
                    if(df1.format(salesDatesDone.get(i)).equals(df1.format(salesDates.get(j)))){
                        l1.remove(salesDates.get(j));
                    }
                }
            }
            for(int i=0;i<returnDatesDone.size();i++){
                for(int j=0;j<returnDates.size();j++){
                    if(df1.format(returnDatesDone.get(i)).equals(df1.format(returnDates.get(j)))){
                        l2.remove(returnDates.get(j));
                    }
                }
            }

            List<String> re1=new ArrayList<>();
            List<String> re2=new ArrayList<>();
            for(Date d:l1){
                re1.add(df1.format(d));
            }
            for(Date d:l2){
                re2.add(df1.format(d));
            }
            return ResponseVO.buildSuccess(new UnExportDate(re1,re2));
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("impl failed");
        }
    }

    @Override
    public ResponseVO exportData(ExportDataForm exportDataForm){
        try {
            String type=exportDataForm.getType();
            List<String> dates=exportDataForm.getDates();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
            String nowDate=df.format(new Date());
            switch (type){
                case "salesData":
                    List<SalesC> salesCList=new ArrayList<>();
                    for(String s:dates){
                        String year=s.split("年")[0];
                        String month=s.split("年")[1].split("月")[0];
                        String day1=s.split("年")[1].split("月")[1];
                        String day="";
                        for(int k=0;k<day1.length();k++){
                            if(Character.isDigit(day1.charAt(k))){
                                day=day+day1.charAt(k);
                            }
                        }
                        salesCList.addAll(managerLoginMapper.getSalesC(year,month,day));
                        Calendar calendar =Calendar.getInstance();
                        int y=Integer.valueOf(year);
                        int m=Integer.valueOf(month);
                        int z=Integer.valueOf(day);
                        calendar.set(y,m-1,z,9,0,1);
                        Date d=calendar.getTime();
                        managerLoginMapper.insertSalesDate(d);
                    }
                    Tool tool=new Tool();//创建格式化json字符串工具类
                    JSONArray jsonArray=new JSONArray();//创建JSONArray对象
                    File file=new File("jsonDataFile/salesData-"+nowDate+".json");
                    if(!file.exists())//判断文件是否存在，若不存在则新建
                    {
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream=new FileOutputStream(file);//实例化FileOutputStream
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"utf-8");//将字符流转换为字节流
                    BufferedWriter bufferedWriter= new BufferedWriter(outputStreamWriter);//创建字符缓冲输出流对象
                    for(int i=0;i<salesCList.size();i++){
                        JSONObject jsonObject=new JSONObject();//创建JSONObject对象
                        jsonObject.put("id",salesCList.get(i).getId());
                        jsonObject.put("product_id",salesCList.get(i).getProduct_id());
                        jsonObject.put("sales_date",salesCList.get(i).getSales_date());
                        jsonObject.put("num",salesCList.get(i).getNum());
                        jsonObject.put("price",salesCList.get(i).getPrice());
                        jsonArray.add(jsonObject);//将jsonObject对象加入jsonarray数组中
                    }
                    String jsonString=jsonArray.toString();//将jsonarray数组转化为字符串
                    String JsonString=tool.stringToJSON(jsonString);//将jsonarrray字符串格式化
                    bufferedWriter.write(JsonString);//将格式化的jsonarray字符串写入文件
                    bufferedWriter.flush();//清空缓冲区，强制输出数据
                    bufferedWriter.close();//关闭输出流
                    break;
                case "returnData":
                    List<ReturnC> returnCList=new ArrayList<>();
                    for(String s:dates){
                        String year=s.split("年")[0];
                        String month=s.split("年")[1].split("月")[0];
                        String day1=s.split("年")[1].split("月")[1];
                        String day="";
                        for(int k=0;k<day1.length();k++){
                            if(Character.isDigit(day1.charAt(k))){
                                day=day+day1.charAt(k);
                            }
                        }
                        returnCList.addAll(managerLoginMapper.getReturnC(year,month,day));
                        Calendar calendar =Calendar.getInstance();
                        int y=Integer.valueOf(year);
                        int m=Integer.valueOf(month);
                        int z=Integer.valueOf(day);
                        calendar.set(y,m-1,z,9,0,1);
                        Date d=calendar.getTime();
                        managerLoginMapper.insertReturnDate(d);
                    }
                    Tool tool2=new Tool();//创建格式化json字符串工具类
                    JSONArray jsonArray2=new JSONArray();//创建JSONArray对象
                    File file2=new File("jsonDataFile/returnData-"+nowDate+".json");
                    if(!file2.exists())//判断文件是否存在，若不存在则新建
                    {
                        file2.createNewFile();
                    }
                    FileOutputStream fileOutputStream2=new FileOutputStream(file2);//实例化FileOutputStream
                    OutputStreamWriter outputStreamWriter2=new OutputStreamWriter(fileOutputStream2,"utf-8");//将字符流转换为字节流
                    BufferedWriter bufferedWriter2= new BufferedWriter(outputStreamWriter2);//创建字符缓冲输出流对象
                    for(int i=0;i<returnCList.size();i++){
                        JSONObject jsonObject=new JSONObject();//创建JSONObject对象
                        jsonObject.put("id",returnCList.get(i).getId());
                        jsonObject.put("sales_id",returnCList.get(i).getSales_id());
                        jsonObject.put("return_date",returnCList.get(i).getReturn_date());
                        jsonObject.put("product_id",returnCList.get(i).getProduct_id());
                        jsonObject.put("reason",returnCList.get(i).getReason());
                        jsonObject.put("return_date",returnCList.get(i).getReturn_state());
                        jsonArray2.add(jsonObject);//将jsonObject对象加入jsonarray数组中
                    }
                    String jsonString2=jsonArray2.toString();//将jsonarray数组转化为字符串
                    String JsonString2=tool2.stringToJSON(jsonString2);//将jsonarrray字符串格式化
                    bufferedWriter2.write(JsonString2);//将格式化的jsonarray字符串写入文件
                    bufferedWriter2.flush();//清空缓冲区，强制输出数据
                    bufferedWriter2.close();//关闭输出流
                    break;
                case "commodityData":
                    break;
                case "supplierData":
                    break;
            }
            return ResponseVO.buildSuccess();
        }
        catch(Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("impl failed");
        }
    }

}
