package com.service.Impl;

import com.dao.Impl.MedicineDaoImpl;
import com.dao.MedicineDao;
import com.pojo.Medicine;
import com.service.MedicineService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    MedicineDao medicineDao = new MedicineDaoImpl();
    @Override
    public int addMedicine(Medicine medicine) {

        return medicineDao.addMedicine(medicine);
    }

    @Override
    public int delMedicine(int tableCoding) {

        return medicineDao.delMedicine(tableCoding);
    }

    @Override
    public int delMedicineByMId(int mId) {

        return medicineDao.delMedicineByMId(mId);
    }

    @Override
    public int updateMedicinePrice(Medicine medicine) {

        return medicineDao.updateMedicinePrice(medicine);
    }

    @Override
    public int updateMedicineLastCuringDate(int  tableCoding) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Medicine medicine = new Medicine();
        medicine.setTableCoding(tableCoding);
        medicine.setLastCuringDate(format);
        return medicineDao.updateMedicineLastCuringDate(medicine);
    }

    @Override
    public int updateMedicineWarehousingDate(Medicine medicine) {

        return medicineDao.updateMedicineWarehousingDate(medicine);
    }

    @Override
    public int updateMedicineNumber(Medicine medicine) {

        return medicineDao.updateMedicineNumber(medicine);
    }

    @Override
    public int updateMedicineBasic(Medicine medicine) {

        return medicineDao.updateMedicineBasic(medicine);
    }

    @Override
    public List<Medicine> getAllMedicine(int index, int limit) {
        int page = (index-1)*limit;
        return medicineDao.getAllMedicine(page,limit);
    }

    @Override
    public Medicine getMedicine(int tableCoding) {

        return medicineDao.getMedicine(tableCoding);
    }

    //多条件查询单轮
    @Override
    public List<Medicine> getMedicineByQuery(String[] query) {
        int i = 0;
        String[] condition = new String[4];
        for (String s:query){
            if (s.equals(" ")){
                condition[i] = "%";
            }else {
                condition[i] = s;
                System.out.println(s);
            }
            i++;
        }
        List<Medicine> medicineByQuery = medicineDao.getMedicineByQuery(condition);
        return medicineDao.getMedicineByQuery(condition);
    }

    //多条件查询（多轮）
    @Override
    public List<Medicine> getMedicineByQuerys(String[] query1, String[] query2, String[] query3, String[] query4) {
        int i = 0;
        List<Medicine> list = new ArrayList<Medicine>();
        while (query1.length>i || query2.length>i || query3.length>i || query4.length>i){
            String[] codition = new String[4];
            if (query1.length>i){
                codition[0] = query1[i];
            }else {
                codition[0] = "%";
            }
            if (query2.length>i){
                codition[1] = query2[i];
            }else {
                codition[1] = "%";
            }
            if (query3.length>i){
                codition[2] = query3[i];
            }else {
                codition[2] = "%";
            }
            if (query4.length>i){
                codition[3] = query4[i];
            }else {
                codition[3] = "%";
            }
            List<Medicine> medicineByQuery = medicineDao.getMedicineByQuery(codition);
            for (Medicine medicine:medicineByQuery){
                list.add(medicine);
            }
            i++;
        }
        return list;
    }

    //可用于价格修改时药品的回显
    @Override
    public List<Medicine> getMedicineByMId(int mId) {
        return medicineDao.getMedicineByMId(mId);
    }

}
