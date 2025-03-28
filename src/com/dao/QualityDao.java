package com.dao;

import com.pojo.Quality;

import java.util.List;

public interface QualityDao {
    //添加质检表
    public int addQuality(Quality quality);
    //根据ID获取数据
    public Quality getQualityByID(int id);
    //根据入库状态获取质检表
    public List<Quality> getQualityBySS(String storageStatus);
    public List<Quality> getQualityBySS(String storageStatus,int index, int limit);//分页
    public List<Quality> getQualityBySS(String storageStatus,int index,int limit,String order,String title);//分页加排序
    //根据时间获取质检表
    public List<Quality> getQualityByTime(String sql,String time);
    //根据名称获取质检表信息
    public List<Quality> getQualityByName(String sql,String mName);
    //根据查询获取质检表
    public List<Quality> getQualityByQuery(String sql);
    //根据oId获取质检表
    public List<Integer> getQualityOid(int oId);
    //修改质检表质检状态
    public int updateQualityStatue(Quality quality);
    //修改质检表入库状态
    public int updateQualitySS(Quality quality);
    //修改质检表时间（自动修改）
    public int updateQualityTime(Quality quality);
    //删除质检表
    public int delQuality(int id);
    public int delQualityOid(int oid);
    //获取采购oid
    public int getOid();
    //更新保质期
    public int upUsefulLife(Quality quality);
}
