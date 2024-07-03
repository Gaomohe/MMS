package com.service.Impl;

import com.dao.Impl.SupplierDaoImpl;
import com.pojo.Supplier;
import com.service.SupplierServlce;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierServlceImpl implements SupplierServlce {
    SupplierDaoImpl supplierDao = new SupplierDaoImpl();
    ResultData resultData = new ResultData();
    @Override
    public List<Supplier> selectSupplier() {
        ResultSet supplier = supplierDao.getAll("supplier");
        List<Supplier> suppliers = new ArrayList<>();
        try {
            while (supplier.next()){
                Supplier sup = new Supplier();
                sup.setSid(supplier.getInt(1));
                sup.setsName(supplier.getString(2));
                sup.setOperationWay(supplier.getString(3));
                sup.setTel(supplier.getString(4));
                sup.setContact(supplier.getString(5));
                sup.setStatus(supplier.getString(6));
                sup.setLicense(supplier.getString(7));
                sup.setCreateTime(supplier.getString(8));
                suppliers.add(sup);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return suppliers;
    }

    @Override
    public ResultData delSupplier(int id) {
        if (supplierDao.delOne(id,"sId","supplier")){
            resultData.setStatus(200);
            resultData.setMsg("删除成功");
            resultData.setData(null);
        }else {
            resultData.setStatus(400);
            resultData.setMsg("删除失败");
            resultData.setData(null);
        }
        return resultData;
    }

    @Override
    public ResultData selectSupplierById(int id) {
        ResultSet supplier = supplierDao.getOne(id, "sId", "supplier");
        Supplier sup = new Supplier();
        try {
            if (supplier.next()){

                sup.setSid(supplier.getInt(1));
                sup.setsName(supplier.getString(2));
                sup.setOperationWay(supplier.getString(3));
                sup.setTel(supplier.getString(4));
                sup.setContact(supplier.getString(5));
                sup.setStatus(supplier.getString(6));
                sup.setLicense(supplier.getString(7));
                sup.setCreateTime(supplier.getString(8));

                resultData.setData(sup);
                resultData.setStatus(200);
                resultData.setMsg("");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData checkSupplierName(String name) {
        try {
            if (supplierDao.getOne(name,"sName","supplier").next()){
                resultData.setData("");
                resultData.setStatus(400);
                resultData.setMsg("有重复");
            }else {
                resultData.setData("");
                resultData.setStatus(200);
                resultData.setMsg("没有重复");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultData updateSupplier(Supplier supplier) {
        try {
            if (supplierDao.updateSupplier(supplier)){
                resultData.setStatus(200);
                resultData.setMsg("更新成功");
                resultData.setData(null);
            }else {
                resultData.setStatus(400);
                resultData.setMsg("更新失败");
                resultData.setData(null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData addRole(Supplier supplier) {
        if (supplierDao.addRole(supplier)){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(null);
        }else {
            resultData.setStatus(400);
            resultData.setMsg("添加失败");
            resultData.setData(null);
        }
        return resultData;
    }
}
