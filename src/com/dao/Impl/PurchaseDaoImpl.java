package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.PurchaseDao;
import com.pojo.Apply;
import com.util.JDBC;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseDaoImpl extends InitDaoImpl implements PurchaseDao {
    @Override
    public ResultSet getAppointList() {
        String sql = "select * from apply \n" +
                "where pharmacistApprove = '未审阅';";
        Object[] obj = new Object[1];
        obj[0] = 0;
        return JDBC.select(sql, obj);
    }

    @Override
    public ResultSet getId(int id) {
        String sql = "select mId,applyBuyNumber,mName,specification,manufactor,unit,department,purchasePrice,salePrice,productDate,goodsType,mType,defined from dictionary right join (select aId,applyBuyNumber from app_order where oId = ?) ord1 on ord1.aId=dictionary.mId";
        Object[] objects = new Object[]{id};
        return JDBC.select(sql, objects);
    }

    @Override
    public boolean isok(int id,String name,String times) {
        String sql_1 = "update appoint set pharmacist = ?,pharmacistApprove = '已审阅通过',pharmacistTime = ? where applyId in (select applyId from app_order where oId = ?)";
        Object[] objects1 = new Object[]{name,times,id};
        JDBC.update(sql_1,objects1);
        String sql = "update orders set oName = '已审阅通过',specification = ?,pharmacistTime = ? where oId = ?";
        Object[] objects = new Object[]{name,times,id};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean noPass(int id,String name, String values,String times) {
        String sql_1 = "update appoint set pharmacist = ?,pharmacistApprove = '已审阅不通过',pharmacistTime = ? where applyId in (select applyId from app_order where oId = ?)";
        Object[] objects1 = new Object[]{name,times,id};
        JDBC.update(sql_1,objects1);
        String sql = "update orders set unit = ?,specification = ?,oName = '已审阅不通过',pharmacistTime = ? where oId = ?";
        Object[] objects = new Object[]{values,name,times,id};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean isOK_msg(long bath, String okType, String detail,int send, int receivePeo) {
        String sql = "insert into message(uId,uName,batch_num,message,time,state,message.title,message.receivePeople) values (?,(select userName from user where id = ?),?,?,?,0,?,(select userName from user where id = ?))";
        String nowTimesStr = StringDeal.getNowTimesStr();
        Object[] objects = new Object[]{send,send,bath,detail,nowTimesStr,okType,receivePeo};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean notOK_msg(int id,long bath, String NotType,int send, int receivePeo) {
        String sql = "insert into message(uId,uName,batch_num,message,time,state,message.title,message.receivePeople) values (?,(select userName from user where id = ?),?,(select unit from orders where oId = ?),?,0,?,(select userName from user where id = ?))";
        String nowTimesStr = StringDeal.getNowTimesStr();
        Object[] objects = new Object[]{send,send,bath,id,nowTimesStr,NotType,receivePeo};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public ResultSet getMsg() {
        String sql = "select * from message";
        return JDBC.select(sql, new Object[1]);
    }

    @Override
    public boolean setMsgState(int id) {
        String sql = "update message set state = 1 where message.id = ?";
        Object[] objects = new Object[]{id};
        return JDBC.update(sql, objects) > 0;
    }

}
