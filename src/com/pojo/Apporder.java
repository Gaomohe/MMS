package com.pojo;

public class Apporder {
    private int oId;
    private int aId;//applyMedicineId,申请购买的药品id

    private int applyBuyNumber;//申请购买的药品数量

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getApplyBuyNumber() {
        return applyBuyNumber;
    }

    public void setApplyBuyNumber(int applyBuyNumber) {
        this.applyBuyNumber = applyBuyNumber;
    }
}
