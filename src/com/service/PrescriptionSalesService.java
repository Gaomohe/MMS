package com.service;

import com.pojo.StockInForm;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Sale;
import com.pojo.echarts.Times;
import com.util.LayuiTable;
import com.util.ResultData;

import java.util.List;

public interface PrescriptionSalesService {
    public LayuiTable<Sale> getAll(int pages, int limits);

    public ResultData<List<Times>> getAllDay(int dayNum);

    public ResultData<List<GetString>> getChoise01();

    public ResultData<List<GetString>> getChoise02();

    public LayuiTable<Sale> search(String[] key, String[] value);

}
