package com.service.Impl;

import com.dao.Impl.ApprovalDaoImpl;
import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.Sub_Apply;
import com.pojo.User;
import com.service.ApprovalService;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApprovalServiceImpl implements ApprovalService {
    ApprovalDaoImpl approvalDao = new ApprovalDaoImpl();
    LayuiTable<Appointment> appointmentLayuiTable = new LayuiTable<>();
    ResultData<List<Appointment>> appointmentResultData = new ResultData<>();
    ResultData<Integer> integerResultData = new ResultData<>();
    @Override
    public ResultData<List<Appointment>> getAuditId(int[] id) {
        List<Appointment> applyList = new ArrayList<>();
                try {
                    for (int ids:id) {
                        ResultSet resultSet = approvalDao.getOne(ids, "applyId", "apply");

                    }
                    appointmentResultData.setData(applyList);
                    appointmentResultData.setMsg("");
                    appointmentResultData.setStatus(200);

                }catch (Exception e){
                    e.printStackTrace();
                }

        return appointmentResultData;
    }

    @Override
    public List<User> getApplyUser() {
        List<User> userList = new ArrayList<>();
        ResultSet kind = approvalDao.getKind("applyUser", "apply");
        try {
            while (kind.next()){
                User user = new User();
                user.setUserName(kind.getString("applyUser"));
                userList.add(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public LayuiTable<Appointment> search(String[] keys, String[] values) {
        List<String> listKey = new ArrayList<>();
        List<String> listValues = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (!values[i].equals("")){
                listValues.add(values[i]);
                listKey.add(keys[i]);
            }
        }
        String[] keyList = new String[listKey.size()];
        String[] valuesList = new String[listValues.size()];
        keyList = listKey.toArray(keyList);
        valuesList = listValues.toArray(valuesList);
        ResultSet resultSet = approvalDao.search(keyList, valuesList, "apply");
        List<Appointment> appointmentList = new ArrayList<>();
        int count = 0;
        try {
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
                appointmentList.add(appointment);
                count++;
            }
            appointmentLayuiTable.setData(appointmentList);
            appointmentLayuiTable.setMsg("");
            appointmentLayuiTable.setCode(0);
            appointmentLayuiTable.setCount(count);

        }catch (Exception e){
            e.printStackTrace();
        }
        return appointmentLayuiTable;
    }

    @Override
    public ResultData<Integer> del(int[] ints) {
        try {
            for (int i:ints) {
                if (approvalDao.delOne(i, "applyId", "apply")){
                    integerResultData.setStatus(200);
                    integerResultData.setMsg("");
                    integerResultData.setData(1);
                }else {
                    integerResultData.setStatus(400);
                    integerResultData.setMsg("");
                    integerResultData.setData(0);
                    break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return integerResultData;
    }

    @Override
    public ResultData<Integer> isok(int[] ints,String userName) {
        try {
            for (int anInt : ints) {
                if (approvalDao.isok(anInt,userName)) {
                    integerResultData.setData(1);
                    integerResultData.setStatus(200);
                }else {
                    integerResultData.setData(0);
                    integerResultData.setStatus(400);
                }
                integerResultData.setMsg("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return integerResultData;
    }

    @Override
    public ResultData<Integer> nook(int[] ints,String userName) {
        try {
            for (int anInt : ints) {
                if (approvalDao.nook(anInt,userName)) {
                    integerResultData.setData(1);
                    integerResultData.setStatus(200);
                }else {
                    integerResultData.setData(0);
                    integerResultData.setStatus(400);
                }
                integerResultData.setMsg("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return integerResultData;
    }

    @Override
    public ResultData<List<Apply>> getHistory() {
        ResultData<List<Apply>> sub_applyResultData = new ResultData<>();
        ResultSet allDesc = approvalDao.getAllDesc("applyId", "apply");

        int count = 0;
        List<Apply> list = new ArrayList<>();
        try {
            while (allDesc.next()){
                Apply ap = new Apply();
                ap.setApplyId(allDesc.getInt(1));
                ap.setmId(allDesc.getInt(2));
                ap.setApplyNumber(allDesc.getInt("applyNumber"));
                ap.setPharmacistApprove(allDesc.getString("pharmacistApprove"));
                ap.setApplyTime(allDesc.getString("applyTime"));
                ap.setmName(allDesc.getString(3));
                count++;
                list.add(ap);
                if (count==99){
                    break;
                }
            }
            sub_applyResultData.setData(list);
            sub_applyResultData.setMsg("");
            sub_applyResultData.setStatus(200);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sub_applyResultData;
    }

    @Override
    public ResultData<Integer> noaudit(int[] ints, String name) {
        for (int i : ints) {
            if (approvalDao.noaudit(i,name)){
                integerResultData.setStatus(200);
            }else {
                integerResultData.setStatus(400);
                break;
            }
        }
        return integerResultData;
    }



    @Override
    public LayuiTable<Appointment> delOK() {
        ResultSet resultSet = approvalDao.getOne("未审阅", "pharmacistApprove", "apply");
        int count = 0;
        List<Appointment> appointmentList = new ArrayList<>();
        try {
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
                appointmentList.add(appointment);
                count++;
            }
            appointmentLayuiTable.setData(appointmentList);
            appointmentLayuiTable.setMsg("");
            appointmentLayuiTable.setCode(0);
            appointmentLayuiTable.setCount(count);

        }catch (Exception e){
            e.printStackTrace();
        }
        return appointmentLayuiTable;
    }
}
