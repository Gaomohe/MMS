package com.service;

import com.pojo.Appointment;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

public interface BillService {
    //搜索----------参数(键[],值[])
    public LayuiTable<?> search(String[] key,String[] value);

    //删除--------------参数(id[])
    public ResultData<Integer> del(int[] ints);
}
