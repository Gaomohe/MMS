package com.service;

import com.pojo.Middleman;
import com.pojo.Supplier;
import com.util.LayuiTable;
import com.util.ResultData;

public interface MiddlemanService {
    //获取所有-------------参数(无)
    public LayuiTable<Middleman> selectMiddleMan(int page, int limit);

    //删除-----------------参数（id）
    public ResultData delMiddleMan(int id);

    //查询
    public ResultData selectMiddleManById(int id);

    //
    public ResultData checkMiddleManName(String name);

    //更新
    public ResultData updateMiddleMan(Middleman middleman);

    public ResultData addMiddleMan(Middleman middleman);
}
