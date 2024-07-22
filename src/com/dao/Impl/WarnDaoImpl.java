package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.WarnDao;
import com.pojo.Warn;
import com.pojo.WarnDetail;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WarnDaoImpl implements WarnDao {
    @Override
    public int addWarn(Warn warn) {
        String sql = "INSERT INTO `warn` (`tableCoding`,`mName`,`tolNumber`,`warnNumber`,`name`,`time`,`uId`)\n" +
                "VALUES (?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{warn.getTableCoding(),warn,warn.getmName(),warn.getTolNumber(),warn.getWarnNumber(),warn.getName(),warn.getTime(),warn.getuId()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int addWarnDetail(WarnDetail warnDetail) {
        String sql = "INSERT INTO `warndetail` (`time`,`number`,`usefulLife`)\n" +
                "VALUES (?,?,?)";
        Object[] objects = new Object[]{warnDetail.getTime(),warnDetail.getNumber(),warnDetail.getUsefulLife()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    public int addWarn_detail(int wId, int wdId) {
        String sql = "INSERT INTO `warn_detail` (`wId`,`wdId`)\n" +
                "VALUES (?,?)";
        Object[] objects = new Object[]{wId,wdId};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public List<Warn> getWarns() {
        String sql = select(new String[1], new String[1], "warn");
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Warn> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                Warn warn = new Warn();
                warn.setId(resultSet.getInt(1));
                warn.setTableCoding(resultSet.getInt(2));
                warn.setmName(resultSet.getString(3));
                warn.setTolNumber(resultSet.getInt(4));
                warn.setWarnNumber(resultSet.getInt(5));
                warn.setName(resultSet.getString(6));
                warn.setTime(resultSet.getString(7));
                warn.setuId(resultSet.getInt(8));
                list.add(warn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<WarnDetail> getWarnDetails() {
        String sql = select(new String[1], new String[1], "warndetail");
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<WarnDetail> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                WarnDetail warn = new WarnDetail();
                warn.setId(resultSet.getInt(1));
                warn.setTime(resultSet.getString(2));
                warn.setNumber(resultSet.getInt(3));
                warn.setUsefulLife(resultSet.getString(4));
                list.add(warn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Warn> getWarnsByQuery(String[] title, String[] values) {
        String sql = select(title, values, "warn");
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Warn> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                Warn warn = new Warn();
                warn.setId(resultSet.getInt(1));
                warn.setTableCoding(resultSet.getInt(2));
                warn.setmName(resultSet.getString(3));
                warn.setTolNumber(resultSet.getInt(4));
                warn.setWarnNumber(resultSet.getInt(5));
                warn.setName(resultSet.getString(6));
                warn.setTime(resultSet.getString(7));
                warn.setuId(resultSet.getInt(8));
                list.add(warn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<WarnDetail> getWarnDetailsByQuery(String[] title, String[] values) {
        String sql = select(title, values, "warndetail");
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<WarnDetail> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                WarnDetail warn = new WarnDetail();
                warn.setId(resultSet.getInt(1));
                warn.setTime(resultSet.getString(2));
                warn.setNumber(resultSet.getInt(3));
                warn.setUsefulLife(resultSet.getString(4));
                list.add(warn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delWarn(int id) {
        InitDaoImpl initDao = new InitDaoImpl();
        boolean b = initDao.delOne(id, "id", "warn");
        if (b){
            return 1;
        }
        return 0;
    }
    public int delWarnDetail(int id) {
        InitDaoImpl initDao = new InitDaoImpl();
        boolean b = initDao.delOne(id, "id", "warndetail");
        if (b){
            return 1;
        }
        return 0;
    }
    public int delWarn_detail(int id) {
        InitDaoImpl initDao = new InitDaoImpl();
        boolean b = initDao.delOne(id, "id", "warn_detail");
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public int upWarn(String[] title, String[] values) {
        return 0;
    }

    public String select(String[] title, String[] values,String table){
        StringBuilder sqlBuilder = new StringBuilder("select * from "+table);
        if (title[0]==null){
            System.out.println(sqlBuilder.toString());
        }
        for (int i = 0; i < title.length; i++) {
            sqlBuilder.append(" ").append(title[i]).append(" = ").append(values[i]).append(",");
        }
        if (sqlBuilder.length() > 0 && sqlBuilder.charAt(sqlBuilder.length() - 1) == ',') {
            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
        }
        String sql = sqlBuilder.toString();
        return sql;
    }
    public String update(String[] title, String[] values,String table){
        StringBuilder sqlBuilder = new StringBuilder("update "+table+" set");
        if (title[0]==null){
            System.out.println(sqlBuilder.toString());
        }
        for (int i = 0; i < title.length; i++) {
            sqlBuilder.append(" ").append(title[i]).append(" = ").append(values[i]).append(",");
        }
        if (sqlBuilder.length() > 0 && sqlBuilder.charAt(sqlBuilder.length() - 1) == ',') {
            sqlBuilder.deleteCharAt(sqlBuilder.length() - 1);
        }
        String sql = sqlBuilder.toString();
        return sql;
    }
}
