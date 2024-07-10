package com.pojo;

public class Price {
    private int id;
    private int tableCoding;
    private int mId;
    private Double historyPrice;
    private String time;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getHistoryPrice() {
        return historyPrice;
    }

    public void setHistoryPrice(Double historyPrice) {
        this.historyPrice = historyPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
