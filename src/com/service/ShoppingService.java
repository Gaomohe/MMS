package com.service;

import com.pojo.Apply;
import com.pojo.Medicine;
import com.pojo.Sub_Apply;
import com.pojo.Supplier;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.List;

public interface ShoppingService {
    //
    public LayuiTable<Medicine> getAll(int page,int limit);

    //
    public List<Medicine> getKind();

    //
    public LayuiTable<Medicine> getSelectedValue(int pages,int limits,String where);

    public LayuiTable<Medicine> getSelectedTime(String where);

    //
    public LayuiTable<Medicine> likeSelect(String like);

    public ResultData<Medicine> selectById(int[] ids);

    public ResultData addSub_Apply(Sub_Apply sub_apply);

    //生成转存表
    public List<Medicine> memoryList();

    //生成转存表2
    public List<Apply> subApplyList();

    public LayuiTable<Medicine> prescriptionDrug(int pages,int limits);

    public List<Medicine> getSup();

    public LayuiTable<Medicine> getSelectedSup(int pages,int limits,String where);


}
