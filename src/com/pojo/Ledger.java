package com.pojo;

public class Ledger {
    //总账类---------总账数据

    private int ledgerId;
    private int mId;
    private String mName;
    private String specification;
    private String manufactor;
    private String unit;
    private String department;
    private int number;
    private int applyNumber;
    private double purchasePrice;
    private String code;
    private String mType;
    private String supplier;
    private String approvalNumber;
    private String placeOrigin;
    private String applyUser;
    private String applyTime;
    private String pharmacist;
    private String pharmacistApprove;
    private String pharmacistTime;
    private String finance;
    private String financeApprove;
    private String financeTime;
    private int tableCoding;
    private String invoices;
    private String billState;
    private double billAmount;
    private String billAccount;

    @Override
    public String toString() {
        return "Ledger{" +
                "ledgerId=" + ledgerId +
                ", mId=" + mId +
                ", mName='" + mName + '\'' +
                ", specification='" + specification + '\'' +
                ", manufactor='" + manufactor + '\'' +
                ", unit='" + unit + '\'' +
                ", department='" + department + '\'' +
                ", number=" + number +
                ", applyNumber=" + applyNumber +
                ", purchasePrice=" + purchasePrice +
                ", code='" + code + '\'' +
                ", mType='" + mType + '\'' +
                ", supplier='" + supplier + '\'' +
                ", approvalNumber='" + approvalNumber + '\'' +
                ", placeOrigin='" + placeOrigin + '\'' +
                ", applyUser='" + applyUser + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", pharmacist='" + pharmacist + '\'' +
                ", pharmacistApprove='" + pharmacistApprove + '\'' +
                ", pharmacistTime='" + pharmacistTime + '\'' +
                ", finance='" + finance + '\'' +
                ", financeApprove='" + financeApprove + '\'' +
                ", financeTime='" + financeTime + '\'' +
                ", tableCoding=" + tableCoding +
                ", invoices='" + invoices + '\'' +
                ", billState='" + billState + '\'' +
                ", billAmount=" + billAmount +
                ", billAccount='" + billAccount + '\'' +
                '}';
    }

    public int getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(int ledgerId) {
        this.ledgerId = ledgerId;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(int applyNumber) {
        this.applyNumber = applyNumber;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
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

    public String getFinance() {
        return finance;
    }

    public void setFinance(String finance) {
        this.finance = finance;
    }

    public String getFinanceApprove() {
        return financeApprove;
    }

    public void setFinanceApprove(String financeApprove) {
        this.financeApprove = financeApprove;
    }

    public String getFinanceTime() {
        return financeTime;
    }

    public void setFinanceTime(String financeTime) {
        this.financeTime = financeTime;
    }

    public int getTableCoding() {
        return tableCoding;
    }

    public void setTableCoding(int tableCoding) {
        this.tableCoding = tableCoding;
    }

    public String getInvoices() {
        return invoices;
    }

    public void setInvoices(String invoices) {
        this.invoices = invoices;
    }

    public String getBillState() {
        return billState;
    }

    public void setBillState(String billState) {
        this.billState = billState;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillAccount() {
        return billAccount;
    }

    public void setBillAccount(String billAccount) {
        this.billAccount = billAccount;
    }
}
