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
                mid.setMedName(middleman.getString(6));
                mid.setStandard(middleman.getString(7));
                mid.setMedNum(middleman.getInt(8));
                mid.setDate(middleman.getString(9));
                mid.setPlace(middleman.getString(10));
                mid.setSupplierName(middleman.getString(11));
                count++;
                middlemens.add(mid);
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

    @Override
    public ResultData delMiddleMan(int id) {
        if (middlemanDao.delOne(id,"workId","middleman")){
            resultData.setStatus(200);
            resultData.setMsg("删除成功");
            resultData.setData(null);
        }else {
            resultData.setStatus(400);
            resultData.setMsg("删除失败");
            resultData.setData(null);
        }
        return resultData;
    }

    @Override
    public ResultData selectMiddleManById(int id) {
        ResultSet middleman = middlemanDao.getOne(id, "workId", "middleman");
        Middleman mid = new Middleman();
        try {
            if (middleman.next()){
                mid.setWorkId(middleman.getInt(1));
                mid.setmName(middleman.getString(2));
                mid.setEmail(middleman.getString(4));
                mid.setDepartment(middleman.getString(5));
                mid.setMedName(middleman.getString(6));
                mid.setStandard(middleman.getString(7));
                mid.setMedNum(middleman.getInt(8));
                mid.setDate(middleman.getString(9));
                mid.setPlace(middleman.getString(10));
                mid.setSupplierName(middleman.getString(11));


                resultData.setData(mid);
                resultData.setStatus(200);
                resultData.setMsg("");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData checkMiddleManName(String name) {
        try {
            if (middlemanDao.getOne(name,"mName","middleman").next()){
                resultData.setData("");
                resultData.setStatus(400);
                resultData.setMsg("有重复");
            }else {
                resultData.setData("");
                resultData.setStatus(200);
                resultData.setMsg("没有重复");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData updateMiddleMan(Middleman middleman) {
        try {
            if (middlemanDao.updateMiddleMan(middleman)){
                resultData.setStatus(200);
                resultData.setMsg("更新成功");
                resultData.setData(null);
            }else {
                resultData.setStatus(400);
                resultData.setMsg("更新失败");
                resultData.setData(null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData addMiddleMan(Middleman middleman) {
        if (middlemanDao.addMiddleMan(middleman)){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(null);
        }else {
            resultData.setStatus(400);
            resultData.setMsg("添加失败");
            resultData.setData(null);
        }
        return resultData;
    }
}
