package com.service.Impl;

import com.dao.Impl.QualityDaoImpl;
import com.dao.Impl.SalReturnDaoImpl;
import com.dao.QualityDao;
import com.dao.SalReturnDao;
import com.pojo.Quality;
import com.pojo.SalReturn;
import com.service.SalReturnService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SalReturnServiceImpl implements SalReturnService {

    SalReturnDao salReturnDao = new SalReturnDaoImpl();

    QualityDao qualityDao = new QualityDaoImpl();

    @Override
    public int addSalReturn(int oId, int id) {
        String[] SPECIAL_CHARACTERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        List<String> usedNumbers = new ArrayList<>();
        UUID.randomUUID(); // 用于生成基础的唯一标识符
        String baseNum = Long.toHexString(UUID.randomUUID().getMostSignificantBits()).toUpperCase();
        while (usedNumbers.contains(baseNum)) {
            UUID.randomUUID(); // 如果已存在，则继续生成新的
            baseNum = Long.toHexString(UUID.randomUUID().getMostSignificantBits()).toUpperCase();
        }
        StringBuilder s = new StringBuilder(baseNum);
        for (int i = 0; i < 5; i++) { // 添加特殊字符
            int randomIndex = (int) (Math.random() * SPECIAL_CHARACTERS.length);
            s.append(SPECIAL_CHARACTERS[randomIndex]);
        }
        usedNumbers.add(baseNum);
        String string = s.toString();

        Quality qualityByID = qualityDao.getQualityByID(id);
        SalReturn salReturn = new SalReturn();
        salReturn.setReturnId(string);
        salReturn.setoId(oId);
        salReturnDao.addSalReturn(salReturn);
        return 0;
    }

    @Override
    public int getAllSalReturn() {
        return salReturnDao.getAllSalReturn();
    }

    @Override
    public List<SalReturn> getAllSalReturn(int page, int limit) {
        page = (page-1)*limit;
        return salReturnDao.getAllSalReturn(page,limit);
    }

    @Override
    public List<SalReturn> getAllSalReturn(int page, int limit, String order, String title) {
        page = (page-1)*limit;
        return salReturnDao.getAllSalReturn(page,limit,order,title);
    }

    @Override
    public SalReturn getSalReturnOne(int id) {
        return salReturnDao.getSalReturnOne(id);
    }

    @Override
    public int updateConsignee(SalReturn salReturn) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);

        SalReturn salReturnOne = salReturnDao.getSalReturnOne(salReturn.getId());
        salReturnOne.setAddress(salReturn.getAddress());
        salReturnOne.setShippingWay(salReturn.getShippingWay());
        salReturnOne.setConsigner(salReturn.getConsigner());
        salReturnOne.setShippingTime(format);

        return salReturnDao.updateConsignee(salReturnOne);
    }

    @Override
    public int updateAll(SalReturn salReturn) {
        return salReturnDao.updateAll(salReturn);
    }

    @Override
    public int delSalReturn(int id) {
        return salReturnDao.delSalReturn(id);
    }
}
