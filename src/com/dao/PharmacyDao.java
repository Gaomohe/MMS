package com.dao;

import com.pojo.Pharmacy;

import java.util.List;

public interface PharmacyDao {
    //获取处方列表
    public List<Pharmacy> getPharmacyList(int page, int limit);

    //获取处方中是否含有处方药
    public boolean isPharmacy(Pharmacy pharmacy);
}
