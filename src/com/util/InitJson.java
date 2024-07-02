package com.util;


import java.util.List;

public class InitJson {
    private IndexJson logoInfo;
    private IndexJson homeInfo;
    private List<IndexJson> menuInfo;

    public IndexJson getLogoInfo() {
        return logoInfo;
    }

    public void setLogoInfo(IndexJson logoInfo) {
        this.logoInfo = logoInfo;
    }

    public IndexJson getHomeInfo() {
        return homeInfo;
    }

    public void setHomeInfo(IndexJson homeInfo) {
        this.homeInfo = homeInfo;
    }

    public List<IndexJson> getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(List<IndexJson> menuInfo) {
        this.menuInfo = menuInfo;
    }
}
