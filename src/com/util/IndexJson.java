package com.util;

import java.util.List;

public class IndexJson {
    private String title;
    private String icon;
    private String image;
    private String href;
    private String target;
    private List<IndexJson> child;

    public IndexJson() {
    }

    public IndexJson(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public IndexJson(String title, String href, String image) {
        this.title = title;
        this.href = href;
        this.image = image;
    }

    public IndexJson(String title, String icon, String image, String href, String target, List<IndexJson> child) {
        this.title = title;
        this.icon = icon;
        this.image = image;
        this.href = href;
        this.target = target;
        this.child = child;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<IndexJson> getChild() {
        return child;
    }

    public void setChild(List<IndexJson> child) {
        this.child = child;
    }
}
