package com.pojo;

public class StockOutForm {
    private int outId;//出库单id
    private String outNum ;//出库单号
    private int tableCoding ;//出库单id
    private String oName ;//药品名称
    private String standard ;//规格
    private String manufactor ;//供货商
    private String unit ;//单位
    private int oNum ;//出库数量
    private int cost ;//成本
    private int salePrice ;//销售价
    private String batchNumber ;//批号
    private String productDate ;//生产日期
    private String expiration ;//有效期
    private String stockOutTime ;//出库时间
    private String department ;//部门
    private String notes ;//出库状态

    public int getOutId() {
        return outId;
    }

    public void setOutId(int outId) {
        this.outId = outId;
    }

    public String getOutNum() {
        return outNum;
    }

    public void setOutNum(String outNum) {
        this.outNum = outNum;
    }

    public int getTableCoding() {
        return tableCoding;
    }

    public void setTableCoding(int tableCoding) {
        this.tableCoding = tableCoding;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
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

    public int getoNum() {
        return oNum;
    }

    public void setoNum(int oNum) {
        this.oNum = oNum;
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

    public String getStockOutTime() {
        return stockOutTime;
    }

    public void setStockOutTime(String stockOutTime) {
        this.stockOutTime = stockOutTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
