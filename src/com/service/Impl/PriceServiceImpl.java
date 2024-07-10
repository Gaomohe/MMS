package com.service.Impl;

import com.dao.Impl.PriceDaoImpl;
import com.dao.PriceDao;
import com.pojo.Price;
import com.service.PriceService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PriceServiceImpl implements PriceService {

    PriceDao priceDao = new PriceDaoImpl();
    @Override
    public int addHistory(Price price) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = simpleDateFormat.format(date);
        price.setTime(format);
        return priceDao.addHistory(price);
    }

    @Override
    public List<Price> getHistoryAll() {
        return priceDao.getHistoryAll();
    }

    @Override
    public List<Price> getHistoryByTab(int tableCoding) {
        return priceDao.getHistoryByTab(tableCoding);
    }

    @Override
    public List<Price> getHistoryByMid(int mId) {
        return priceDao.getHistoryByMid(mId);
    }

    @Override
    public Price getHistoryByTime(String Time) {
        return priceDao.getHistoryByTime(Time);
    }

    @Override
    public int delHistoryById(int id) {
        return priceDao.delHistoryById(id);
    }
}
