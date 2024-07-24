package com.pojo;

public class NormalStockOut {
    private int pid;//患者id
    private String name;//患者姓名
    private String mName;//药品名称
    private String defined;//药品类型
    private int number;//出库数量
    private String status;//取药/出库状态
    private String getmTime;//出库时间

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDefined() {
        return defined;
    }

    public void setDefined(String defined) {
        this.defined = defined;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGetmTime() {
        return getmTime;
    }

    public void setGetmTime(String getmTime) {
        this.getmTime = getmTime;
    }
}
