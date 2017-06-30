package com.example.demo.service;/**
 * Created by hand on 2017/6/24.
 */

import com.example.demo.model.SiAdjustment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 社保调整服务类
 *
 * @author zheng.zhang02@hand-china.com
 * @create 2017-06-24
 */

public interface SiAdjustmentService {
    /*根据主键查询*/
    SiAdjustment selectByPrimaryKey(Long adjustmentId);
    /*导出Excel*/
    void generateExcel(HttpServletRequest request, HttpServletResponse response);
    /*发送邮件*/
    void sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
