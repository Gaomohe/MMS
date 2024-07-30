package com.service.Impl;

import com.pojo.*;
import com.service.FirstPageService;

import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.*;

public class FirstPageServiceImpl implements FirstPageService {

    @Override
    public int getReturnNumber() {
        int i = 0;
        List<SalReturn> salReturn = salReturnService.getSalReturn();
        for (SalReturn salReturn1:salReturn){
            if (salReturn1.getAddress()==null){
                i++;
            }
        }
        return i;
    }
    public int getFailedNumber(){
        int i = 0;
        List<ApplyFailed> statueAll = applyFailedDao.getStatueAll();
        for (ApplyFailed applyFailed:statueAll){
            if (!applyFailed.getPharmacistApprove().equals("已审阅通过")){
                i++;
            }
        }
        return i;
    }
    public int getUnPayed(){
        int i = 0;
        List<DicNum> dicNum = medicineDao.getDic_Num();
        for (DicNum dicNum1:dicNum){
            i++;
        }
        return i;
    }

    public List<FirstPage> getWarnMsg(){
        List<Warn> needBuyWarns = warnService.getNeedBuyWarns();
        List<FirstPage> list = new ArrayList<>();
        for (Warn warn:needBuyWarns){
            FirstPage firstPage = new FirstPage();
            firstPage.setWarnNumber(warn.getWarnNumber());
            firstPage.setTolNumber(warn.getTolNumber());
            firstPage.setmName(warn.getmName());
            list.add(firstPage);
        }
        return list;
    }

    public List<Orders> getOrderMsg(){
        List<Orders> orderList = ordersDao.getOrders();
        List<Orders> ordersList1 = new ArrayList<>();
        int i = 0;
        for (Orders order:orderList){
            Orders ordersById = ordersService.getOrdersById(order.getoId());
            ordersList1.add(ordersById);
            i++;
            if (i==10){
                return ordersList1;
            }
        }
        return ordersList1;
    }


}
