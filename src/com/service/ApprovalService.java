package com.service;

import com.pojo.*;
import com.util.LayuiTable;
import com.util.ResultData;

import java.util.List;

public interface ApprovalService {
    public ResultData<List<Appointment>> getAuditId(int[] id);

    //获取申请人
    public List<User> getApplyUser();

    public LayuiTable<Orders> search(String[] keys, String[] values);

    public ResultData<Integer> del(int[] ints);

    public ResultData<Integer> isok(int[] ints,String userName);

    public ResultData<Integer> nook(int[] ints,String userName);

    public ResultData<List<Apply>> getHistory();

    //反审核
    public ResultData<Integer> noaudit(int[] ints,String name);

    public LayuiTable<Appointment> delOK();
}
