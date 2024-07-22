package com.service;

import com.pojo.Medicine;
import com.pojo.echarts.IneligibleApplications;
import com.util.LayuiTable;

public interface IneligibleApplicationsService {
    public LayuiTable<IneligibleApplications> getAll(int pages, int limits);
}
