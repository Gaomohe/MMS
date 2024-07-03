package com.service.Impl;

import com.dao.Impl.MiddlemanDaoImpl;
import com.pojo.Middleman;
import com.pojo.Supplier;
import com.service.MiddlemanService;
import com.util.LayuiTable;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MiddlemanServiceImpl implements MiddlemanService {
    MiddlemanDaoImpl middlemanDao = new MiddlemanDaoImpl();
    ResultData resultData = new ResultData();
    LayuiTable<Middleman> layuiTable = new LayuiTable<>();

    @Override
    public LayuiTable<Middleman> selectMiddleMan() {
        ResultSet middleman = middlemanDao.getAll("middleman");
        List<Middleman> middlemens = new ArrayList<>();
        int count = 0;
        try {
            while (middleman.next()){
                Middleman mid = new Middleman();
                mid.setWorkId(middleman.getInt(1));
                mid.setmName(middleman.getString(2));
                mid.setEmail(middleman.getString(4));
                mid.setDepartment(middleman.getString(5));
                mid.setm(middleman.getString(2));
                mid.setmName(middleman.getString(2));
                mid.setmName(middleman.getString(2));
                count++;
            }
            layuiTable.setCode(0);
            layuiTable.setCount(count);
            layuiTable.setData(middlemens);
            layuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }
}
