package com.service;

import com.pojo.Warn;
import com.pojo.WarnDetail;

import java.util.List;

public interface WarnService {

    //添加预警数据
    public int addWarn(Warn warn);
    public int addWarnDetail(WarnDetail warnDetail);
    public int addWarn_detail(int wId, int wdId);
    //获取所有预警数据(Warn)
    public List<Warn> getWarns();
    //获取所有预警数据（WarnDetail）
    public List<WarnDetail> getWarnDetails();
    //根据条件获取预警数据
    public List<Warn> getWarnsByQuery(String[] title,String[] values);
    public List<WarnDetail> getWarnDetailsByQuery(String[] title,String[] values);
    //删除预警
    public int delWarn(int id);
    public int delWarnDetail(int id);
    public int delWarn_detail(int id);
    //根据条件修改预警
    public int upWarn(String[] title,String[] values);
}
