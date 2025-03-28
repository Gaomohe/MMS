package com.pojo;

import lombok.Data;

@Data
public class Apporder {
    private int oId;
    private int aId;//applyMedicineId,申请购买的药品id
    private int applyId;
    private int applyBuyNumber;//申请购买的药品数量
}
