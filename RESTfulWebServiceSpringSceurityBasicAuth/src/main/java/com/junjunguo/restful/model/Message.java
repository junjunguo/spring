package com.junjunguo.restful.model;

/**
 * This file is part of RESTfulWebService.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 30/10/2016.
 */
public class Message {
    private String type;
    private String description;

    public Message() {
    }

    public Message(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
