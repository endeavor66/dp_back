package com.example.supplychain.service;

import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.form.ExportDataForm;

public interface ManagerLoginService {

    //提交填写的id和密码
    ResponseVO submitManagerLoginInfo(String userName , String passWord);

    ResponseVO getUnExportDate();

    ResponseVO exportData(ExportDataForm exportDataForm);

}
