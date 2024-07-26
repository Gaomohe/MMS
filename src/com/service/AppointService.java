package com.service;

import com.pojo.*;
import com.util.LayuiTable;

import java.util.List;

public interface AppointService {
    //删除预购药品
    public int delAppoint(int id);

    //获取全部批准
    public LayuiTable<Appointment> getAppointList(int page, int limit);

    //批量添加生成订单
    public int addAppoint(List<Integer> idList);

    //填充apply表数据
    public int insertApply();

    //获取供应商
    public List<Apply> getSupplier();

    //获取药品类型
    public List<Apply> getmType();

    //获取药品名称
    public List<Apply> getmName();

    //条件查询预购订单表
    public LayuiTable<Apply> Search(Apply apply,int page, int limit);

    //订单信息填充
    public int insertOrder(Orders orders);

    //预购信息回显
    public LayuiTable<Appointment> selectAppoint(List<Integer> idList);

    //确认生成订单
    public int Submit(List<Integer> idsList);

    //获取供应商
    public List<Apply> getStatistics();
}
