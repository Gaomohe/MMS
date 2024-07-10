package com.service.Impl;

import com.dao.CuringDao;
import com.dao.Impl.CuringDaoImpl;
import com.pojo.Curing;
import com.service.CuringService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CurdingServiceImpl implements CuringService {

    CuringDao curingDao = new CuringDaoImpl();
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
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        return curingDao.getCuring();
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
