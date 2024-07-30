package com.service.Impl;

import com.pojo.Apply;
import com.pojo.Apporder;
import com.pojo.Purchase;
import com.pojo.User;
import com.service.FinancialService;
import com.util.GetTime;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.SQLtoString;

import java.sql.ResultSet;
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
        apply.setFinance(userName);
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

    //获取订单详情
    @Override
    public LayuiTable<Purchase> getId(int id) {
        List<Purchase> purchaseList = new ArrayList<>();
        LayuiTable<Purchase> layuiTable = new LayuiTable<>();
        ResultSet idres = financialDao.getId(id);
        try {
            while (idres.next()){
                Purchase purchase = new Purchase();
                purchase.setmId(idres.getInt(1));
                purchase.setApplyBuyNumber(idres.getInt(2));
                purchase.setmName(idres.getString(3));
                purchase.setSpecification(idres.getString(4));
                purchase.setManufactor(idres.getString(5));
                purchase.setUnit(idres.getString(6));
                purchase.setDepartment(idres.getString(7));
                purchase.setPurchasePrice(idres.getDouble(8));
                purchase.setSalePrice(idres.getDouble(9));
                purchase.setProductDate(idres.getString(10));
                purchase.setGoodsType(idres.getString(11));
                purchase.setmType(idres.getString(12));
                purchase.setDefined(idres.getString(13));
                purchaseList.add(purchase);
            }
            layuiTable.setData(purchaseList);
            layuiTable.setCode(0);
            layuiTable.setMsg("");


        }catch (Exception e){
            e.printStackTrace();
        }

        return layuiTable;
    }

    //订单财务审核
    @Override
    public ResultData<Integer> isok(int[] ins, String name) {
        String getTime = GetTime.getTime();
        ResultData<Integer> resultData = new ResultData<>();
        for (int id:ins) {
            int i = financialDao.okApply(id, name, getTime);
            if (financialDao.isOk(id,name,getTime) && i > 0){
                resultData.setStatus(200);
                resultData.setData(1);
            }else {
                resultData.setStatus(400);
                resultData.setData(0);
            }
        }
        return resultData;
    }
}
