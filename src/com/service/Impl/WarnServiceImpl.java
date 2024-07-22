package com.service.Impl;

import com.dao.Impl.WarnDaoImpl;
import com.dao.WarnDao;
import com.pojo.Medicine;
import com.pojo.Warn;
import com.pojo.WarnDetail;
import com.service.WarnService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.util.Vessel.medicineDao;

public class WarnServiceImpl implements WarnService {

    WarnDao warnDao = new WarnDaoImpl();
    @Override
    public int addWarn(Warn warn) {
        Medicine medicine = medicineDao.getMedicine(warn.getTableCoding());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        warn.setTime(format);
        return 0;
    }

    @Override
    public int addWarnDetail(WarnDetail warnDetail) {
        return 0;
    }

    @Override
    public int addWarn_detail(int wId, int wdId) {
        return 0;
    }

    @Override
    public List<Warn> getWarns() {
        return null;
    }

    @Override
    public List<WarnDetail> getWarnDetails() {
        return null;
    }

    @Override
    public List<Warn> getWarnsByQuery(String[] title, String[] values) {
        return null;
    }

    @Override
    public List<WarnDetail> getWarnDetailsByQuery(String[] title, String[] values) {
        return null;
    }

    @Override
    public int delWarn(int id) {
        return 0;
    }

    @Override
    public int delWarnDetail(int id) {
        return 0;
    }

    @Override
    public int delWarn_detail(int id) {
        return 0;
    }

    @Override
    public int upWarn(String[] title, String[] values) {
        return 0;
    }
}
