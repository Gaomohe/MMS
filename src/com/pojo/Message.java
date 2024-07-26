package com.pojo;

public class Message {
    private int id;
    private int uId;
    private String uName;
    private int wId;
    private String message;
    private int fId;

    public Message() {
    }

    public Message(int uId, String uName, int wId, String message) {
        this.uId = uId;
        this.uName = uName;
        this.wId = wId;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }
}
