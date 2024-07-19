package com.service.Impl;

import com.pojo.Medicine;
import com.pojo.Pharmacy;
import com.service.PharmacyService;
import com.util.LayuiTable;

import java.util.List;

import static com.util.Vessel.pharmacyDao;

public class PharmacyServiceImpl implements PharmacyService {
    //获取所有处方列表
    @Override
    public LayuiTable<Pharmacy> getPharmacyList(int page, int limit) {
        List<Pharmacy> pharmacyList = pharmacyDao.getPharmacyList(page,limit);
        int count = 0;
        for (Pharmacy pharmacy : pharmacyList) {
            boolean isPharmacy = pharmacyDao.isPharmacy(pharmacy);
            if (isPharmacy) {
                pharmacy.setIsPharmacy("是");
            }else {
                pharmacy.setIsPharmacy("否");
            }
            count++;
        }
        LayuiTable<Pharmacy> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setData(pharmacyList);
        layuiTable.setCount(count);

        return layuiTable;
    }

    //获取处方对应患者id
    @Override
    public int getpId(int phId) {
        return pharmacyDao.getpId(phId);
    }

    //获取处方中的具体药品
    @Override
    public LayuiTable<Medicine> checkPharmacy(int phId, int page, int limit) {
        List<Medicine> medicineList = pharmacyDao.checkPharmacy(phId,page,limit);
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        layuiTable.setCode(0);
        layuiTable.setMsg("");
        layuiTable.setData(medicineList);
        layuiTable.setCount(medicineList.size());
        return layuiTable;
    }
}
