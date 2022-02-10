package com.example.supplychain.controller;

import com.example.supplychain.service.ManagerLoginService;
import com.example.supplychain.vo.ResponseVO;
import com.example.supplychain.vo.User;
import com.example.supplychain.vo.form.ExportDataForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "登录模块测试", tags = "登录模块测试")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ManagerLoginController {

    @Autowired
    private ManagerLoginService managerLoginService;


    /**
     * 提交id对应的管理员信息，并进行密码对比(post)
     * @return
     */
    @ApiOperation(value = "提交填写的id和密码", notes = "SubmitManagerInfo")
    @PostMapping("/login")
    public ResponseVO SubmitManagerInfo(@RequestBody User user){
        return managerLoginService.submitManagerLoginInfo(user.getUserName(),user.getPassWord());
    }

    @ApiOperation(value = "获取未被导出的销量和退货数据的日期", notes = "getUnExportDate")
    @GetMapping("/getUnExportDate")
    public ResponseVO getUnExportDate(){
        return managerLoginService.getUnExportDate();
    }

    @ApiOperation(value = "导出数据", notes = "exportData")
    @PostMapping("/exportData")
    public ResponseVO exportData(@RequestBody ExportDataForm exportDataForm){
        return managerLoginService.exportData(exportDataForm);
    }
}
