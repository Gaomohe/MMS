package com.service;

import com.pojo.Apply;
import com.util.LayuiTable;

public interface FinancialService {
    //条件查询所有财务审批
    public LayuiTable<Apply> getAppointList(int page, int limit, Apply apply);
}
