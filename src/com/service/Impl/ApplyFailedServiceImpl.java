package com.service.Impl;

import com.dao.ApplyFailedDao;
import com.dao.Impl.ApplyFaileDaoImpl;
import com.pojo.ApplyFailed;
import com.pojo.Medicine;
import com.service.ApplyFaileService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.util.Vessel.medicineDao;

public class ApplyFailedServiceImpl implements ApplyFaileService {

    ApplyFailedDao applyFailedDao = new ApplyFaileDaoImpl();
    @Override
    public int addFailed(int tableCoding,String cause,String name) {
        ApplyFailed apply = new ApplyFailed();
        Medicine medicine = medicineDao.getMedicine(tableCoding);
        apply.setTableCoding(medicine.getTableCoding());
        apply.setmId(medicine.getmId());
        apply.setmName(medicine.getmName());
        apply.setSpecification(medicine.getSpecification());
        apply.setManufactor(medicine.getManufactor());
        apply.setNumber(medicine.getNumber());
        apply.setPurchasePrice(medicine.getPurchasePrice());
        apply.setCode(medicine.getCode());
        apply.setmType(medicine.getmType());
        apply.setSupplier(medicine.getSupplier());
        apply.setApprovalNumber(medicine.getApprovalNumber());
        apply.setPlaceOrigin(medicine.getPlaceOrigin());
        apply.setCause(cause);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        apply.setApplyTime(format);
        apply.setApplyUser(name);
        applyFailedDao.addCause(apply.getApplyId(),apply.getApplyTime(),apply.getCause());
        return applyFailedDao.addFailed(apply);
    }

    @Override
    public int getAll() {
        return applyFailedDao.getAll();
    }

    @Override
    public List<ApplyFailed> getAll(int page, int limit) {
        page = (page-1)*limit;
        return applyFailedDao.getAll(page,limit);
    }

    public List<ApplyFailed> getAllCase(int applyId) {
        return applyFailedDao.getCause(applyId);
    }

    @Override
    public List<ApplyFailed> getAll(int page, int limit, String title, String sort) {
        page = (page-1)*limit;
        return applyFailedDao.getAll(page,limit,title,sort);
    }

    @Override
    public ApplyFailed getApplyFailedByAId(int applyId) {
        return applyFailedDao.getApplyFailedByAId(applyId);
    }

    @Override
    public List<ApplyFailed> getApplyFailedByMName(String name) {
        return applyFailedDao.getApplyFailedByMName(name);
    }

    @Override
    public List<String> getMType() {
        return applyFailedDao.getMType();
    }

    @Override
    public List<ApplyFailed> getApplyFailedByMType(String mType) {
        return applyFailedDao.getApplyFailedByMType(mType);
    }

    @Override
    public List<String> getAllManufactor() {
        return applyFailedDao.getAllManufactor();
    }

    @Override
    public List<ApplyFailed> getApplyFailedByManufactor(String manufactor) {
        return applyFailedDao.getApplyFailedByManufactor(manufactor);
    }

    @Override
    public int delApplyFailed(int applyId) {
        applyFailedDao.delCause(applyId);
        return applyFailedDao.delApplyFailed(applyId);
    }

    @Override
    public int updateAppFailed(int applyId,String name) {
        ApplyFailed applyFailed = applyFailedDao.getApplyFailedByAId(applyId);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        applyFailed.setPharmacistTime(format);
        applyFailed.setPharmacist(name);
        applyFailedDao.addCause(applyId,format,"审阅完成！");
        return applyFailedDao.updateAppFailed(applyFailed);
    }

    @Override
    public int updateCause(String cause, int applyId) {
        ApplyFailed applyFailed = applyFailedDao.getApplyFailedByAId(applyId);
        applyFailed.setCause(cause);
        return applyFailedDao.updateCause(cause,applyId);
    }
}
