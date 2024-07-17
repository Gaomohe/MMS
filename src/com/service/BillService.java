package com.service;

import com.pojo.Advance;
import com.pojo.Appointment;
import com.pojo.Income;
import com.pojo.Spend;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.util.List;

public interface BillService {
    //搜索----------参数(键[],值[])
    public LayuiTable<?> search(String[] key,String[] value);

    //删除--------------参数(id[])
    public ResultData<Integer> del(int[] ints);



    //从下方开始，我们进行一系列的初始化操作
    //---begin
    public List<?> getSupply1();
    public List<?> getSupply2();
    public List<?> getSupply3();


    public List<?> getOpera1();


    public List<?> getFinance1();



    public List<?> getAccount1();



    //----------end------------

    public LayuiTable<Income> getAllIncome();
    public LayuiTable<Advance> getAllAdvance(int page,int limit);

    public LayuiTable<Income> search01(String[] keys,String[] values);
    public LayuiTable<Spend> search02(String[] keys,String[] values);
    public LayuiTable<Advance> search03(String[] keys,String[] values);

    public LayuiTable<Spend> getAllSpend(int page,int limit);
}
