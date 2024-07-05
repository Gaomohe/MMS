package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.TypeDao;
import com.pojo.Type;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoImpl implements TypeDao {

    InitDaoImpl initDao = new InitDaoImpl();
    //分类新增
    @Override
    public int addGoodsType(Type type) {
        String sql = "INSERT INTO `goodscategory` (`typeName`) VALUE (?)";
        Object[] objects = new Object[1];
        objects[0] = type.getTypename();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int addMType(Type type) {
        String sql = "INSERT INTO `drugclassification` (`typeName`) VALUE (?)";
        Object[] objects = new Object[1];
        objects[0] = type.getTypename();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int addfreeType(Type type) {
        String sql = "INSERT INTO `customclassification` (`typeName`) VALUE (?)";
        Object[] objects = new Object[1];
        objects[0] = type.getTypename();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int dosage(Type type) {
        String sql = "INSERT INTO `dosageform` (`typeName`) VALUE (?)";
        Object[] objects = new Object[1];
        objects[0] = type.getTypename();
        int i = JDBC.update(sql, objects);
        return i;
    }


    //分类显示
    @Override
    public List<Type> getAllGoodsType() {
       String sql = "SELECT * FROM `goodscategory`";
       List<Type> list = new ArrayList<>();
       ResultSet resultSet = JDBC.select(sql, new Object[1]);
       try{
           while (resultSet.next()){
               Type type = new Type();
               type.setTypename(resultSet.getString(1));
               list.add(type);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return list;
    }

    @Override
    public List<Type> getAllMType() {
        String sql = "SELECT * FROM `drugclassification`";
        List<Type> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        try{
            while (resultSet.next()){
                Type type = new Type();
                type.setTypename(resultSet.getString(1));
                list.add(type);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Type> getAllfreeType() {
        String sql = "SELECT * FROM `customclassification`";
        List<Type> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        try{
            while (resultSet.next()){
                Type type = new Type();
                type.setTypename(resultSet.getString(1));
                list.add(type);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Type> getAlldosage() {
        String sql = "SELECT * FROM `dosageform`";
        List<Type> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        try{
            while (resultSet.next()){
                Type type = new Type();
                type.setTypename(resultSet.getString(1));
                list.add(type);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //删除分类
    @Override
    public int delGoodsType(String type) {
        String sql = "DELETE FROM `goodscategory` WHERE `typeName`=?";
        Object[] objects = new Object[1];
        objects[0] = type;
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int delMType(String type) {
        String sql = "DELETE FROM `drugclassification` WHERE `typeName`=?";
        Object[] objects = new Object[1];
        objects[0] = type;
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int delfreeType(String type) {
        String sql = "DELETE FROM `customclassification` WHERE `typeName`=?";
        Object[] objects = new Object[1];
        objects[0] = type;
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int deldosage(String type) {
        String sql = "DELETE FROM `dosageform` WHERE `typeName`=?";
        Object[] objects = new Object[1];
        objects[0] = type;
        int i = JDBC.update(sql, objects);
        return i;
    }


}
