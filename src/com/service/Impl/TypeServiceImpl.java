package com.service.Impl;

import com.dao.Impl.TypeDaoImpl;
import com.dao.TypeDao;
import com.pojo.Type;
import com.service.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {


    TypeDao typeDao = new TypeDaoImpl();
    //新增
    @Override
    public int addGoodsType(Type type) {
        return typeDao.addGoodsType(type);
    }

    @Override
    public int addMType(Type type) {
        return typeDao.addMType(type);
    }

    @Override
    public int addfreeType(Type type) {
        return typeDao.addfreeType(type);
    }

    @Override
    public int dosage(Type type) {
        return typeDao.dosage(type);
    }

    //查询所有
    @Override
    public List<Type> getAllGoodsType() {
        int i = 1;
        List<Type> typeList = typeDao.getAllGoodsType();
        for (Type type : typeList){
            type.setId(i);
            i++;
        }
        return typeList;
    }

    @Override
    public List<Type> getAllMType() {
        int i = 1;
        List<Type> typeList = typeDao.getAllMType();
        for (Type type : typeList){
            type.setId(i);
            i++;
        }
        return typeList;
    }

    @Override
    public List<Type> getAllfreeType() {
        int i = 1;
        List<Type> typeList = typeDao.getAllfreeType();
        for (Type type : typeList){
            type.setId(i);
            i++;
        }
        return typeList;
    }

    @Override
    public List<Type> getAlldosage() {
        int i = 1;
        List<Type> typeList = typeDao.getAlldosage();
        for (Type type : typeList){
            type.setId(i);
            i++;
        }
        return typeList;
    }

    @Override
    public Type isAllGoodsType(String type) {
        return typeDao.isAllGoodsType(type);
    }

    @Override
    public Type isAllMType(String type) {
        return typeDao.isAllMType(type);
    }

    @Override
    public Type isAllfreeType(String type) {
        return typeDao.isAllfreeType(type);
    }

    @Override
    public Type isAlldosage(String type) {
        return typeDao.isAlldosage(type);
    }

    //删除
    @Override
    public int delGoodsType(String type) {
        return typeDao.delGoodsType(type);
    }

    @Override
    public int delMType(String type) {
        return typeDao.delMType(type);
    }

    @Override
    public int delfreeType(String type) {
        return typeDao.delfreeType(type);
    }

    @Override
    public int deldosage(String type) {
        return typeDao.deldosage(type);
    }
}
