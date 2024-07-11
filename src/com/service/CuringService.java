package com.service;

import com.pojo.Curing;
import com.pojo.Medicine;

import java.util.List;

public interface CuringService {
    //显示养护记录表
    public List<Curing> getCuring();
    //获取养护状态
    public List<Medicine> getState(int page, int limit, String order, String sort);
    public List<Medicine> getState(int index,int limit);
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
