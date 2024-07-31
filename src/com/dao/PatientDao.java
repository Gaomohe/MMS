package com.dao;

import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.Pharmacy;
import com.util.LayuiTable;

import java.util.List;
import java.util.Map;

public interface PatientDao {
    //单表查病人
    public List<Patient> getPatients(Map<String, Object> searchCriteria);
    //查找药品
    public List<Medicine> searchMedicine(String search);

    public int addMedicine(Medicine medicine);

    //单表查药方
    public List<Pharmacy> getPharmacy(Map<String, Object> searchCriteria);
}
