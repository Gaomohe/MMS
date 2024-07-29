package com.dao;

import com.pojo.Warn;
import com.pojo.WarnDetail;

import java.util.List;

public interface WarnDao {

    //添加预警数据
    public int addWarn(Warn warn);
    public int addWarnDetail(WarnDetail warnDetail);
    //获取所有预警数据(Warn)
    public int getWarns();
    public List<Warn> getWarnsAll();
    public List<Warn> getWarns(int page,int limit);
    public List<Warn> getWarns(int page,int limit,String title,String order);
    //根据时间获取
    public List<Warn> getWarnsByTime(String time);
    //根据药品名称获取
    public List<Warn> getWarnsByMname(String name);
    //根据tableCoding获取
    public Warn getWarnsByTableCoding(int tableCoding);
    //获取所有预警数据（WarnDetail）
    public int getWarnDetails();
    public List<WarnDetail> getWarnDetails(int page,int limit,String title,String order);
    public List<WarnDetail> getWarnDetails(int page,int limit);
    //根据条件获取预警数据
    public Warn getWarnsById(int id);
    public List<WarnDetail> getWarnDetailsByWId(int wid);
    //获取所有预警细节
    public List<WarnDetail> getWarndetailsAll();
    //删除预警
    public int delWarn(int id);
    public int delWarnDetail(int id);
    //获取最新预警id
    public int getLastWarnId();
    //根据条件修改预警
    public int upWarnTime(Warn warn);
    public int upWarnWNumber(Warn warn);
    public int upWarnTotlNumber(Warn warn);
    //修改预警细节数据
    public int upWarnDetailNumber(WarnDetail warnDetail);
    public int upWarnDetailTime(WarnDetail warnDetail);

}
