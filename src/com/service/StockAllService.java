package com.service;

import com.pojo.StockAllForm;
import com.util.LayuiTable;

import java.util.List;

public interface StockAllService {
    public List<StockAllForm> getStockAllFormList();

    public LayuiTable<StockAllForm> selectStockAllForm(int page, int limit);
    public StockAllForm getStockAllFormById(int mid);
    public int delStockAllFormById(int id);
    public int updateDoStockAllForm(StockAllForm stockAllForm);
    public int addDoStockAllForm(StockAllForm stockAllForm);
}