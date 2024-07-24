package com.service;

import com.pojo.User;
import com.pojo.Warn;
import com.pojo.WarnDetail;

import java.util.List;

public interface WarnService {

    //添加预警数据
    public int addWarn(Warn warn,String usefulLife);
    //获取所有预警数据(Warn)
    public List<Warn> getWarns();
    //获取所有预警数据（WarnDetail）
    public List<WarnDetail> getWarnDetails();
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
    public int upWarnTotlNumber(Warn warn,String usefulLife);
}
