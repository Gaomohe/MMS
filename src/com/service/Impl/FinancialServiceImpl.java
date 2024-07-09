package com.service.Impl;

import com.pojo.Apply;
import com.service.FinancialService;
import com.util.LayuiTable;

import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.financialDao;

public class FinancialServiceImpl implements FinancialService {
    @Override
    public LayuiTable<Apply> getAppointList(int page, int limit, Apply apply) {
        List<Apply> applyAll = new ArrayList<>();
        if (apply.getApplyId()==0){
            applyAll = financialDao.getPurchaseList(apply);
        } else if (apply.getApplyId() > 0) {
            applyAll = financialDao.getPurchaseListNoId(apply);
        }
        LayuiTable<Apply> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(applyAll.size());
        layuiTable.setData(applyAll);
        return layuiTable;
    }
}
