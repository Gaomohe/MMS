package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.MiddlemanDao;
import com.pojo.Middleman;
import com.util.JDBC;

public class MiddlemanDaoImpl extends InitDaoImpl implements MiddlemanDao {
    @Override
    public boolean updateMiddleMan(Middleman middleman) {
        String sql = "update middleman set mName=?,tel=?,email=?,department=?,medName=?,standard=?,medNum=?,date=?,place=?,supplierName=? where workId=?";
        Object[] objects = new Object[]{middleman.getmName(),middleman.getTel(),middleman.getEmail(),middleman.getDepartment(),middleman.getMedName(),middleman.getStandard(),middleman.getMedNum(),middleman.getDate(),middleman.getPlace(),middleman.getSupplierName(),middleman.getWorkId()};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean addMiddleMan(Middleman middleman) {
        String sql = "insert into middleman(mName, tel, email, department, medName, standard, medNum, date, place, supplierName) values (?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{middleman.getmName(),middleman.getTel(),middleman.getEmail(),middleman.getDepartment(),middleman.getMedName(),middleman.getStandard(),middleman.getMedNum(),middleman.getDate(),middleman.getPlace(),middleman.getSupplierName()};
        return JDBC.update(sql,objects) > 0;
    }
}
