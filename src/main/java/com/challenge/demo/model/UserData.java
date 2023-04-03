package com.challenge.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class UserData {

    public UserData() {}

    public UserData(String user_name, String display_name, String avatar, String geo_location, String email, String url, Date created_at) {
        this.user_name = user_name;
        this.display_name = display_name;
        this.avatar = avatar;
        this.geo_location = geo_location;
        this.email = email;
        this.url = url;
        this.created_at = created_at;
    }

    @JsonProperty("login")
    private String user_name;
    @JsonProperty("name")
    private String display_name;
    @JsonProperty("avatar_url")
    private String avatar;
    @JsonProperty("location")
    private String geo_location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("html_url")
    private String url;
    @JsonProperty("created_at")
    private Date created_at;

    public String getUser_name() {
        return user_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getGeo_location() {
        return geo_location;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
