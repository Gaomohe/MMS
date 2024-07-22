package com.service;

import com.pojo.echarts.IneligibleApplications;
import com.pojo.echarts.NonConformanceApproval;
import com.util.LayuiTable;

public interface NonConformanceApprovalService {
    public LayuiTable<NonConformanceApproval> getAll(int pages,int limits);
}
