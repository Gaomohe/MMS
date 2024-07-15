package com.pojo;

public class StockInForm {
    private int rId;
    private String stockInNum;
    private int tableCoding;

    public int getTableCoding() {
        return tableCoding;
    }

    public void setTableCoding(int tableCoding) {
        this.tableCoding = tableCoding;
    }

    private String rName;
    private String standard;
    private String manufactor;
    private String unit;
    private int rNum;
    private int cost;
    private int salePrice;
    private String batchNumber;
    private String productDate;
    private String expiration;

    private String stockInTime;
    private String department;
    private String notes;

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getStockInNum() {
        return stockInNum;
    }

    public void setStockInNum(String stockInNum) {
        this.stockInNum = stockInNum;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getrNum() {
        return rNum;
    }

    public void setrNum(int rNum) {
        this.rNum = rNum;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStockInTime() {
        return stockInTime;
    }

    public void setStockInTime(String stockInTime) {
        this.stockInTime = stockInTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
