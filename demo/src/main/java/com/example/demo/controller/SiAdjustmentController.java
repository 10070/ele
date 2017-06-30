package com.example.demo.controller;/**
 * Created by hand on 2017/6/24.
 */

import com.example.demo.model.SiAdjustment;
import com.example.demo.service.SiAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 社保调整控制类
 *
 * @author zheng.zhang02@hand-china.com
 * @create 2017-06-24
 */
@RestController
public class SiAdjustmentController {
    @Autowired
    private SiAdjustmentService siAdjustment;

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String selectSimple() {
        return "Hello World";
    }

    @RequestMapping(value = "/siAdjustment/query", method = RequestMethod.POST)
    public SiAdjustment selectByCondition(Long siAdjustmentId) {
        return siAdjustment.selectByPrimaryKey(siAdjustmentId);
    }

    @RequestMapping(value = "/siAdjustment/export", method = RequestMethod.GET)
    public void exportSiAdjustmentsForExcel(HttpServletRequest request, HttpServletResponse response) {
        siAdjustment.generateExcel(request, response);
    }

    @RequestMapping(value = "/siAdjustment/send", method = RequestMethod.GET)
    public void exportSiAdjustmentsForEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        siAdjustment.sendEmail(request, response);
    }
}
