package com.service;

import com.pojo.Middleman;
import com.pojo.Supplier;
import com.util.LayuiTable;

public interface MiddlemanService {
    //获取所有-------------参数(无)
    public LayuiTable<Middleman> selectMiddleMan();
}
