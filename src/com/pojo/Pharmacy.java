package com.pojo;

public class Pharmacy {
    private int phId;//处方id对应morderId
    private int pId;//病人id
    private String pName;
    private String doctor;
    private String isPharmacy;
    private String time;
    private String pharmacist;
    private String pharmacistApprove;
    private String pharmacistTime;

    public int getPhId() {
        return phId;
    }

    public void setPhId(int phId) {
        this.phId = phId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getIsPharmacy() {
        return isPharmacy;
    }

    public void setIsPharmacy(String isPharmacy) {
        this.isPharmacy = isPharmacy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(String pharmacist) {
        this.pharmacist = pharmacist;
    }

    public String getPharmacistApprove() {
        return pharmacistApprove;
    }

    public void setPharmacistApprove(String pharmacistApprove) {
        this.pharmacistApprove = pharmacistApprove;
    }

    public String getPharmacistTime() {
        return pharmacistTime;
    }

    public void setPharmacistTime(String pharmacistTime) {
        this.pharmacistTime = pharmacistTime;
    }
}
