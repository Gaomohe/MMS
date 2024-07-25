package com.service.Impl;

import com.dao.ApplyDao;
import com.dao.AppointDao;
import com.dao.Impl.AppointDaoImpl;
import com.pojo.*;
import com.service.AppointService;
import com.service.QualityService;
import com.service.ShoppingService;
import com.sun.java.browser.plugin2.DOM;
import com.util.BaseDao;
import com.util.LayuiTable;
import com.util.SQLtoString;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.util.Vessel.shoppingService;

public class AppointServiceImpl implements AppointService {
    AppointDao appointDao = new AppointDaoImpl();
    AppointDaoImpl appointDaoImpl = new AppointDaoImpl();
    LayuiTable<Appointment> layuiTable = new LayuiTable();

    QualityService qualityService = new QualityServiceImpl();
    @Override
    public int delAppoint(int id) {
        return appointDao.delAppoint(id);
    }

    @Override
    public LayuiTable<Appointment> getAppointList(int page, int limit) {
        ResultSet resultSet = appointDaoImpl.getAll(page, limit, "apply");
        List<Appointment> appointList = new ArrayList<Appointment>();
        int count = 0;
        try {
            ResultSet userDaoAll = appointDaoImpl.getAll("apply");
            while (userDaoAll.next()){
                count++;
            }
            while (resultSet.next()){
                Appointment appointment = new Appointment();
                appointment.setApplyId(resultSet.getInt(1));
                appointment.setmId(resultSet.getInt(2));
                appointment.setmName(resultSet.getString(3));
                appointment.setSpecification(resultSet.getString(4));
                appointment.setManufactor(resultSet.getString(5));
                appointment.setUnit(resultSet.getString(6));
                appointment.setDepartment(resultSet.getString(7));
                appointment.setNumber(resultSet.getInt(8));
                appointment.setApplyNumber(resultSet.getInt(9));
                appointment.setPurchasePrice(resultSet.getDouble(10));
                appointment.setCode(resultSet.getString(11));
                appointment.setmType(resultSet.getString(12));
                appointment.setSupplier(resultSet.getString(13));
                appointment.setApprovalNumber(resultSet.getString(14));
                appointment.setPlaceOrigin(resultSet.getString(15));
                appointment.setApplyUser(resultSet.getString(16));
                appointment.setApplyTime(resultSet.getString(17));
                appointment.setPharmacist(resultSet.getString(18));
                appointment.setPharmacistApprove(resultSet.getString(19));
                appointment.setPharmacistTime(resultSet.getString(20));
                appointment.setFinance(resultSet.getString(21));
                appointment.setFinanceApprove(resultSet.getString(22));
                appointment.setFinanceTime(resultSet.getString(23));
                appointment.setTableCoding(resultSet.getInt(24));
                appointList.add(appointment);
            }
            layuiTable.setCode(0);
            layuiTable.setData(appointList);
            layuiTable.setCount(count);
            layuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }

    //生成订单
    @Override
    public int addAppoint(List<Integer> idList) {
        Orders orders = new Orders();
        buyOrder buyorder = new buyOrder();
        double allPrice = 0;
        Appointment appointment = new Appointment();
        int count = idList.size();
        int num = 0;
        int m = 0;

        for(int id : idList){
            appointment = appointDao.getAppoint(id);
            allPrice = appointment.getNumber() * appointment.getPurchasePrice();
            int number = appointDao.getNumber(id);
            Apply apply = appointDao.getManufactor(id);
            orders.setManufactor(apply.getManufactor());
            orders.setBuyer(apply.getApplyUser());
            orders.setShippingAddress(apply.getManufactor());

            Quality quality = new Quality();
            quality.setTableCoding(id);
            quality.setTotlNumber(number);
            qualityService.addQuality(quality);
        }

        orders.setAllPrice(allPrice);
        double advance = allPrice * 0.3;
        double finals = allPrice - advance;
        orders.setAdvance(advance);
        orders.setFinals(finals);

        buyorder.setAllPrice(allPrice);
        int i1 = appointDao.addOrder(buyorder);
        int bId = appointDao.getOrderId();
        orders.setoId(bId);
        for(int id : idList){
            appointment = appointDao.getAppoint(id);
            int i = appointDao.addAppoint(id,bId,appointment.getApplyNumber());
            if (i > 0){
                num++;
            }
        }
        if (num==count){
            m = 1;
        }

        //获取订单id，供应商名称

        int i = this.insertOrder(orders);
        return m;
    }

    //填充apply表数据
    @Override
    public int insertApply() {
        int i = 0;
        List<Medicine> medicineList = shoppingService.memoryList();
        for (Medicine medicine : medicineList) {
            List<Apply> applyList = shoppingService.subApplyList();
            for (Apply apply : applyList){
                if (apply.getmId() == medicine.getTableCoding()){
                    apply.setmId(medicine.getmId());
                    apply.setmName(medicine.getmName());
                    apply.setSpecification(medicine.getSpecification());
                    apply.setManufactor(medicine.getManufactor());
                    apply.setUnit(medicine.getUnit());
                    apply.setDepartment(medicine.getDepartment());
                    apply.setNumber(medicine.getNumber());
                    apply.setPurchasePrice(medicine.getPurchasePrice());
                    apply.setCode(medicine.getCode());
                    apply.setmType(medicine.getmType());
                    apply.setSupplier(medicine.getSupplier());
                    apply.setApprovalNumber(medicine.getApprovalNumber());
                    apply.setPlaceOrigin(medicine.getPlaceOrigin());
                    apply.setTableCoding(medicine.getTableCoding());
                    i = appointDao.insertApply(apply);
                }
            }
        }
        return i;
    }

    //获取供应商
    @Override
    public List<Apply> getSupplier() {
        int i = 1;
        List<Apply> applyList = appointDao.getSupplier();
        for (Apply apply : applyList){
            apply.setApplyId(i);
            i++;
        }
        return applyList;
    }

    //获取药品类型
    @Override
    public List<Apply> getmType() {
        int i = 1;
        List<Apply> applyList = appointDao.getmType();
        for (Apply apply : applyList){
            apply.setApplyId(i);
            i++;
        }
        return applyList;
    }

    //获取药品名称
    @Override
    public List<Apply> getmName() {
        int i = 1;
        List<Apply> applyList = appointDao.getmName();
        for (Apply apply : applyList){
            apply.setApplyId(i);
            i++;
        }
        return applyList;
    }

    //条件查询预购订单表
    @Override
    public LayuiTable<Apply> Search(Apply apply, int page, int limit) {
        String sql = "";
        String[] keys = {"mName","mType","supplier"};
        Object[] values = {apply.getmName(),apply.getmType(),apply.getSupplier()};
        sql = SQLtoString.getSQL(keys, values, "apply");
        List<Apply> searchLogList = appointDao.Search(sql);
        LayuiTable<Apply> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(searchLogList.size());
        layuiTable.setData(searchLogList);
        return layuiTable;
    }

    //订单信息填充
    @Override
    public int insertOrder(Orders orders) {
        return appointDao.insertOrder(orders);
    }

    //订单信息回显
    @Override
    public LayuiTable<Appointment> selectAppoint(List<Integer> idList) {
        List<Appointment> appointmentList = new ArrayList<>();
        int count = 0;
        for (int id : idList){
            Appointment appointment = appointDao.selectAppoint(id);
            appointmentList.add(appointment);
        }
        LayuiTable<Appointment> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(count);
        layuiTable.setData(appointmentList);
        return layuiTable;
    }

    //添加订单
    @Override
    public int Submit(List<Integer> idsList) {
        SqlSession session = BaseDao.getSqlSession();
        Orders orders = new Orders();
        double allPrices = 0;
        List<Apply> applyList = new ArrayList<>();
        int num = 0;
        int mum = 0;

        // 创建 Apply 对象并添加到列表中
        for (int id : idsList){
            Apply apply = new Apply();
            apply.setApplyId(id); // 假设 applyId 是你的主键字段
            applyList.add(apply);
        }

        // 从数据库获取 Apply 对象的详细信息
        for (Apply apply : applyList){
            Apply apply1 = session.getMapper(ApplyDao.class).getApplyPrice(apply);
            if (apply1 != null) {
                apply.setApplyId(apply1.getApplyId());
                apply.setmId(apply1.getmId());
                apply.setmName(apply1.getmName());
                apply.setSpecification(apply1.getSpecification());
                apply.setManufactor(apply1.getManufactor());
                apply.setUnit(apply1.getUnit());
                apply.setDepartment(apply1.getDepartment());
                apply.setNumber(apply1.getNumber());
                apply.setApplyNumber(apply1.getApplyNumber());
                apply.setPurchasePrice(apply1.getPurchasePrice());
                apply.setCode(apply1.getCode());
                apply.setmType(apply1.getmType());
                apply.setSupplier(apply1.getSupplier());
                apply.setApprovalNumber(apply1.getApprovalNumber());
                apply.setPlaceOrigin(apply1.getPlaceOrigin());
                apply.setApplyUser(apply1.getApplyUser());
                apply.setApplyTime(apply1.getApplyTime());
                apply.setPharmacist(apply1.getPharmacist());
                apply.setPharmacistApprove(apply1.getPharmacistApprove());
                apply.setPharmacistTime(apply1.getPharmacistTime());
                apply.setFinance(apply1.getFinance());
                apply.setFinanceApprove(apply1.getFinanceApprove());
                apply.setFinanceTime(apply1.getFinanceTime());
                apply.setTableCoding(apply1.getTableCoding());
                allPrices += apply.getApplyNumber() * apply.getPurchasePrice();
                orders.setManufactor(apply.getManufactor());
                orders.setShippingAddress(apply.getPlaceOrigin());
                orders.setBuyer(apply.getApplyUser());
            } else {
                // 处理 apply1 为 null 的情况
                System.out.println("No data found for applyId: " + apply.getApplyId());
            }
        }

        // 插入订单并获取生成的 ID

        orders.setAllPrice(allPrices);
        orders.setAdvance(0.3*allPrices);
        orders.setFinals(allPrices-orders.getAdvance());
        session.getMapper(ApplyDao.class).addApply(orders);
        int oId = orders.getoId();

        System.out.println("Generated Order ID: " + oId);

        //将订单id与订单详情药品id对应
        Apporder apporder = new Apporder();
        apporder.setoId(orders.getoId());
        for (Apply apply : applyList){
            apporder.setaId(apply.getmId());
            apporder.setApplyBuyNumber(apply.getApplyNumber());
            num = session.getMapper(ApplyDao.class).addAppOrder(apporder);
            //添加订单后将其从apply表转移至appoint表
            int i = session.getMapper(ApplyDao.class).shiftApply(apply);
            //转移完成后删除
            if (i > 0) {
                mum = session.getMapper(ApplyDao.class).delApply(apply);
            }
        }


        session.commit(); // 提交事务
        session.close(); // 关闭会话
        return num + mum;
    }

}
