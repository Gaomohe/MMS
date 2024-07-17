package com.pojo;

public class Orders {
    private int oId; // 采购单号
    private String oName; // 药品名
    private String specification; // 规格
    private String manufactor; // 生产企业
    private String unit; // 单位
    private int oNum; // 订单数量
    private int salePrice; // 采购单价
    private String shippingAddress; // 发货地址
    private String deliveryAddress; // 收货地址
    private String shippingTime; // 发货时间
    private String shippingWay; // 发货方式
    private String tempControlWay; // 温控方式
    private String deliveryTime; // 到货时间
    private String deliveryTemp; // 到货温度
    private String attachment; // 关联附件
    private String salesman; // 供货单位业务员
    private String buyer; // 采购人
    private String recipient; // 收货人
    private String orderCondition; // 收货状态
    private String statement; // 收货说明
    private double allPrice;
    private double advance;
    private String advanceStatus;
    private double finals;
    private String finalsStatus;

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
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

    public int getoNum() {
        return oNum;
    }

    public void setoNum(int oNum) {
        this.oNum = oNum;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(String shippingTime) {
        this.shippingTime = shippingTime;
    }

    public String getShippingWay() {
        return shippingWay;
    }

    public void setShippingWay(String shippingWay) {
        this.shippingWay = shippingWay;
    }

    public String getTempControlWay() {
        return tempControlWay;
    }

    public void setTempControlWay(String tempControlWay) {
        this.tempControlWay = tempControlWay;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryTemp() {
        return deliveryTemp;
    }

    public void setDeliveryTemp(String deliveryTemp) {
        this.deliveryTemp = deliveryTemp;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public double getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(double allPrice) {
        this.allPrice = allPrice;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public String getAdvanceStatus() {
        return advanceStatus;
    }

    public void setAdvanceStatus(String advanceStatus) {
        this.advanceStatus = advanceStatus;
    }

    public double getFinals() {
        return finals;
    }

    public void setFinals(double finals) {
        this.finals = finals;
    }

    public String getFinalsStatus() {
        return finalsStatus;
    }

    public void setFinalsStatus(String finalsStatus) {
        this.finalsStatus = finalsStatus;
    }
}
