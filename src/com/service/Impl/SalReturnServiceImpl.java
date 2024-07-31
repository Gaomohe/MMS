package com.service.Impl;

import com.dao.Impl.QualityDaoImpl;
import com.dao.Impl.SalReturnDaoImpl;
import com.dao.QualityDao;
import com.dao.SalReturnDao;
import com.pojo.Orders;
import com.pojo.Quality;
import com.pojo.SalReturn;
import com.service.SalReturnService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.util.Vessel.ordersService;

public class SalReturnServiceImpl implements SalReturnService {

    SalReturnDao salReturnDao = new SalReturnDaoImpl();

    QualityDao qualityDao = new QualityDaoImpl();

    @Override
    public int addSalReturn(int oId, int id,String name) {
        ordersService.backOrder(oId,name);
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
        salReturn.setState("未到货");
        salReturn.setmName("多药品");
        int i = salReturnDao.addSalReturn(salReturn);
        return i;
    }

    @Override
    public int addSalReturnOne(int oId, int id,String name) {
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
        salReturn.setState("未到货");
        salReturn.setmName(qualityByID.getmName());
        salReturn.setNumber(qualityByID.getTotlNumber());
        salReturn.setPrice(salReturnDao.getPrice(oId,qualityByID.getmId()));
        int i = salReturnDao.addSalReturnOne(salReturn);
        return i;
    }

    @Override
    public int getAllSalReturn() {
        return salReturnDao.getAllSalReturn();
    }

    @Override
    public List<SalReturn> getSalReturn() {
        return salReturnDao.getSalReturn();
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
    public List<SalReturn> getSalReturnByStatue(String state) {
        return salReturnDao.getSalReturnByStatue(state);
    }

    @Override
    public List<SalReturn> getSalReturnByEE(String consignee) {
        return salReturnDao.getSalReturnByEE(consignee);
    }

    @Override
    public List<SalReturn> getSalReturnByEr(String consigner) {
        return salReturnDao.getSalReturnByEr(consigner);
    }

    @Override
    public SalReturn getSalReturnByRId(String returnId) {
        return salReturnDao.getSalReturnByRId(returnId);
    }

    @Override
    public List<SalReturn> getSalReturnByCall(int callNumber) {
        return salReturnDao.getSalReturnByCall(callNumber);
    }

    @Override
    public int updateConsignee(SalReturn salReturn) {

        return salReturnDao.updateConsignee(salReturn);
    }

    @Override
    public int updateStatue(SalReturn salReturn) {
        SalReturn salReturnOne = salReturnDao.getSalReturnOne(salReturn.getId());
        salReturnOne.setState(salReturn.getState());
        return salReturnDao.updateStatue(salReturnOne);
    }

    @Override
    public int updateAll(SalReturn salReturn) {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);

        SalReturn salReturnOne = salReturnDao.getSalReturnOne(salReturn.getId());
        salReturnOne.setAddress(salReturn.getAddress());
        salReturnOne.setShippingWay(salReturn.getShippingWay());
        salReturnOne.setConsigner(salReturn.getConsigner());
        salReturnOne.setCallNumber(salReturn.getCallNumber());
        salReturnOne.setShippingTime(format);
        return salReturnDao.updateAll(salReturnOne);
    }

    @Override
    public int delSalReturn(int id) {
        return salReturnDao.delSalReturn(id);
    }
}
