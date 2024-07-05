package com.service;

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
    public LayuiTable<Medicine> getSelectedValue(String where);

    public LayuiTable<Medicine> getSelectedTime(String where);

    //
    public LayuiTable<Medicine> likeSelect(String like);

    public ResultData<Medicine> selectById(int[] ids);

    public ResultData addSub_Apply(Sub_Apply sub_apply);


}
