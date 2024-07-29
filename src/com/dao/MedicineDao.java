package com.dao;

import com.pojo.DicNum;
import com.pojo.Medicine;

import java.util.List;

public interface MedicineDao {
    //药品增加
    public int addMedicine(Medicine medicine);
    //药品删除
    public int delMedicine(int tableCoding);
    public int delMedicineByMId(int mId);
    //药品价格修改
    public int updateMedicinePrice(Medicine medicine);
    //药品养护日期修改
    public int updateMedicineLastCuringDate(Medicine medicine);
    //药品入库时间修改
    public int updateMedicineWarehousingDate(Medicine medicine);
    //药品库存数量修改
    public int updateMedicineNumber(Medicine medicine);
    //药品基本信息修改
    public int updateMedicineBasic(Medicine medicine);
    //全部查询
    public List<Medicine> getAllMedicine(int index,int limit);
    public List<Medicine> getAllMedicine(int index,int limit,String order,String title);
    public int getAllMedicine();
    //全部查询
    public List<Medicine> getMedicineByMId(int mId);
    //药品回显
    public Medicine getMedicine(int tableCoding);
    //通过名称模糊查询
    public List<Medicine> getMedicine(String mName);
    //多条件查询（药品名称，商品分类，药品功效，剂型）
    public List<Medicine> getMedicineByQuery(String sql);
    //根据养护时间模糊查询药品
    public List<Medicine> getMidicineByTime(String time);
    //库存维护表新增
    public int addDic_Num(Medicine medicine,int patientId,int number);
    //库存数据获得
    public DicNum getDic_Num(int tableCoding, int patirntId);
    //获得所有维护表数据
    public List<DicNum> getDic_Num();
    public List<DicNum> getDic_Num(String yifukuan);
    //更新维护表付款状态
    public int updateDic_Num(DicNum dicNum);
    //回滚后删除维护表信息
    public int delDic_Num(int id);
}
