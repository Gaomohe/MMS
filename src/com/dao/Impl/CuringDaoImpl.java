package com.dao.Impl;

import com.dao.CuringDao;
import com.dao.Impl.init.InitDaoImpl;
import com.pojo.Curing;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuringDaoImpl implements CuringDao {

    InitDaoImpl initDao = new InitDaoImpl();
    @Override
    public List<Curing> getCuring() {
        String sql = "select * from `drugcuring`";
        List<Curing> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        try {
            while (resultSet.next()){
                Curing curing = new Curing();
                curing.setId(resultSet.getInt(1));
                curing.setTableCoding(resultSet.getInt(2));
                curing.setmId(resultSet.getInt(3));
                curing.setContent(resultSet.getString(4));
                curing.setTime(resultSet.getString(5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Curing> getCuringByTab(int tableCoding) {
        ResultSet resultSet = initDao.getOne(tableCoding, "tableCoding", "drugcuring");
        List<Curing> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                Curing curing = new Curing();
                curing.setId(resultSet.getInt(1));
                curing.setTableCoding(resultSet.getInt(2));
                curing.setmId(resultSet.getInt(3));
                curing.setContent(resultSet.getString(4));
                curing.setTime(resultSet.getString(5));
                list.add(curing);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Curing> getCuringByMId(int mId) {
        ResultSet resultSet = initDao.getOne(mId, "mId", "drugcuring");
        List<Curing> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                Curing curing = new Curing();
                curing.setId(resultSet.getInt(1));
                curing.setTableCoding(resultSet.getInt(2));
                curing.setmId(resultSet.getInt(3));
                curing.setContent(resultSet.getString(4));
                curing.setTime(resultSet.getString(5));
                list.add(curing);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updataCuring(Curing curing) {
        String sql = "UPDATE `drugcuring` SET `tableCoding`=?,`mId`=?,`content`=?,`time`=? WHERE `id`=?;";
        Object[] objects = new Object[]{curing.getTableCoding(),curing.getmId(),curing.getContent(),curing.getTime(),curing.getId()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int addCuring(Curing curing) {
        String sql = "INSERT INTO `drugcuring`(`tableCoding`,`mId`,`content`,`time`) VALUES (?,?,?,?);";
        Object[] objects = new Object[]{curing.getTableCoding(),curing.getmId(),curing.getContent(),curing.getTime()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int delCuring(int id) {
        boolean b = initDao.delOne(id, "id", "drugcuring");
        int i = 0;
        if (b){
            i=1;
        }
        return i;
    }
}
