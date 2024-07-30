package com.dao;

import com.pojo.Apply;

import java.sql.ResultSet;
import java.util.List;

public interface FinancialDao {
    //条件获取所有为审批
    public List<Apply> getPurchaseList(String sql);

    //删除申请
    public int delApply(int id);

    //财务审核
    public int setApply(Apply apply);

    //财务反审核
    public int setUnApprove(Apply apply);

    //获取订单详情
    public ResultSet getId(int id);

    //确认审批
    public boolean isOk(int id,String name,String getTime);

    //财务确认具体药品审批
    public int okApply(int id,String name,String getTime);

}
