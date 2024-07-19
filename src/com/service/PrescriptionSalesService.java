package com.service;

import com.pojo.echarts.Sale;
import com.util.LayuiTable;

public interface PrescriptionSalesService {
    public LayuiTable<Sale> getAll(int pages, int limits);
}
