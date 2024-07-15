package com.service.Impl;

import com.dao.Impl.BillDaoImpl;
import com.service.BillService;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;

public class BillServiceImpl implements BillService {
    BillDaoImpl billDao = new BillDaoImpl();
    ResultData<Integer> integerResultData = new ResultData<>();
    @Override
    public LayuiTable<?> search(String[] key, String[] value) {
        ResultSet ledger = billDao.search(key, value, "ledger");

        return null;
    }

    @Override
    public ResultData<Integer> del(int[] ints) {
        try {
            for (int i : ints) {
                boolean b = billDao.delOne(i, "", "");
                if (!b){
                    integerResultData.setStatus(400);
                }else {
                    integerResultData.setStatus(200);
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return integerResultData;
    }
}
