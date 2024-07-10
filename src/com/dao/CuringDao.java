package com.dao;

import com.pojo.Curing;

import java.util.List;

public interface CuringDao {
    //显示养护记录表
    public List<Curing> getCuring();
    //根据tableCoding显示养护记录表
    public List<Curing> getCuringByTab(int tableCoding);
    //根据mId显示养护记录表
    public List<Curing> getCuringByMId(int mId);
    //修改养护记录表
    public int updataCuring(Curing curing);
    //新建养护记录表信息
    public int addCuring(Curing curing);
    //删除养护记录表
    public int delCuring(int id);
}
