package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.SalReturnDao;
import com.pojo.Quality;
import com.pojo.SalReturn;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalReturnDaoImpl implements SalReturnDao {

    InitDaoImpl initDao = new InitDaoImpl();
    @Override
    public int addSalReturn(SalReturn salReturn) {
        String sql="INSERT INTO `salesreturn` (`returnId`,`address`,`shippingWay`,`shippingTime`,`consigner`,`consignee`,`oId`)\n" +
                "VALUES (?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{salReturn.getReturnId(),salReturn.getAddress(),salReturn.getShippingWay(),salReturn.getShippingTime(),salReturn.getConsigner(),salReturn.getConsignee(),salReturn.getoId()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int getAllSalReturn() {
        String sql="SELECT * FROM `salesreturn`";
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        int i= 0;
        try {
            while (resultSet.next()){
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public List<SalReturn> getAllSalReturn(int page,int limit) {
        String sql="SELECT * FROM `salesreturn` limit ?,?";
        List<SalReturn> list = new ArrayList<>();
        Object[] objects =new Object[]{page,limit};
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        try {
            while (resultSet.next()){
                SalReturn salReturn = new SalReturn();
                salReturn.setId(resultSet.getInt(1));
                salReturn.setReturnId(resultSet.getString(2));
                salReturn.setAddress(resultSet.getString(3));
                salReturn.setShippingWay(resultSet.getString(4));
                salReturn.setShippingTime(resultSet.getString(5));
                salReturn.setConsigner(resultSet.getString(6));
                salReturn.setConsignee(resultSet.getString(7));
                salReturn.setoId(resultSet.getInt(8));
                list.add(salReturn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SalReturn> getAllSalReturn(int page,int limit,String order, String title) {
        String sql="SELECT * FROM `salesreturn` ORDER BY "+title+" "+order+" limit ?,?";
        List<SalReturn> list = new ArrayList<>();
        Object[] objects =new Object[]{page,limit};
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        try {
            while (resultSet.next()){
                SalReturn salReturn = new SalReturn();
                salReturn.setId(resultSet.getInt(1));
                salReturn.setReturnId(resultSet.getString(2));
                salReturn.setAddress(resultSet.getString(3));
                salReturn.setShippingWay(resultSet.getString(4));
                salReturn.setShippingTime(resultSet.getString(5));
                salReturn.setConsigner(resultSet.getString(6));
                salReturn.setConsignee(resultSet.getString(7));
                salReturn.setoId(resultSet.getInt(8));
                list.add(salReturn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public SalReturn getSalReturnOne(int id) {
        String sql="SELECT * FROM `salesreturn` WHERE id = ?";
        SalReturn salReturn = new SalReturn();
        Object[] objects = new Object[]{id};
        ResultSet resultSet = JDBC.select(sql,objects);
        try {
            while (resultSet.next()){
                salReturn.setId(resultSet.getInt(1));
                salReturn.setReturnId(resultSet.getString(2));
                salReturn.setAddress(resultSet.getString(3));
                salReturn.setShippingWay(resultSet.getString(4));
                salReturn.setShippingTime(resultSet.getString(5));
                salReturn.setConsigner(resultSet.getString(6));
                salReturn.setConsignee(resultSet.getString(7));
                salReturn.setoId(resultSet.getInt(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return salReturn;
    }

    @Override
    public int updateConsignee(SalReturn salReturn) {
        String sql="UPDATE `salesreturn` SET `consignee` = ? WHERE `id` = ?";
        Object[] objects = new Object[2];
        objects[0] = salReturn.getConsignee();
        objects[1] = salReturn.getId();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int updateAll(SalReturn salReturn) {
        String sql="UPDATE `salesreturn` SET `returnId`=?,`address`=?,`shippingWay`=?,`shippingTime`=?,`consigner`=?,`consignee`=?,`oId`=? WHERE id=?";
        Object[] objects = new Object[]{salReturn.getReturnId(),salReturn.getAddress(),salReturn.getShippingWay(),salReturn.getShippingTime(),salReturn.getConsigner(),salReturn.getConsignee(),salReturn.getoId(),salReturn.getId()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int delSalReturn(int id) {
        boolean b = initDao.delOne(id, "id", "salesreturn");
        int i = 0;
        if (b){
            i = 1;
        }
        return i;
    }
}
