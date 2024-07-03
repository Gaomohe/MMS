package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.SupplierDao;
import com.pojo.Supplier;
import com.util.JDBC;

public class SupplierDaoImpl extends InitDaoImpl implements SupplierDao {
    @Override
    public boolean updateSupplier(Supplier supplier) {
        String sql = "update supplier set sName=?,operationWay=?,tel=?,contact=?,status=?,license=?,createTime=? where sId=?";
        Object[] objects = new Object[]{supplier.getsName(),supplier.getOperationWay(),supplier.getTel(),supplier.getContact(),supplier.getStatus(),supplier.getLicense(),supplier.getCreateTime(),supplier.getSid()};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean addRole(Supplier supplier) {
        String sql = "insert into supplier(sName, operationWay, tel, contact, status, license, createTime) VALUE (?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{supplier.getsName(),supplier.getOperationWay(),supplier.getTel(),supplier.getContact(),supplier.getStatus(),supplier.getLicense(),supplier.getCreateTime()};
        return JDBC.update(sql,objects) > 0;
    }
}
