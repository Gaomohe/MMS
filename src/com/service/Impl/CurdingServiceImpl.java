package com.service.Impl;

import com.dao.CuringDao;
import com.dao.Impl.CuringDaoImpl;
import com.dao.Impl.MedicineDaoImpl;
import com.dao.MedicineDao;
import com.pojo.Curing;
import com.pojo.Medicine;
import com.service.CuringService;
import com.util.GetTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.util.SQLtoString.getSQL;

public class CurdingServiceImpl implements CuringService {

    CuringDao curingDao = new CuringDaoImpl();
    MedicineDao medicineDao = new MedicineDaoImpl();
    @Override
    public List<Curing> getCuring() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        List<Curing> curing = curingDao.getCuring();
        int i = 0;
        for (Curing curing1:curing){
            try {
                Date parse1 = simpleDateFormat.parse(format);
                Date parse2 = simpleDateFormat.parse(curing1.getTime());
                if (parse2.before(parse1)){
                    curing1.setState(1);
                }else {

                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        return curingDao.getCuring();
    }

    public List<Medicine> getState(int index,int limit,String order,String title) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        List<Medicine> allMedicine = medicineDao.getAllMedicine(index,limit,order,title);
        List<Medicine> allMedicine1 = new ArrayList<>();
        int i = 0;
        for (Medicine medicine:allMedicine){
            try {
                Date parse1 = simpleDateFormat.parse(format);
                Date parse2 = simpleDateFormat.parse(medicine.getLastCuringDate());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parse1);
                calendar.add(Calendar.DAY_OF_MONTH, -2); // Subtract 2 days from parse1
                Date twoDaysAgo = calendar.getTime();
                if (parse2.after(twoDaysAgo)){
                    medicine.setState(1);
                }else {
                    medicine.setState(0);
                }
                allMedicine1.add(medicine);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return allMedicine1;
    }

    public List<Medicine> getState(int index,int limit) {
        int page = (index-1)*limit;
        String time = GetTime.getTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Medicine> allMedicine = medicineDao.getAllMedicine(page,limit);
        List<Medicine> allMedicine1 = new ArrayList<>();
        int i = 0;
        for (Medicine medicine:allMedicine){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                // 尝试解析字符串
                Date date = sdf.parse(medicine.getLastCuringDate());
                LocalDateTime parse1 = LocalDateTime.parse(time,formatter);
                LocalDateTime twoDaysAgo = parse1.minusDays(2);
                LocalDateTime parse2 = LocalDateTime.parse(medicine.getLastCuringDate(),formatter);
                if (parse2.isAfter(twoDaysAgo)){
                    medicine.setState(0);
                }else {
                    medicine.setState(1);
                }
                allMedicine1.add(medicine);
            } catch (ParseException e) {
                // 如果抛出异常，则表示字符串不符合指定的日期时间格式
                System.out.println(medicine.getLastCuringDate() + " 不符合 yyyy-MM-dd HH:mm:ss 格式");
            }

        }

        return allMedicine1;
    }

    public List<Medicine> getStateByQuery(String[] query) {
        int i = 0;
        String[] keys = {"goodsType","mType","defined","drugFrom"};//这里是键
        Object[] values = {query[0],query[1],query[2],query[3]};//这里是值
        String dictionary = getSQL(keys, values, "dictionary");//apply是表名
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        List<Medicine> allMedicine = medicineDao.getMedicineByQuery(dictionary);
        List<Medicine> allMedicine1 = new ArrayList<>();
        for (Medicine medicine:allMedicine){
            try {
                Date parse1 = simpleDateFormat.parse(format);
                Date parse2 = simpleDateFormat.parse(medicine.getLastCuringDate());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parse1);
                calendar.add(Calendar.DAY_OF_MONTH, -2); // Subtract 2 days from parse1
                Date twoDaysAgo = calendar.getTime();
                if (parse2.after(twoDaysAgo)){
                    medicine.setState(0);
                }else {
                    medicine.setState(1);
                }
                allMedicine1.add(medicine);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return allMedicine1;
    }

    @Override
    public List<Curing> getCuringByTab(int tableCoding) {
        return curingDao.getCuringByTab(tableCoding);
    }

    @Override
    public List<Curing> getCuringByMId(int mId) {
        return curingDao.getCuringByMId(mId);
    }

    @Override
    public List<Curing> getCuringByTime(String time) {
        return curingDao.getCuringByTime(time);
    }

    @Override
    public List<Medicine> getMidicineByTime(String time) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        List<Medicine> allMedicine = medicineDao.getMidicineByTime(time);
        List<Medicine> allMedicine1 = new ArrayList<>();
        for (Medicine medicine:allMedicine){
            try {
                Date parse1 = simpleDateFormat.parse(format);
                Date parse2 = simpleDateFormat.parse(medicine.getLastCuringDate());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parse1);
                calendar.add(Calendar.DAY_OF_MONTH, -2); // Subtract 2 days from parse1
                Date twoDaysAgo = calendar.getTime();
                if (parse2.after(twoDaysAgo)){
                    medicine.setState(0);
                }else {
                    medicine.setState(1);
                }
                allMedicine1.add(medicine);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return allMedicine1;
    }
    public List<Medicine> getMidicineByName(String name) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        List<Medicine> allMedicine = medicineDao.getMedicine(name);
        List<Medicine> allMedicine1 = new ArrayList<>();
        for (Medicine medicine:allMedicine){
            try {
                Date parse1 = simpleDateFormat.parse(format);
                Date parse2 = simpleDateFormat.parse(medicine.getLastCuringDate());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parse1);
                calendar.add(Calendar.DAY_OF_MONTH, -2); // Subtract 2 days from parse1
                Date twoDaysAgo = calendar.getTime();
                if (parse2.after(twoDaysAgo)){
                    medicine.setState(0);
                }else {
                    medicine.setState(1);
                }
                allMedicine1.add(medicine);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return allMedicine1;
    }

    @Override
    public int updataCuring(Curing curing) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        curing.setTime(format);
        return curingDao.updataCuring(curing);
    }

    @Override
    public int addCuring(Curing curing) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        curing.setTime(format);
        return curingDao.addCuring(curing);
    }

    @Override
    public int delCuring(int id) {
        return curingDao.delCuring(id);
    }
}
