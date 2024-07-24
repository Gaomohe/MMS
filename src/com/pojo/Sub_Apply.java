package com.pojo;


public class Sub_Apply {
    private int applyid; //申请唯一编号
    private int mid;        //药品编号
    private int applynum;   //药品名称
    private String applytime;  //申请时间
    private int applyuserid;  //申请人id
    private int approve;
    private long batch_num;  //唯一批次编号

    public long getBatch_num() {
        return batch_num;
    }

    public void setBatch_num(long batch_num) {
        this.batch_num = batch_num;
    }

    public int getApprove() {
        return approve;
    }

    public void setApprove(int approve) {
        this.approve = approve;
    }

    public int getApplyid() {
        return applyid;
    }

    public void setApplyid(int applyid) {
        this.applyid = applyid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getApplynum() {
        return applynum;
    }

    public void setApplynum(int applynum) {
        this.applynum = applynum;
    }

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public int getApplyuserid() {
        return applyuserid;
    }

    public void setApplyuserid(int applyuserid) {
        this.applyuserid = applyuserid;
    }
}
