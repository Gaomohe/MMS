package com.dao;

import com.pojo.StockAllForm;
import com.pojo.StockInForm;

import java.util.List;

public interface StockAllDao {

    //查询库存所有药品
    public List<StockAllForm> selectStockAllForm();
    //分页
    public List<StockAllForm> selectStockAllForm(int page, int limit);
    //根据药品id查询该药品的库存
    public StockAllForm getStockAllFormById(int mid);
    //根据商品分类，药品名称，供货商，剂型查询
    public List<StockAllForm> getStockAllFormByQuery(String sql);

    //根据药品删除该药品的库存
    public int delStockAllForm(int id);
    //修改库存
    public int updateStockAllForm(StockAllForm stockAllForm);
    //增加库存
    public int addStockAllForm(StockAllForm stockAllForm);
}
