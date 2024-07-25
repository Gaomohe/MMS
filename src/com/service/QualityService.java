package com.service;

import com.pojo.Quality;
import com.pojo.User;

import java.util.List;

public interface QualityService {
    //添加质检表
    public int addQuality(Quality quality);
    //根据入库状态获取质检表
    public List<Quality> getQualityBySS(String storageStatus);
    public List<Quality> getQualityBySS(String storageStatus,int index, int limit);//分页
    public List<Quality> getQualityBySS(String storageStatus,int index,int limit,String order,String sort);//分页加排序
    //根据时间获取质检表
    public List<Quality> getQualityByTime(String sql,String time);
    //根据名称获取质检表信息
    public List<Quality> getQualityByName(String sql,String mName);
    //根据查询获取质检表
    public List<Quality> getQualityByQuery(String sql,String[] query);
    //根据id获取质检表
    public Quality getQualityByID(Quality quality);
    //修改质检表质检状态
    public int updateQualityStatue(Quality quality);
    //修改质检表入库状态
    public int updateQualitySS(int id, String name, User user);
    //修改质检表时间（自动修改）
    public int updateQualityTime(Quality quality);
    //删除质检表
    public int delQuality(int id);
    //更新保质期
    public int upUsefulLife(Quality quality);
}
