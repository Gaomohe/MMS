package com.pojo;

public class StockOutForm {
    private int outId;//出库单号
    private String outStatus ;//出库单状态
    private String oDate;//出库日期
    private String oManufactor;//往来单位
    private String oType;//出库类型
    private String oNum;//出库明细数
    private int oSalePrice;//销售金额
    private int oAmount;//出库总金额
    private int oCost;//成本金额
    private String operator;//操作员
    private String auditor;//审核人
    private String auditTime;//审核时间
    private String department;//部门

    public int getOutId() {
        return outId;
    }

    public void setOutId(int outId) {
        this.outId = outId;
    }

    public String getOutStatus() {
        return outStatus;
    }

    public void setOutStatus(String outStatus) {
        this.outStatus = outStatus;
    }

    public String getoDate() {
        return oDate;
    }

    public void setoDate(String oDate) {
        this.oDate = oDate;
    }

    public String getoManufactor() {
        return oManufactor;
    }

    public void setoManufactor(String oManufactor) {
        this.oManufactor = oManufactor;
    }

    public String getoType() {
        return oType;
    }

    public void setoType(String oType) {
        this.oType = oType;
    }

    public String getoNum() {
        return oNum;
    }

    public void setoNum(String oNum) {
        this.oNum = oNum;
    }

    public int getoSalePrice() {
        return oSalePrice;
    }

    public void setoSalePrice(int oSalePrice) {
        this.oSalePrice = oSalePrice;
    }

    public int getoAmount() {
        return oAmount;
    }

    public void setoAmount(int oAmount) {
        this.oAmount = oAmount;
    }

    public int getoCost() {
        return oCost;
    }

    public void setoCost(int oCost) {
        this.oCost = oCost;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
