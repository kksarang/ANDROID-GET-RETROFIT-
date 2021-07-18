package com.zoople.retrofit;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("userId")
    private Integer userid ;
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;

    public Model(Integer userid, String id, String title) {
        this.userid = userid;
        this.id = id;
        this.title = title;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
