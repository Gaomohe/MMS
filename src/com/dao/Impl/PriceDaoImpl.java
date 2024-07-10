package com.dao.Impl;

import com.dao.PriceDao;
import com.pojo.Price;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PriceDaoImpl implements PriceDao {
    @Override
    public int addHistory(Price price) {
        String sql="INSERT INTO `pricehistory` (`tableCoding`,`mId`,`historyPrice`,`time`)\n" +
                "VALUES (?,?,?,?)";
        Object[] objects = new Object[]{price.getTableCoding(),price.getmId(),price.getHistoryPrice(),price.getTime()};
        return JDBC.update(sql,objects);
    }

    @Override
    public List<Price> getHistoryAll() {
        String sql="SELECT * FROM `pricehistory`";
        List<Price> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        try {
            while (resultSet.next()){
                Price price = new Price();
                price.setId(resultSet.getInt(1));
                price.setTableCoding(resultSet.getInt(2));
                price.setmId(resultSet.getInt(3));
                price.setHistoryPrice(resultSet.getDouble(4));
                price.setTime(resultSet.getString(5));
                list.add(price);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Price> getHistoryByTab(int tableCoding) {
        String sql="SELECT * FROM `pricehistory` WHERE `tableCoding`=?";
        Object[] objects = new Object[]{tableCoding};
        List<Price> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                Price price = new Price();
                price.setId(resultSet.getInt(1));
                price.setTableCoding(resultSet.getInt(2));
                price.setmId(resultSet.getInt(3));
                price.setHistoryPrice(resultSet.getDouble(4));
                price.setTime(resultSet.getString(5));
                list.add(price);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Price> getHistoryByMid(int mId) {
        String sql="SELECT * FROM `pricehistory` WHERE `mId`=?";
        Object[] objects = new Object[]{mId};
        List<Price> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                Price price = new Price();
                price.setId(resultSet.getInt(1));
                price.setTableCoding(resultSet.getInt(2));
                price.setmId(resultSet.getInt(3));
                price.setHistoryPrice(resultSet.getDouble(4));
                price.setTime(resultSet.getString(5));
                list.add(price);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Price getHistoryByTime(String Time) {
        String sql="SELECT * FROM `pricehistory` WHERE `time`=?";
        Object[] objects = new Object[]{Time};
        Price price = new Price();
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){

                price.setId(resultSet.getInt(1));
                price.setTableCoding(resultSet.getInt(2));
                price.setmId(resultSet.getInt(3));
                price.setHistoryPrice(resultSet.getDouble(4));
                price.setTime(resultSet.getString(5));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return price;
    }

    @Override
    public int delHistoryById(int id) {
        String sql="DELETE FROM `pricehistory` WHERE `id` = ?";
        Object[] objects = new Object[]{id};
        return JDBC.update(sql,objects);
    }
}
