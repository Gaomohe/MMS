package com.service;

import com.pojo.SalReturn;

import java.util.List;

public interface SalReturnService {
    //添加退货单
    public int addSalReturn(int oId,int id,String name);
    //查看所有订货单
    public int getAllSalReturn();
    public List<SalReturn> getSalReturn();
    public List<SalReturn> getAllSalReturn(int page,int limit);
    public List<SalReturn> getAllSalReturn(int page,int limit,String order, String title);
    //查看一个订货单
    public SalReturn getSalReturnOne(int id);
    //根据状态获取订货单
    public List<SalReturn> getSalReturnByStatue(String state);
    //根据收货人获取订单
    public List<SalReturn> getSalReturnByEE(String consignee);
    public List<SalReturn> getSalReturnByEr(String consigner);
    //根据订单编号获取订单
    public SalReturn getSalReturnByRId(String returnId);
    //根据联系方式获取订单
    public List<SalReturn> getSalReturnByCall(int callNumber);
    //修改收货人
    public int updateConsignee(SalReturn salReturn);
    //修改订单状态(仅需获取id与state)
    public int updateStatue(SalReturn salReturn);
    //修改所有
    public int updateAll(SalReturn salReturn);
    //删除退货单
    public int delSalReturn(int id);
}
