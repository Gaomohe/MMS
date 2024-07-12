package com.dao;

import com.pojo.StockInForm;

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
    public int addStockInForm(StockInForm stockInForm);

    //根据入库单号，药品名称，入库日期区间查询
    public List<StockInForm> getStockInFormByQuery(String sql);

    //查询所有生产厂家并排除重复
    public List<StockInForm> getManufactorWithNoRepeat();
    //查询所有生产厂家对应的药品名称
    public List<StockInForm> getDrugNameByManufactor(int page, int limit);
}
