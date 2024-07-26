package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.SalReturnDao;
import com.pojo.SalReturn;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalReturnDaoImpl implements SalReturnDao {

    InitDaoImpl initDao = new InitDaoImpl();
    @Override
    public int addSalReturn(SalReturn salReturn) {
        String sql="INSERT INTO `salesreturn` (`returnId`,`address`,`shippingWay`,`shippingTime`,`consigner`,`consignee`,`oId`,`callNumber`,`state`)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{salReturn.getReturnId(),salReturn.getAddress(),salReturn.getShippingWay(),salReturn.getShippingTime(),salReturn.getConsigner(),salReturn.getConsignee(),salReturn.getoId(),salReturn.getCallNumber(),salReturn.getState()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    public int addSalReturnOne(SalReturn salReturn) {
        String sql="INSERT INTO `salesreturn` (`returnId`,`address`,`shippingWay`,`shippingTime`,`consigner`,`consignee`,`oId`,`callNumber`,`state`,`mName`,`number`,`price`)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{salReturn.getReturnId(),salReturn.getAddress(),salReturn.getShippingWay(),salReturn.getShippingTime(),salReturn.getConsigner(),salReturn.getConsignee(),salReturn.getoId(),salReturn.getCallNumber(),salReturn.getState(),salReturn.getmName(),salReturn.getNumber(),salReturn.getPrice()};
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

    public List<SalReturn> getSalReturn() {
        String sql="SELECT * FROM `salesreturn`";
        List<SalReturn> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        try {
            while (resultSet.next()){
                SalReturn salReturn = new SalReturn();
                salReturn.setConsigner(resultSet.getString(6));
                salReturn.setConsignee(resultSet.getString(7));
                salReturn.setState(resultSet.getString(10));
                list.add(salReturn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SalReturn> getAllSalReturn(int page,int limit) {
        String sql="SELECT * FROM `salesreturn` limit ?,?";
        List<SalReturn> list = new ArrayList<>();
        Object[] objects =new Object[]{page,limit};
        ResultSet resultSet = JDBC.select(sql,objects);
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));
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
        ResultSet resultSet = JDBC.select(sql,objects);
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return salReturn;
    }

    public List<SalReturn> getSalReturnByStatue(String state) {
        String sql="SELECT * FROM `salesreturn` WHERE state = ?";
        List<SalReturn> list = new ArrayList<>();
        Object[] objects =new Object[]{state};
        ResultSet resultSet = JDBC.select(sql,objects);
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));
                list.add(salReturn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SalReturn> getSalReturnByEE(String consignee) {
        String sql="SELECT * FROM `salesreturn` WHERE consignee = ?";
        List<SalReturn> list = new ArrayList<>();
        Object[] objects =new Object[]{consignee};
        ResultSet resultSet = JDBC.select(sql,objects);
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));
                list.add(salReturn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SalReturn> getSalReturnByEr(String consigner) {
        String sql="SELECT * FROM `salesreturn` WHERE consigner = ?";
        List<SalReturn> list = new ArrayList<>();
        Object[] objects =new Object[]{consigner};
        ResultSet resultSet = JDBC.select(sql,objects);
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));
                list.add(salReturn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public SalReturn getSalReturnByRId(String returnId) {
        String sql="SELECT * FROM `salesreturn` WHERE returnId = ?";
        SalReturn salReturn = new SalReturn();
        Object[] objects = new Object[]{returnId};
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return salReturn;
    }

    public List<SalReturn> getSalReturnByCall(int callNumber) {
        String sql="SELECT * FROM `salesreturn` WHERE callNumber = ?";
        List<SalReturn> list = new ArrayList<>();
        Object[] objects =new Object[]{callNumber};
        ResultSet resultSet = JDBC.select(sql,objects);
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
                salReturn.setCallNumber(resultSet.getString(9));
                salReturn.setState(resultSet.getString(10));
                list.add(salReturn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
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
    public int updateStatue(SalReturn salReturn) {
        String sql="UPDATE `salesreturn` SET `state` = ? WHERE `id` = ?";
        Object[] objects = new Object[2];
        objects[0] = salReturn.getState();
        objects[1] = salReturn.getId();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int updateAll(SalReturn salReturn) {
        String sql="UPDATE `salesreturn` SET `returnId`=?,`address`=?,`shippingWay`=?,`shippingTime`=?,`consigner`=?,`consignee`=?,`oId`=?,`callNumber`=?,`state`=? WHERE id=?";
        Object[] objects = new Object[]{salReturn.getReturnId(),salReturn.getAddress(),salReturn.getShippingWay(),salReturn.getShippingTime(),salReturn.getConsigner(),salReturn.getConsignee(),salReturn.getoId(),salReturn.getCallNumber(),salReturn.getState(),salReturn.getId()};
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

    public double getPrice(int oId,int mId){
        String sql ="select purchasePrice from apply\n" +
                "where mId in (\n" +
                "    select app_order.aId from app_order\n" +
                "where oId = ?\n" +
                "    )\n" +
                "and mId = ?\n" +
                "group by purchasePrice";
        Object[] objects = new Object[]{oId,mId};
        ResultSet resultSet = JDBC.select(sql, objects);
        double i = 0;
        try {
            while (resultSet.next()){
                i = resultSet.getDouble(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
