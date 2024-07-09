package com.service.Impl;

import com.dao.Impl.ApprovalDaoImpl;
import com.pojo.Apply;
import com.pojo.Appointment;
import com.service.ApprovalService;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApprovalServiceImpl implements ApprovalService {
    ApprovalDaoImpl approvalDao = new ApprovalDaoImpl();
    ResultData<List<Appointment>> appointmentResultData = new ResultData<>();
    @Override
    public ResultData<List<Appointment>> getAuditId(int[] id) {
        List<Appointment> applyList = new ArrayList<>();
                try {
                    for (int ids:id) {
                        ResultSet resultSet = approvalDao.getOne(ids, "applyId", "apply");
                    if (resultSet.next()){
                        Appointment appointment = new Appointment();
                        appointment.setApplyId(resultSet.getInt(1));
                        appointment.setmId(resultSet.getInt(2));
                        appointment.setmName(resultSet.getString(3));
                        appointment.setSpecification(resultSet.getString(4));
                        appointment.setManufactor(resultSet.getString(5));
                        appointment.setUnit(resultSet.getString(6));
                        appointment.setDepartment(resultSet.getString(7));
                        appointment.setNumber(resultSet.getInt(8));
                        appointment.setApplyNumber(resultSet.getInt(9));
                        appointment.setPurchasePrice(resultSet.getDouble(10));
                        appointment.setCode(resultSet.getString(11));
                        appointment.setmType(resultSet.getString(12));
                        appointment.setSupplier(resultSet.getString(13));
                        appointment.setApprovalNumber(resultSet.getString(14));
                        appointment.setPlaceOrigin(resultSet.getString(15));
                        appointment.setApplyUser(resultSet.getString(16));
                        appointment.setApplyTime(resultSet.getString(17));
                        appointment.setPharmacist(resultSet.getString(18));
                        appointment.setPharmacistApprove(resultSet.getString(19));
                        appointment.setPharmacistTime(resultSet.getString(20));
                        appointment.setFinance(resultSet.getString(21));
                        appointment.setFinanceApprove(resultSet.getString(22));
                        appointment.setFinanceTime(resultSet.getString(23));
                        appointment.setTableCoding(resultSet.getInt(24));
                        applyList.add(appointment);


                    }
                    }
                    appointmentResultData.setData(applyList);
                    appointmentResultData.setMsg("");
                    appointmentResultData.setStatus(200);

                }catch (Exception e){
                    e.printStackTrace();
                }

        return appointmentResultData;
    }
}
