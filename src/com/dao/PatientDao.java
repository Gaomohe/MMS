package com.dao;

import com.pojo.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDao {
    public List<Patient> getPatients(Map<String, Object> searchCriteria);
}
