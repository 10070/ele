package com.example.demo.mapper;

import com.example.demo.model.SiAdjustment;
import com.example.demo.util.BaseMapper;

import java.util.List;

public interface SiAdjustmentMapper extends BaseMapper<SiAdjustment> {
    /*根据主键查询社保调整数据*/
    SiAdjustment selectSiAdjustmentByPrimaryKey(Long siAdjustmentId);
    /*查询所有社保调整数据*/
    List<SiAdjustment> selectAllSiAdjustments();
}