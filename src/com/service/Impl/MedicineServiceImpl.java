package com.service.Impl;

import com.dao.Impl.MedicineDaoImpl;
import com.dao.MedicineDao;
import com.pojo.Medicine;
import com.service.MedicineService;

import java.text.SimpleDateFormat;
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

    //可用于价格修改时药品的回显
    @Override
    public List<Medicine> getMedicineByMId(int mId) {
        return medicineDao.getMedicineByMId(mId);
    }

}
