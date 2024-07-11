package com.service;

import com.pojo.Medicine;
import com.pojo.StockInForm;
import com.util.LayuiTable;

import java.util.List;

public interface StockInFormService {
    //查询全部入库单
    public List<StockInForm> getStockInFormList();
    //按入库单号查询，带分页
    public LayuiTable<StockInForm> selectStockInForm(int page, int limit);
    //按入库单号查询
    public StockInForm getStockInFormById(int id);
    //删除入库单
    public int delStockInFormById(int id);
    //更新入库单
    public int updateDoStockInForm(StockInForm stockInForm);
    //新增入库单
    public int addDoStockInForm(StockInForm stockInForm);

    public List<StockInForm> getStockInFormByQuery(String[] query);

//    public List<StockInForm> getStockInFormManufactorByQuery(String[] query);
}
