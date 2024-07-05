package com.dao.Impl.init;

import com.util.JDBC;

import java.sql.ResultSet;

public class InitDaoImpl {
    //用于方便公共操作

    //获取某个表的全部信息（带有分页）---------参数（页数,区间,表名）
    public ResultSet getAll(int page,int limit,String tableName){
        String sql = "select * from "+tableName+" limit ?,?";
        Object[] objects = new Object[]{page,limit};
        return JDBC.select(sql,objects);
    }

    //获取某个表的全部信息（没有分页）---------参数（表名）
    public ResultSet getAll(String tableName){
        String sql = "select * from "+tableName;
        return JDBC.select(sql,new Object[1]);
    }

    //按id删除某个表的信息-------------参数（id,表名）
    public boolean delOne(int id,String idname,String tableName){
        String sql="delete from "+tableName+" where "+idname+" =?";
        Object[] objects = new Object[]{id};
        return JDBC.update(sql,objects) > 0;
    }

    //按照id获取某表的某一些信息---------参数(id,id名称,表名)
    public ResultSet getOne(int id,String idName,String tableName){
        String sql = "select * from "+tableName+" where "+idName+" = ?";
        Object[] objects = new Object[]{id};
        return JDBC.select(sql,objects);
    }

    //按照其他(String类型的)获取某表的某一些信息---------参数(id,id名称,表名)
    public ResultSet getOne(String other,String otherName,String tableName){
        String sql = "select * from "+tableName+" where "+otherName+" = ?";
        Object[] objects = new Object[]{other};
        return JDBC.select(sql,objects);
    }

    //查看种类
    public ResultSet getKind(String columnName,String tableName){
        String sql = "select distinct "+columnName+" from "+tableName;
        return JDBC.select(sql,new Object[1]);
    }
}
