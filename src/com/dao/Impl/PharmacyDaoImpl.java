package com.dao.Impl;

import com.dao.PharmacyDao;
import com.pojo.Pharmacy;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PharmacyDaoImpl implements PharmacyDao {
    //获取处方列表
    @Override
    public List<Pharmacy> getPharmacyList(int page, int limit) {
        String sql = "select orderId,pId,name,dName,diagnosticTime from patient\n" +
                "inner join medicineorder on patient.mId = medicineorder.orderId\n" +
                "where medicineorder.status='未取药'\n" +
                "group by orderId,pId,name,dName,diagnosticTime;";
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        List<Pharmacy> pharmacyList = new ArrayList<Pharmacy>();
        try{
            while (resultSet.next()) {
                Pharmacy pharmacy = new Pharmacy();
                pharmacy.setPhId(resultSet.getInt("orderId"));
                pharmacy.setpId(resultSet.getInt("pId"));
                pharmacy.setpName(resultSet.getString("name"));
                pharmacy.setDoctor(resultSet.getString("dName"));
                pharmacy.setTime(resultSet.getString("diagnosticTime"));
                pharmacyList.add(pharmacy);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pharmacyList;
    }

    //获取处方中是否含有处方药
    @Override
    public boolean isPharmacy(Pharmacy pharmacy) {
        String sql = "select defined from dictionary\n" +
                "where defined='处方药' and mId in (\n" +
                "    select mId from medicineorder\n" +
                "where orderId = ?\n" +
                "    )\n" +
                "group by defined";
        Object[] objects = new Object[1];
        objects[0] = pharmacy.getPhId();
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Pharmacy> pharmacyList = new ArrayList<>();
        boolean isPharmacy = false;
        String isPharmacy1 = "";
        try{
            while (resultSet.next()) {
                isPharmacy1 = resultSet.getString("defined");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        isPharmacy = (isPharmacy1.equals("处方药"));
        return isPharmacy;
    }
}
