package com.service.Impl;

import com.pojo.ApplyFailed;
import com.pojo.DicNum;
import com.pojo.SalReturn;
import com.service.FirstPageService;

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


}
