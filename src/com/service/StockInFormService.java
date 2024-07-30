package com.service;

import com.pojo.*;
import com.util.LayuiTable;

import java.util.List;

public interface StockInFormService {
    //查询全部入库单
    public List<StockInForm> getStockInFormList();
    //分页查询所有入库单
    public LayuiTable<StockInForm> selectStockInForm(int page, int limit);
    //按入库单号查询
    public StockInForm getStockInFormById(int id);
    //删除入库单
    public int delStockInFormById(int id);
    //更新入库单
    public int updateDoStockInForm(StockInForm stockInForm);
    //新增入库单
    public int addDoStockInForm(StockInWithQuality stockInWithQuality,String name,User user);
    //根据入库单号，药品名称，入库日期模糊查询
    public List<StockInForm> getStockInFormByQuery(String[] query);

    //获得订单表里所有供应商名称
    public List<Orders> getManufactorWithNoRepeat();

    //通过供应商或药品名称查询出对应的入库单（入库单表+质量检测表）
    public LayuiTable<StockInWithQuality> getStockInFormByManufactorOrDrugName(int page,int limit,String manufactor,String rName,String[] query);
    //展示所有入库单
    public LayuiTable<StockInWithQuality> getAllStockForm(int page, int limit);
}
