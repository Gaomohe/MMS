package com.service;

import com.pojo.echarts.NonConformanceApproval;
import com.pojo.echarts.Sale;
import com.util.LayuiTable;

public interface PharmaceuticalSalesService {
    public LayuiTable<Sale> getAll(int pages, int limits);
}
