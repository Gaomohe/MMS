package com.pojo;


//收入类
public class Income {
    private int orderId;  //批次编号
    private String mname; //商品名称
    private String kind;  //类型
    private String specification;//规格
    private String drugFrom;  //种类
    private String supplier;//公司
    private String unit;  //商品类型
    private String productDate;  //生产日期
    private double salePrice; //售卖价格
    private int number;   //数量
    private String opera; //操作人员
    private String finence;//财务人员
    private String state;   //单据状态
    private String times;   //单据时间
    private String account; //账户

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDrugFrom() {
        return drugFrom;
    }

    public void setDrugFrom(String drugFrom) {
        this.drugFrom = drugFrom;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOpera() {
        return opera;
    }

    public void setOpera(String opera) {
        this.opera = opera;
    }

    public String getFinence() {
        return finence;
    }

    public void setFinence(String finence) {
        this.finence = finence;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
