package com.pojo;

public class Quality {
    private int id;
    private int statue;
    private int tableCoding;
    private int mId;
    private String mName;
    private int totlNumber;
    private int surveyNumber;
    private String goodsType;
    private String mType;
    private String defind;
    private String drugFrom;
    private String warehousingRemarks;
    private String storageStatus;
    private String time;
    private String supplier;
    private int orderId;
    private String usefulLife;

    public Quality(int tableCoding, int totlNumber, int surveyNumber) {
        this.tableCoding = tableCoding;
        this.totlNumber = totlNumber;
        this.surveyNumber = surveyNumber;
    }

    public Quality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public int getTableCoding() {
        return tableCoding;
    }

    public void setTableCoding(int tableCoding) {
        this.tableCoding = tableCoding;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getTotlNumber() {
        return totlNumber;
    }

    public void setTotlNumber(int totlNumber) {
        this.totlNumber = totlNumber;
    }

    public int getSurveyNumber() {
        return surveyNumber;
    }

    public void setSurveyNumber(int surveyNumber) {
        this.surveyNumber = surveyNumber;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getDefind() {
        return defind;
    }

    public void setDefind(String defind) {
        this.defind = defind;
    }

    public String getDrugFrom() {
        return drugFrom;
    }

    public void setDrugFrom(String drugFrom) {
        this.drugFrom = drugFrom;
    }

    public String getWarehousingRemarks() {
        return warehousingRemarks;
    }

    public void setWarehousingRemarks(String warehousingRemarks) {
        this.warehousingRemarks = warehousingRemarks;
    }

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSupplier() {

        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUsefulLife() {
        return usefulLife;
    }

    public void setUsefulLife(String usefulLife) {
        this.usefulLife = usefulLife;
    }
}
