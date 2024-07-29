package com.service;

import com.pojo.Medicine;
import com.pojo.User;
import com.pojo.Warn;
import com.pojo.WarnDetail;

import java.util.List;

public interface WarnService {

    //添加预警数据
    public int addWarn(Warn warn,String usefulLife,int id);
    //获取所有预警数据(Warn)
    public int getWarns();
    public List<Warn> getWarns(int page,int limit);
    public List<Warn> getWarns(int page,int limit,String title,String order);
    //按照时间获取
    public List<Warn> getWarnsByTime(String time);
    //按照药品获取
    public List<Warn> getWarnsByMname(String name);
    //获取所有预警数据（WarnDetail）
    public int getWarnDetails();
    public List<WarnDetail> getWarnDetails(int page,int limit,String title,String order);
    public List<WarnDetail> getWarnDetails(int page,int limit);
    //根据条件获取预警数据
    public Warn getWarnsById(int id);
    public List<WarnDetail> getWarnDetailsByWId(int wid);
    //删除预警
    public int delWarn(int id);
    public int delWarnDetail(int id);
    //获取最新预警id
    public int getLastWarnId();
    //根据条件修改预警
    public int upWarnWNumber(Warn warn);
    public int upWarnTotlNumber(Warn warn,String usefulLife,int id);
    //获取过期药品数量
    public int getOutUserfulLife();
    //获取需要购买药品数
    public int getNeedBuy();

    //修改预警细节数据
    public int upWarnDetailNumber(WarnDetail warnDetail);

    public int upWarnDetailTime(WarnDetail warnDetail);

    //动态出库
    public String delNumber(Medicine medicine1, int number, User user);

    //退货药品数量处理
    public void dispose(int qid);

    //获取昨日入库药品
    public List<Warn> getYesterdayWarns();
    //获取过期的药品
    public List<WarnDetail> getOutUseWarns();
    //获取需要购买药品
    public List<Warn> getNeedBuyWarns();
}
