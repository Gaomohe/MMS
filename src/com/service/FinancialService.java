package com.service;

import com.pojo.Apply;
import com.util.LayuiTable;

public interface FinancialService {
    //条件查询所有财务审批
    public LayuiTable<Apply> getAppointList(int page, int limit, Apply apply);

    //删除申请
    public int delApply(int id);

    //财务审核
    public int setApply(int id);

    //财务反审核
    public int setUnApprove(int id);

}
