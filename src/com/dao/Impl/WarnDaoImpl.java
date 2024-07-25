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
        Object[] objects = new Object[]{warn.getTableCoding(),warn.getmName(),warn.getTolNumber(),warn.getWarnNumber(),warn.getName(),warn.getTime(),warn.getuId()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int addWarnDetail(WarnDetail warnDetail) {
        String sql = "INSERT INTO `warndetail` (`time`,`number`,`usefulLife`,`uId`,`uName`,`wid`)\n" +
                "VALUES (?,?,?,?,?,?)";
        Object[] objects = new Object[]{warnDetail.getTime(),warnDetail.getNumber(),warnDetail.getUsefulLife(),warnDetail.getuId(),warnDetail.getuName(),warnDetail.getWid()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    public int getWarns() {
        String sql = "SELECT id FROM `warn`";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        int i = 0;
        try {
            while (resultSet.next()){
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
    @Override
    public List<Warn> getWarns(int page,int limit) {
        String sql = "SELECT * FROM `warn` limit ?,?";
        ResultSet resultSet = JDBC.select(sql, new Object[]{page,limit});
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
    public List<Warn> getWarnsByTime(String time) {
        String sql = "SELECT * FROM `warn` where time like ?";
        ResultSet resultSet = JDBC.select(sql, new Object[]{"%"+time+"%"});
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
    public List<Warn> getWarnsByMname(String name) {
        String sql = "SELECT * FROM `warn` where mName like ?";
        ResultSet resultSet = JDBC.select(sql, new Object[]{"%"+name+"%"});
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
    public Warn getWarnsByTableCoding(int tableCoding) {
        String sql = "SELECT * FROM `warn` where tableCoding = ?";
        ResultSet resultSet = JDBC.select(sql, new Object[]{tableCoding});
        Warn warn = new Warn();
        try {
            while (resultSet.next()){

                warn.setId(resultSet.getInt(1));
                warn.setTableCoding(resultSet.getInt(2));
                warn.setmName(resultSet.getString(3));
                warn.setTolNumber(resultSet.getInt(4));
                warn.setWarnNumber(resultSet.getInt(5));
                warn.setName(resultSet.getString(6));
                warn.setTime(resultSet.getString(7));
                warn.setuId(resultSet.getInt(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return warn;
    }

    public int getWarnDetails() {
        String sql = "SELECT id FROM `warndetail`";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        int i = 0;
        try {
            while (resultSet.next()){
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<WarnDetail> getWarnDetails(int page,int limit) {
        String sql = "SELECT * FROM `warndetail` limit ?,?";
        ResultSet resultSet = JDBC.select(sql, new Object[]{page,limit});
        List<WarnDetail> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                WarnDetail warn = new WarnDetail();
                warn.setId(resultSet.getInt(1));
                warn.setTime(resultSet.getString(2));
                warn.setNumber(resultSet.getInt(3));
                warn.setUsefulLife(resultSet.getString(4));
                warn.setuId(resultSet.getInt(5));
                warn.setuName(resultSet.getString(6));
                warn.setWid(resultSet.getInt(7));
                list.add(warn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Warn getWarnsById(int id) {
        String sql = "SELECT * FROM `warn` WHERE `id`=?";
        Object[] objects = new Object[]{id};
        ResultSet resultSet = JDBC.select(sql, objects);
        Warn warn = new Warn();
        try {
            while (resultSet.next()){

                warn.setId(resultSet.getInt(1));
                warn.setTableCoding(resultSet.getInt(2));
                warn.setmName(resultSet.getString(3));
                warn.setTolNumber(resultSet.getInt(4));
                warn.setWarnNumber(resultSet.getInt(5));
                warn.setName(resultSet.getString(6));
                warn.setTime(resultSet.getString(7));
                warn.setuId(resultSet.getInt(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return warn;
    }

    public List<WarnDetail> getWarnDetailsByWId(int wid) {
        String sql = "SELECT * FROM `warndetail` WHERE `wid`=?";
        Object[] objects = new Object[]{wid};
        ResultSet resultSet = JDBC.select(sql,objects);
        List<WarnDetail> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                WarnDetail warn = new WarnDetail();
                warn.setId(resultSet.getInt(1));
                warn.setTime(resultSet.getString(2));
                warn.setNumber(resultSet.getInt(3));
                warn.setUsefulLife(resultSet.getString(4));
                warn.setuId(resultSet.getInt(5));
                warn.setuName(resultSet.getString(6));
                warn.setWid(resultSet.getInt(7));
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
        boolean b = initDao.delOne(id, "wid", "warndetail");
        if (b){
            return 1;
        }
        return 0;
    }
    public int getLastWarnId(){
        String sql = "SELECT id FROM `warn` ORDER BY `id` DESC LIMIT 1";
        ResultSet select = JDBC.select(sql, new Object[1]);
        int id = 0;
        try {
            while (select.next()){
                id = select.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public int upWarnTime(Warn warn) {
        String sql = "UPDATE `warn` SET `time`=?,`name`=?,`uId`=? WHERE `id`=?";
        Object[] objects = new Object[]{warn.getTime(),warn.getName(),warn.getuId(),warn.getId()};
        int i = JDBC.update(sql,objects);
        return i;
    }
    public int upWarnWNumber(Warn warn) {
        String sql = "UPDATE `warn` SET `warnNumber`=? WHERE `id`=?";
        Object[] objects = new Object[]{warn.getWarnNumber(),warn.getId()};
        int i = JDBC.update(sql,objects);
        return i;
    }
    public int upWarnTotlNumber(Warn warn) {
        String sql = "UPDATE `warn` SET `tolNumber`=? WHERE `id`=?";
        Object[] objects = new Object[]{warn.getTolNumber(),warn.getId()};
        int i = JDBC.update(sql,objects);
        return i;
    }
}
