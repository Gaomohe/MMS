package com.service;

import com.pojo.Quality;

import java.util.List;

public interface QualityServlet {
    //添加质检表
    public int addQuality(Quality quality);
    //根据入库状态获取质检表
    public List<Quality> getQualityBySS(int storageStatus);
    public List<Quality> getQualityBySS(int storageStatus,int index, int limit);//分页
    public List<Quality> getQualityBySS(int storageStatus,int index,int limit,String order,String title);//分页加排序
    //根据时间获取质检表
    public List<Quality> getQualityByTime(String time);
    //根据查询获取质检表
    public List<Quality> getQualityByQuery(String[] query);
    //修改质检表质检状态
    public int updateQualityStatue(Quality quality);
    //修改质检表入库状态
    public int updateQualitySS(Quality quality);
    //修改质检表时间（自动修改）
    public int updateQualityTime(Quality quality);
    //删除质检表
    public int delQuality(int id);
}
