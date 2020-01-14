package com.example.appyazlab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {



    @SerializedName("newsId")
    @Expose
    public Integer newsId;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;
    @SerializedName("likeOfNumber")
    @Expose
    public Integer likeOfNumber;
    @SerializedName("dislikeOfNumber")
    @Expose
    public Integer dislikeOfNumber;
    @SerializedName("category")
    @Expose
    public String category;
    @SerializedName("viewOfNumber")
    @Expose
    public Integer viewOfNumber;
    @SerializedName("imagePath")
    @Expose
    public String imagePath;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getLikeOfNumber() {
        return likeOfNumber;
    }

    public void setLikeOfNumber(Integer likeOfNumber) {
        this.likeOfNumber = likeOfNumber;
    }

    public Integer getDislikeOfNumber() {
        return dislikeOfNumber;
    }

    public void setDislikeOfNumber(Integer dislikeOfNumber) {
        this.dislikeOfNumber = dislikeOfNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getViewOfNumber() {
        return viewOfNumber;
    }

    public void setViewOfNumber(Integer viewOfNumber) {
        this.viewOfNumber = viewOfNumber;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", likeOfNumber=" + likeOfNumber +
                ", dislikeOfNumber=" + dislikeOfNumber +
                ", category='" + category + '\'' +
                ", viewOfNumber=" + viewOfNumber +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
