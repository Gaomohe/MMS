package com.dao;

import com.pojo.Apply;

import java.util.List;

public interface FinancialDao {
    //条件获取所有为审批
    public List<Apply> getPurchaseList(Apply apply);

    //无编号
    public List<Apply> getPurchaseListNoId(Apply apply);
}
