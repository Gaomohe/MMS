package com.dao;


import com.pojo.Supplier;
import com.util.ResultData;

public interface SupplierDao{
    //修改----------参数（Supplier）
    public boolean updateSupplier(Supplier supplier);

    //添加-----------参数Supplier）
    public boolean addRole(Supplier supplier);
}
