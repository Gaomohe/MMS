package com.service;

import com.pojo.Medicine;
import com.pojo.Pharmacy;
import com.pojo.User;
import com.util.LayuiTable;

import java.util.Map;

public interface PharmacyService {
    //获取所有药方列表
    public LayuiTable<Pharmacy> getPharmacyList(int page,int limit);

    //获取处方对应患者id
    public int getpId(int phId);

    //获取处方中的具体药品
    public LayuiTable<Medicine> checkPharmacy(int phId,int page,int limit);

    //患者取药
    public int getMedicine(int mId, int pId, int phId);

    //单框查询
    public LayuiTable<Pharmacy> selectPatient(Map<String, Object> searchCriteria);
}
