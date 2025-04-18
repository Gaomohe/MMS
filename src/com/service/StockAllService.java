package com.service;

import com.pojo.StockAllForm;
import com.util.LayuiTable;
import com.util.ResultData;

import java.util.List;

public interface StockAllService {
    public List<StockAllForm> getStockAllFormList();

    public LayuiTable<StockAllForm> selectStockAllForm(int page, int limit);
    public StockAllForm getStockAllFormById(int tableCoding);
    public int delStockAllFormById(int id);
    public int updateDoStockAllForm(StockAllForm stockAllForm);
    public int addDoStockAllForm(StockAllForm stockAllForm);
    public List<StockAllForm> getStockAllFormByQuery(String[] query);
    //根据药品名查询库存
    public List<StockAllForm> getStockAllFormByDrugName(String[] query);

    //获取药品名，药品数量
    public ResultData<List<StockAllForm>> getStockAllFormEChart();
}
