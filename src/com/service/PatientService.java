package com.service;

import com.pojo.Patient;
import com.util.LayuiTable;

import java.util.Map;

public interface PatientService {
    public LayuiTable<Patient> selectPatient(Map<String, Object> searchCriteria);
}
