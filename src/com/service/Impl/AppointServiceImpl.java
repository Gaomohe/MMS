package com.service.Impl;

import com.dao.AppointDao;
import com.dao.Impl.AppointDaoImpl;
import com.pojo.Appointment;
import com.pojo.Log;
import com.service.AppointService;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointServiceImpl implements AppointService {
    AppointDao appointDao = new AppointDaoImpl();
    AppointDaoImpl appointDaoImpl = new AppointDaoImpl();
    LayuiTable<Appointment> layuiTable = new LayuiTable();
    @Override
    public int delAppoint(int id) {
        return appointDao.delAppoint(id);
    }

    @Override
    public LayuiTable<Appointment> getAppointList(int page, int limit) {
        ResultSet resultSet = appointDaoImpl.getAll(page, limit, "appoint");
        List<Appointment> appointList = new ArrayList<Appointment>();
        int count = 0;
        try {
            ResultSet userDaoAll = appointDaoImpl.getAll("appoint");
            while (userDaoAll.next()){
                count++;
            }
            while (resultSet.next()){
                Appointment appointment = new Appointment();
                appointment.setmId(resultSet.getInt(1));
                appointment.setmName(resultSet.getString(2));
                appointment.setSpecification(resultSet.getString(3));
                appointment.setManufactor(resultSet.getString(4));
                appointment.setUnit(resultSet.getString(5));
                appointment.setDepartment(resultSet.getString(6));
                appointment.setNumber(resultSet.getInt(7));
                appointment.setPurchasePrice(resultSet.getDouble(8));
                appointment.setCode(resultSet.getString(9));
                appointment.setmType(resultSet.getString(10));
                appointment.setSupplier(resultSet.getString(11));
                appointment.setApprovalNumber(resultSet.getString(12));
                appointment.setPlaceOrigin(resultSet.getString(13));
                appointList.add(appointment);
            }
            layuiTable.setCode(0);
            layuiTable.setData(appointList);
            layuiTable.setCount(count);
            layuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }
}
