package com.dao;

import com.pojo.Medicine;
import com.pojo.Patient;
import com.util.LayuiTable;

import java.util.List;
import java.util.Map;

public interface PatientDao {
    public List<Patient> getPatients(Map<String, Object> searchCriteria);
    public List<Medicine> searchMedicine(String search);
}
