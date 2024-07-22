package com.dao.Impl.init;

import com.util.JDBC;
import com.util.init.StringDeal;

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


    //搜索---------------------参数(列名数组,搜索值数组，表名)
    public ResultSet search(String[] keys,String[] values,String table){
        StringBuilder sqlbuild = new StringBuilder("select * from " + table + " where ");
        for (int i = 0; i < keys.length-1; i++) {
            sqlbuild.append(keys[i]).append(" like ? and ");
        }
        sqlbuild.append(keys[keys.length-1]).append(" like ?");
        Object[] objects = new Object[values.length];
        for (int i = 0; i < values.length; i++) {
            objects[i]="%"+values[0]+"%";
        }
        String sql = sqlbuild.toString();
        return JDBC.select(sql, objects);
    }

    public ResultSet getAllDesc(String colum,String tablname){
        String sql="select * from "+tablname+" order by "+colum+" desc ";
        return JDBC.select(sql,new Object[1]);
    }


    //自定义表格搜索------0：无where   1：有where
    public ResultSet searchCustomize(String[] keys,String[] values,String table,int o){
        StringBuilder sqlbuild;
        if (o==0){
                 sqlbuild = new StringBuilder(table+" where ");
            }else {
            sqlbuild = new StringBuilder(table+" and ");
        }
            for (int i = 0; i < keys.length-1; i++) {
                sqlbuild.append(keys[i]).append(" like ? and ");
            }
            sqlbuild.append(keys[keys.length-1]).append(" like ?");
            Object[] objects = new Object[values.length];
            for (int i = 0; i < values.length; i++) {
                objects[i]="%"+values[0]+"%";
            }
            String sql = sqlbuild.toString();
            return JDBC.select(sql, objects);
    }


    //自定义获取
    public ResultSet getAllCustomize(String sqlTable){
        return JDBC.select(sqlTable, new Object[1]);
    }
    public ResultSet getAllCustomize(int page,int limit,String sqlTable){
        String sql = sqlTable + " limit ?,?";
        Object[] objects = new Object[]{page,limit};
        return JDBC.select(sql, objects);
    }

    //查询一张表有多少条数据,0->表名，1->自定义
    public int getRow(String table,int i){
        int count = 0;
        String sql = null;
        if (i == 0){
            sql = "select * from "+table;
        }else if (i == 1){
            sql = table;
        }
        ResultSet select = JDBC.select(sql, new Object[1]);
        try {
            while (select.next()){
                count++;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
}
