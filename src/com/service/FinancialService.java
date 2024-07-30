package com.service;

import com.pojo.Apply;
import com.pojo.Purchase;
import com.pojo.User;
import com.util.LayuiTable;
import com.util.ResultData;

public interface FinancialService {
    //条件查询所有财务审批
    public LayuiTable<Apply> getAppointList(int page, int limit, Apply apply);

    //删除申请
    public int delApply(int id);

    //财务审核
    public int setApply(int id, User user);

    //财务反审核
    public int setUnApprove(int id, User user);

    //获取订单详情
    public LayuiTable<Purchase> getId(int id);

    //订单财务审核
    public ResultData<Integer> isok(int[] ins, String name);

}
