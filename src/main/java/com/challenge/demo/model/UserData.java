package com.challenge.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

import java.util.Date;

public class UserData {
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
}
