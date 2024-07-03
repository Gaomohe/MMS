package com.dao;

import com.pojo.Type;

import java.util.List;

public interface TypeDao {
    //新增商品类
    public int addGoodsType(Type type);
    //新增药品类
    public int addMType(Type type);
    //新增自定义类
    public int addfreeType(Type type);
    //新增剂型
    public int dosage(Type type);

    //查询商品类
    public List<Type> getAllGoodsType ();
    //查询药品类
    public List<Type> getAllMType();
    //查询自定义类
    public List<Type> getAllfreeType();
    //查询剂型
    public List<Type> getAlldosage();

    //删除商品类
    public int delGoodsType(String type);
    //删除药品类
    public int delMType(String type);
    //删除自定义类
    public int delfreeType(String type);
    //删除剂型
    public int deldosage(String type);

}
