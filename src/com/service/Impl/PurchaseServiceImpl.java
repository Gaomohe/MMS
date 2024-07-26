package com.service.Impl;

import com.dao.Impl.AppointDaoImpl;
import com.dao.Impl.PurchaseDaoImpl;
import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.Purchase;
import com.pojo.Role;
import com.service.PurchaseService;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.purchaseDao;

public class PurchaseServiceImpl implements PurchaseService {
    AppointDaoImpl appointDaoImpl = new AppointDaoImpl();
    LayuiTable<Appointment> layuiTable = new LayuiTable();
    PurchaseDaoImpl purchaseDao = new PurchaseDaoImpl();
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

    @Override
    public LayuiTable<Purchase> getId(int id) {
        List<Purchase> purchaseList = new ArrayList<>();
        LayuiTable<Purchase> layuiTable = new LayuiTable<>();
        ResultSet idres = purchaseDao.getId(id);
        try {
            while (idres.next()){
                Purchase purchase = new Purchase();
                purchase.setmId(idres.getInt(1));
                purchase.setApplyBuyNumber(idres.getInt(2));
                purchase.setmName(idres.getString(3));
                purchase.setSpecification(idres.getString(4));
                purchase.setManufactor(idres.getString(5));
                purchase.setUnit(idres.getString(6));
                purchase.setDepartment(idres.getString(7));
                purchase.setPurchasePrice(idres.getDouble(8));
                purchase.setSalePrice(idres.getDouble(9));
                purchase.setProductDate(idres.getString(10));
                purchase.setGoodsType(idres.getString(11));
                purchase.setmType(idres.getString(12));
                purchase.setDefined(idres.getString(13));
                purchaseList.add(purchase);
            }
            layuiTable.setData(purchaseList);
            layuiTable.setCode(0);
            layuiTable.setMsg("");


        }catch (Exception e){
            e.printStackTrace();
        }

        return layuiTable;
    }

    @Override
    public ResultData<Integer> isok(int[] ins,String name) {
        ResultData<Integer> resultData = new ResultData<>();
        for (int id:ins) {
            if (purchaseDao.isok(id,name)){
                resultData.setStatus(200);
                resultData.setData(1);
            }else {
                resultData.setStatus(400);
                resultData.setData(0);
            }
        }
        return resultData;
    }


}
