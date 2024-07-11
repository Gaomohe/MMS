package com.service.Impl;

import com.dao.Impl.LogDaoImpl;
import com.dao.LogDao;
import com.pojo.Apply;
import com.pojo.Log;
import com.pojo.User;
import com.service.LogService;
import com.util.GetTime;
import com.util.LayuiTable;
import com.util.SQLtoString;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class LogServiceImpl implements LogService {
    LayuiTable<Log> layuiTable = new LayuiTable<Log>();
    LogDaoImpl logDao = new LogDaoImpl();
    @Override
    public LayuiTable<Log> getLogList(int page, int limit) {
        ResultSet logSet = logDao.getAll(page, limit, "log");
        List<Log> logList = new ArrayList<Log>();
        int count = 0;
        try {
            ResultSet userDaoAll = logDao.getAll("log");
            while (userDaoAll.next()){
                count++;
            }
            while (logSet.next()){
                Log log = new Log();
                log.setLogId(logSet.getInt(1));
                log.setTime(logSet.getString(2));
                log.setName(logSet.getString(3));
                log.setAction(logSet.getString(4));
                log.setItem(logSet.getString(5));
                log.setOperate(logSet.getString(6));
                logList.add(log);
            }
            layuiTable.setCode(0);
            layuiTable.setData(logList);
            layuiTable.setCount(count);
            layuiTable.setMsg("");


        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }

    @Override
    public int setLog(String name, String action, String item,String operate) {
        Log log = new Log();
        String time = GetTime.getTime();
        log.setTime(time);
        log.setName(name);
        log.setAction(action);
        log.setItem(item);
        log.setOperate(operate);
        int num = 0;
        num = logDao.setLog(log);
        return num;
    }

    //获取事务类型（名称）
    @Override
    public List<Log> getLogItem() {
        List<Log> logList = logDao.getLogItem();
        int i = 1;
        for (Log log : logList) {
            log.setLogId(i);
            i++;
        }
        return logList;
    }

    //获取日志动作类型
    @Override
    public List<Log> getLogAction() {
        List<Log> logList = logDao.getLogAction();
        int i = 1;
        for (Log log : logList) {
            log.setLogId(i);
            i++;
        }
        return logList;
    }

    @Override
    public List<Log> getLogOperate() {
        List<Log> logList = logDao.getLogOperate();
        int i = 1;
        for (Log log : logList) {
            log.setLogId(i);
            i++;
        }
        return logList;
    }

    //条件查询日志内容
    @Override
    public LayuiTable<Log> Search(Log log, String startTime, String endTime,int page, int limit) {
        String sql = "";
        String sql1 = "";
        String[] keys = {"name","action","item","operate"};
        Object[] values = {log.getName(),log.getAction(),log.getItem(),log.getOperate()};
        if (log.getName()==null && log.getAction()==null&&log.getItem()==null&&log.getOperate()==null){
            sql1 = " WHERE DATE(time) BETWEEN " + "'" + startTime + "'" + " AND " + "'" + endTime + "'" ;
        }
        sql = SQLtoString.getSQL(keys, values, "log");
        sql += sql1;
        List<Log> searchLogList = logDao.Search(sql);
        LayuiTable<Log> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(searchLogList.size());
        layuiTable.setData(searchLogList);
        return layuiTable;
    }

    @Override
    public int delLog(int id) {
        return logDao.delLog(id);
    }
}
