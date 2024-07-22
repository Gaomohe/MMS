package com.service.Impl;

import com.dao.Impl.GSPReportProDaoImpl;
import com.pojo.Appointment;
import com.pojo.echarts.GSPSupply;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.service.GSPReportProService;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GSPReportProServiceImpl implements GSPReportProService {
    GSPReportProDaoImpl gspReportProDao = new GSPReportProDaoImpl();

    @Override
    public ResultData<List<Times>> reTimes(int dayNum) {
        ResultData<List<Times>> timesResultData = new ResultData<>();
        List<Times> timesList = new ArrayList<>();
        List<String> days = StringDeal.getDay(dayNum);
            days.forEach(day->{
                Times times = new Times();
                times.setTimes(day);
                ResultSet resultSet1 = gspReportProDao.GSPGetNum(times.getTimes());
                try {
                    if (resultSet1.next()){
                        times.setNumber(resultSet1.getInt(1));
                    }
                    timesList.add(times);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            timesResultData.setStatus(200);
            timesResultData.setData(timesList);
            timesResultData.setMsg("");


        return timesResultData;
    }

    @Override
    public ResultData<List<GSPSupply>> getAllSup() {
        ResultData<List<GSPSupply>> resultData = new ResultData<List<GSPSupply>>();
        ResultSet kind = gspReportProDao.getKind("supplier", "apply");
        List<GSPSupply> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GSPSupply gspSupply = new GSPSupply();
                gspSupply.setName(kind.getString(1));
                ResultSet allSup = gspReportProDao.getAllSup(gspSupply.getName());
                if (allSup.next()){
                    gspSupply.setNum(allSup.getInt(1));
                }
                gspSupplies.add(gspSupply);
            }
            resultData.setData(gspSupplies);
            resultData.setMsg("");
            resultData.setStatus(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData<List<GetString>> getChoise01() {
        ResultSet kind = gspReportProDao.getKind("unit", "apply");
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = gspReportProDao.getChoise01(getString.getName());
                if (allSup.next()){
                    getString.setNumber(allSup.getInt(1));
                }
                gspSupplies.add(getString);
            }
            resultData.setData(gspSupplies);
            resultData.setMsg("");
            resultData.setStatus(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData<List<GetString>> getChoise02() {
        ResultSet kind = gspReportProDao.getKind("mName", "apply");
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        try {
            while (kind.next()){
                GetString getString = new GetString();
                getString.setName(kind.getString(1));
                ResultSet allSup = gspReportProDao.getChoise02(getString.getName());
                if (allSup.next()){
                    getString.setNumber(allSup.getInt(1));
                }
                gspSupplies.add(getString);
            }
            resultData.setData(gspSupplies);
            resultData.setMsg("");
            resultData.setStatus(200);

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    @Override
    public ResultData<List<GetString>> getChoise03() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        ResultData<List<GetString>> resultData = new ResultData<List<GetString>>();
        List<GetString> gspSupplies = new ArrayList<>();
        ResultSet choiseKind03 = gspReportProDao.getChoiseKind03(formattedDate);
        try {
            while (choiseKind03.next()){
                GetString getString = new GetString();
                getString.setName(choiseKind03.getString(1));
                ResultSet allSup = gspReportProDao.getChoise03(getString.getName());
                if (allSup.next()){
                    getString.setNumber(allSup.getInt(1));
                }
                gspSupplies.add(getString);
            }
            resultData.setData(gspSupplies);
            resultData.setMsg("");
            resultData.setStatus(200);


        }catch (Exception e){
            e.printStackTrace();
        }

        return resultData;
    }

    @Override
    public LayuiTable<Appointment> search(String[] key, String[] value) {
        LayuiTable<Appointment> appointmentLayuiTable = new LayuiTable<>();

        ResultSet resultSet = gspReportProDao.search(key, value, "apply");
        List<Appointment> appointList = new ArrayList<Appointment>();
        int count = 0;
        try {
            ResultSet userDaoAll = gspReportProDao.getAll("apply");
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
            appointmentLayuiTable.setCode(0);
            appointmentLayuiTable.setData(appointList);
            appointmentLayuiTable.setCount(count);
            appointmentLayuiTable.setMsg("");
        }catch (Exception e){
            e.printStackTrace();
        }
        return appointmentLayuiTable;
    }
}
