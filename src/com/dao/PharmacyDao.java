package com.dao;

import com.pojo.Medicine;
import com.pojo.Pharmacy;
import com.pojo.User;
import com.util.LayuiTable;

import java.util.List;

public interface PharmacyDao {
    //获取处方列表
    public List<Pharmacy> getPharmacyList(int page, int limit);

    //获取处方中是否含有处方药
    public boolean isPharmacy(Pharmacy pharmacy);

    //获取处方对应患者id
    public int getpId(int phId);

    //获取处方中的具体药品
    public List<Medicine> checkPharmacy(int phId, int page, int limit);

    //患者取药
    public int getMedicine(int mId, int pId);
    public int getMedicine1(int mId, int phId);

    public List<Medicine> getMedicineValues(int pId);

    public int updateMe(int pId);

    public List<Integer> getorderId(int pId);
    public int updateMes(int id);

    public int delMe(int pId);
}