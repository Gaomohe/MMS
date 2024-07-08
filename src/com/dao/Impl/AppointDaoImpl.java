package com.dao.Impl;

import com.dao.AppointDao;
import com.dao.Impl.init.InitDaoImpl;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.pojo.*;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.List;

public class AppointDaoImpl extends InitDaoImpl implements AppointDao {
    @Override
    public int delAppoint(int id) {
        String sql = "delete from appoint where mId=?";
        Object[] obj = new Object[1];
        obj[0] = id;
        int update = JDBC.update(sql, obj);
        return update;
    }

    //获取所有已批申请
    @Override
    public ResultSet getAppointList() {
        String sql = "select * from apply \n" +
                "where pharmacistApprove = '已批准' and financeApprove = '已批准';";
        /*
        select * from dictionary
where tableCoding in (
    select mId from sub_apply
    );
        */
        Object[] obj = new Object[1];
        obj[0] = 0;
        return JDBC.select(sql, obj);
    }


    @Override
    public int addOrder(buyOrder order) {
        String sql = "insert into buyOrder(allPrice) value (?);";
        Object[] objects = new Object[1];

        objects[0] = order.getAllPrice();
//        objects[2] = order.getStatus();
        int add = JDBC.update(sql, objects);
        return add;
    }

    @Override
    public int getOrderId() {
        String sql = "SELECT id from buyOrder\n" +
                "where id > ? AND id IN (\n" +
                "    SELECT MAX(id) FROM buyOrder\n" +
                "    )";
        Object[] objects = new Object[1];
        objects[0] = 0;
        ResultSet resultSet = JDBC.select(sql, objects);
        int id = 0;
        try{
            while(resultSet.next()){
                id = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int addAppoint(int id, int bId) {
        String sql = "insert into app_order(oId,aId) value(?,?)";
        Object[] objects = new Object[2];
        objects[1] = id;
        objects[0] = bId;
        int update = JDBC.update(sql, objects);
        return update;
    }

    ////返回价格数量
    @Override
    public Appointment getAppoint(int id) {
        String sql = "select * from apply where mId=?";
        Object[] objects = new Object[1];
        objects[0] = id;
        Appointment appointment = new Appointment();
        ResultSet resultSet = JDBC.select(sql, objects);
        try{
            while (resultSet.next()) {
                appointment.setNumber(resultSet.getInt("number"));
                appointment.setPurchasePrice(resultSet.getDouble("purchasePrice"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return appointment;
    }

    //填充apply表数据
    @Override
    public int insertApply(Apply apply) {
        String sql = "insert into apply(mId,mName,specification,manufactor,unit,\n" +
                "                  department,number,applyNumber,purchasePrice,\n" +
                "                  code,mType,supplier,approvalNumber,placeOrigin,\n" +
                "                  applyUser,applyTime,tableCoding)\n" +
                "value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        Object[] objects = new Object[17];
        objects[0] = apply.getmId();
        objects[1] = apply.getmName();
        objects[2] = apply.getSpecification();
        objects[3] = apply.getManufactor();
        objects[4] = apply.getUnit();
        objects[5] = apply.getDepartment();
        objects[6] = apply.getNumber();
        objects[7] = apply.getApplyNumber();
        objects[8] = apply.getPurchasePrice();
        objects[9] = apply.getCode();
        objects[10] = apply.getmType();
        objects[11] = apply.getSupplier();
        objects[12] = apply.getApprovalNumber();
        objects[13] = apply.getPlaceOrigin();
        objects[14] = apply.getApplyUser();
        objects[15] = apply.getApplyTime();
        objects[16] = apply.getTableCoding();
        int update = JDBC.update(sql, objects);
        return update;
    }
}
