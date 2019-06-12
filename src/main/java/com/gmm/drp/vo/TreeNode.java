package com.gmm.drp.vo;

/**
 *@Author feri
 *@Date Created in 2018/7/14 10:35
 */
public class TreeNode {
    private int id;
    private String url;
    private String name;
    private int parentid;

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
