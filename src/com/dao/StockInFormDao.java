package com.dao;

import com.pojo.Orders;
import com.pojo.StockInForm;
import com.pojo.StockInWithQuality;

import java.util.List;

public interface StockInFormDao {
    //查询全部入库单
    public List<StockInForm> selectStockInForm();
    //按id查询入库单
    public StockInForm getStockInFormById(int id);
    //分页
    public List<StockInForm> selectStockInForm(int page, int limit);
    //删除入库单
    public int delStockInForm(int id);
    //更新入库单
    public int updateStockInForm(StockInForm stockInForm);
    //添加入库单
    public int addStockInForm(StockInWithQuality stockInWithQuality);

    //根据入库单号，药品名称，入库日期区间查询
    public List<StockInForm> getStockInFormByQuery(String sql);

    //查询所有供应商并排除重复
    public List<Orders> getManufactorWithNoRepeat();
    //连表查询（质量检测表+入库单表）并通过供应商和药品名称得出入库单表
    public List<StockInWithQuality> getStockInFormByManufactorAndDrugName(int page, int limit);
    //获取上面这个表的长度
    public List<StockInWithQuality> getStockInFormByManufactorAndDrugName();
    //点开新增按钮后，根据连表查询结果再通过供货商，药品名称，过滤
    public List<StockInWithQuality> getStockInWithQualityByQuery(String sql,int page, int limit);
    //显示所有已入库和未入库的表
    public List<StockInWithQuality> getAllStockForm(int page, int limit);
    //获取上面这个表的长度
    public List<StockInWithQuality> getAllStockForm();
}
