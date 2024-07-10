package com.service.Impl;

import com.pojo.Apply;
import com.pojo.User;
import com.service.FinancialService;
import com.util.GetTime;
import com.util.LayuiTable;
import com.util.SQLtoString;

import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.*;

public class FinancialServiceImpl implements FinancialService {
    @Override
    public LayuiTable<Apply> getAppointList(int page, int limit, Apply apply) {
        String sql="";
        if (apply.getApplyId()==0){
            String[] keys = {"mName","applyTime","financeApprove","applyUser","pharmacist","finance"};
            Object[] values = {apply.getmName(),apply.getApplyTime(),apply.getFinanceApprove(),apply.getApplyUser(),apply.getPharmacist(),apply.getFinance()};
            sql = SQLtoString.getSQL(keys, values, "apply");
        } else if (apply.getApplyId()>0) {
            String[] keys = {"applyId","mName","applyTime","financeApprove","applyUser","pharmacist","finance"};
            Object[] values = {apply.getApplyId(),apply.getmName(),apply.getApplyTime(),apply.getFinanceApprove(),apply.getApplyUser(),apply.getPharmacist(),apply.getFinance()};
            sql = SQLtoString.getSQL(keys, values, "apply");
        }
        List<Apply> applyAll = financialDao.getPurchaseList(sql);
        LayuiTable<Apply> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(applyAll.size());
        layuiTable.setData(applyAll);
        return layuiTable;
    }

    //删除申请
    @Override
    public int delApply(int id) {
        return financialDao.delApply(id);
    }

    //财务审核
    @Override
    public int setApply(int id, User user) {
        int i = 0;
        Apply apply = new Apply();
        apply.setApplyId(id);
        apply.setFinanceTime(GetTime.getTime());
        String userName = userDao.getUserName(user.getId());
        apply.setApplyUser(userName);
        return financialDao.setApply(apply);
    }

    //财务反审核
    @Override
    public int setUnApprove(int id, User user) {
        int i = 0;
        Apply apply = new Apply();
        apply.setApplyId(id);
        apply.setFinanceTime(GetTime.getTime());
        String userName = userDao.getUserName(user.getId());
        apply.setApplyUser(userName);
        return financialDao.setUnApprove(apply);
    }
}
