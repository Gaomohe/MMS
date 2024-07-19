package com.service;

import com.pojo.Medicine;
import com.pojo.Pharmacy;
import com.util.LayuiTable;

public interface PharmacyService {
    //获取所有药方列表
    public LayuiTable<Pharmacy> getPharmacyList(int page,int limit);

    //获取处方对应患者id
    public int getpId(int phId);

    //获取处方中的具体药品
    public LayuiTable<Medicine> checkPharmacy(int phId,int page,int limit);
}
