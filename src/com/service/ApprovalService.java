package com.service;

import com.pojo.Apply;
import com.pojo.Appointment;
import com.util.ResultData;

import java.util.List;

public interface ApprovalService {
    public ResultData<List<Appointment>> getAuditId(int[] id);
}
