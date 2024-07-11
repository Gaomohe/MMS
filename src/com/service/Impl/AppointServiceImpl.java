package com.service.Impl;

import com.dao.AppointDao;
import com.dao.Impl.AppointDaoImpl;
import com.pojo.*;
import com.service.AppointService;
import com.service.ShoppingService;
import com.util.LayuiTable;
import com.util.SQLtoString;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.util.Vessel.shoppingService;

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

    //填充apply表数据
    @Override
    public int insertApply() {
        int i = 0;
        List<Medicine> medicineList = shoppingService.memoryList();
        for (Medicine medicine : medicineList) {
            List<Apply> applyList = shoppingService.subApplyList();
            for (Apply apply : applyList){
                if (apply.getmId() == medicine.getTableCoding()){
                    apply.setmId(medicine.getmId());
                    apply.setmName(medicine.getmName());
                    apply.setSpecification(medicine.getSpecification());
                    apply.setManufactor(medicine.getManufactor());
                    apply.setUnit(medicine.getUnit());
                    apply.setDepartment(medicine.getDepartment());
                    apply.setNumber(medicine.getNumber());
                    apply.setPurchasePrice(medicine.getPurchasePrice());
                    apply.setCode(medicine.getCode());
                    apply.setmType(medicine.getmType());
                    apply.setSupplier(medicine.getSupplier());
                    apply.setApprovalNumber(medicine.getApprovalNumber());
                    apply.setPlaceOrigin(medicine.getPlaceOrigin());
                    apply.setTableCoding(medicine.getTableCoding());
                    i = appointDao.insertApply(apply);
                }
            }
        }
        return i;
    }

    //获取供应商
    @Override
    public List<Apply> getSupplier() {
        int i = 1;
        List<Apply> applyList = appointDao.getSupplier();
        for (Apply apply : applyList){
            apply.setApplyId(i);
            i++;
        }
        return applyList;
    }

    //获取药品类型
    @Override
    public List<Apply> getmType() {
        int i = 1;
        List<Apply> applyList = appointDao.getmType();
        for (Apply apply : applyList){
            apply.setApplyId(i);
            i++;
        }
        return applyList;
    }

    //获取药品名称
    @Override
    public List<Apply> getmName() {
        int i = 1;
        List<Apply> applyList = appointDao.getmName();
        for (Apply apply : applyList){
            apply.setApplyId(i);
            i++;
        }
        return applyList;
    }

    //条件查询预购订单表
    @Override
    public LayuiTable<Apply> Search(Apply apply, int page, int limit) {
        String sql = "";
        String[] keys = {"mName","mType","supplier"};
        Object[] values = {apply.getmName(),apply.getmType(),apply.getSupplier()};
        sql = SQLtoString.getSQL(keys, values, "apply");
        List<Apply> searchLogList = appointDao.Search(sql);
        LayuiTable<Apply> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(searchLogList.size());
        layuiTable.setData(searchLogList);
        return layuiTable;
    }
}
