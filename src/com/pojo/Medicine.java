package com.pojo;

import lombok.Data;

@Data
public class Medicine {
    private int mId;
    private String mName;
    private String specification;
    private String manufactor;
    private String unit;
    private String department;
    private String position;
    private int number;
    private String batchNumber;
    private String usefulLife;
    private double purchasePrice;
    private double salePrice;
    private String productDate;
    private String profits;
    private String code;
    private String goodsType;
    private String mType;
    private String defined;
    private String supplier;
    private String warehousingDate;
    private String locationDescription;
    private String sign;
    private String warehousingRemarks;
    private String drugFrom;
    private String handlingInformation;
    private String approvalNumber;
    private String lastCuringDate;//上次养护日期
    private int timesStorage;
    private String documentNumber;
    private String placeOrigin;
    private String batchsNumber;
    private int recordNumber;
    private int tableCoding;
    private int state;//养护状态
}
