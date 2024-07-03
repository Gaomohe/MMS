package com.service;

import com.pojo.Supplier;
import com.util.ResultData;

import java.util.List;

public interface SupplierServlce {
    //获取所有--------------参数（无）
    public List<Supplier> selectSupplier();

    //删除-----------参数（id）
    public ResultData delSupplier(int id);

    //按照id查询--------参数（id）
    public ResultData selectSupplierById(int id);

    //查重----------参数（名字）
    public ResultData checkSupplierName(String name);

    //更新=--------参数（Supplier）
    public ResultData updateSupplier(Supplier supplier);

    //添加------------参数(Supplier)
    public ResultData addRole(Supplier supplier);

}
