package com.example.myapplication;

public class Manga {
    private String _id;
    private String name;
    private String url;
    private String description;
    private String chapter;
    private String status;
    private String createdAt;
    private Integer __v;

    public Manga() {

    }

    public Manga(String _id, String name, String url, String description, String chapter, String status, String createdAt, Integer __v) {
        this._id = _id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.chapter = chapter;
        this.status = status;
        this.createdAt = createdAt;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }
}
