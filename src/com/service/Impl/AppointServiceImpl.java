package com.service.Impl;

import com.dao.AppointDao;
import com.dao.Impl.AppointDaoImpl;
import com.pojo.Appointment;
import com.pojo.Log;
import com.pojo.buyOrder;
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
        ResultSet resultSet = appointDaoImpl.getAll(page, limit, "apply");
        List<Appointment> appointList = new ArrayList<Appointment>();
        int count = 0;
        try {
            ResultSet userDaoAll = appointDaoImpl.getAll("apply");
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
                appointment.setApplyNumber(resultSet.getInt(8));
                appointment.setPurchasePrice(resultSet.getDouble(9));
                appointment.setCode(resultSet.getString(10));
                appointment.setmType(resultSet.getString(11));
                appointment.setSupplier(resultSet.getString(12));
                appointment.setApprovalNumber(resultSet.getString(13));
                appointment.setPlaceOrigin(resultSet.getString(14));
                appointment.setApplyUser(resultSet.getString(15));
                appointment.setApplyTime(resultSet.getString(16));
                appointment.setPharmacist(resultSet.getString(17));
                appointment.setPharmacistApprove(resultSet.getString(18));
                appointment.setPharmacistTime(resultSet.getString(19));
                appointment.setFinance(resultSet.getString(20));
                appointment.setFinanceApprove(resultSet.getString(21));
                appointment.setFinanceTime(resultSet.getString(22));
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

    //生成订单
    @Override
    public int addAppoint(List<Integer> idList) {
        double allPrice = 0;
        Appointment appointment = new Appointment();
        int count = idList.size();
        int num = 0;
        int m = 0;

        for(int id : idList){
            appointment = appointDao.getAppoint(id);
            allPrice = appointment.getNumber() * appointment.getPurchasePrice();
        }
        buyOrder buyorder = new buyOrder();
        buyorder.setAllPrice(allPrice);
        int i1 = appointDao.addOrder(buyorder);
        int bId = appointDao.getOrderId();
        for(int id : idList){
            int i = appointDao.addAppoint(id,bId);
            if (i > 0){
                num++;
            }
        }
        if (num==count){
            m = 1;
        }
        return m;
    }
}
