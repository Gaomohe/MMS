package com.service;

import com.pojo.Pharmacy;
import com.util.LayuiTable;

public interface PharmacyService {
    //获取所有药方列表
    public LayuiTable<Pharmacy> getPharmacyList(int page,int limit);
}
