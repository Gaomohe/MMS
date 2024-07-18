package com.dao;

import com.pojo.*;

import java.util.List;

public interface ApplyFailedDao {
    //添加不合格品审核订单
    public int addFailed(ApplyFailed applyFailed);
    //获取所有不合格品订单信息
    public int getAll();
    public List<ApplyFailed> getAll(int page,int limit);
    public List<ApplyFailed> getAll(int page,int limit,String title,String sort);
    //根据applyId获取不合格订单信息
    public ApplyFailed getApplyFailedByAId(int applyId);
    //根据药品名称获取不合格订单信息
    public List<ApplyFailed> getApplyFailedByMName(String name);
    //获取订单中所有mType
    public List<String> getMType();
    //根据吗mType获取不合格订单信息
    public List<ApplyFailed> getApplyFailedByMType(String mType);
    //获取订单中所有公司名称
    public List<String> getAllManufactor();
    //根据公司获取不合格订单信息
    public List<ApplyFailed> getApplyFailedByManufactor(String manufactor);
    //删除不合格品数据
    public int delApplyFailed(int applyId);
    //修改不合格数据药师审批状态，时间（自动），名称（userName）
    public int updateAppFailed(ApplyFailed applyFailed);
    //修改药品不合格原因
    public int updateCause(String cause,int applyId);
}
