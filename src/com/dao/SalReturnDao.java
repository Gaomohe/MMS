package com.dao;

import com.pojo.SalReturn;

import java.util.List;

public interface SalReturnDao {

    //添加退货单
    public int addSalReturn(SalReturn salReturn);
    //查看所有订货单
    public int getAllSalReturn();
    public List<SalReturn> getAllSalReturn(int page,int limit);
    public List<SalReturn> getAllSalReturn(int page,int limit,String order, String title);
    //查看一个订货单
    public SalReturn getSalReturnOne(int id);
    //修改收货人
    public int updateConsignee(SalReturn salReturn);
    //修改所有
    public int updateAll(SalReturn salReturn);
    //删除退货单
    public int delSalReturn(int id);
}
