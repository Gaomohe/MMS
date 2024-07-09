package com.dao;

import com.pojo.StockInForm;
import com.pojo.StockOutForm;

import java.util.List;

public interface StockOutFormDao {
    //查询全部出库单
    public List<StockOutForm> selectStockOutForm();
    //按id查询出库单
    public StockOutForm getStockOutFormById(int id);
    //分页
    public List<StockOutForm> selectStockOutForm(int page, int limit);
    //删除出库单
    public int delStockOutForm(int id);
    //更新出库单
    public int updateStockOutForm(StockOutForm stockOutForm);
    //添加出库单
    public int addStockOutForm(StockOutForm stockOutForm);
}
