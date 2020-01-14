package com.example.yazlab2.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsId;

    private String title;

    private String content;

    private Timestamp releaseDate;

    private int likeOfNumber;

    private int dislikeOfNumber;

    private String category;

    private int viewOfNumber;

    private String imagePath;

    public News(String title, String content, Timestamp releaseDate, int likeOfNumber, int dislikeOfNumber, String category, int viewOfNumber, String imagePath) {
        this.title = title;
        this.content = content;
        this.releaseDate = new Timestamp(System.currentTimeMillis());
        this.likeOfNumber = 0;
        this.dislikeOfNumber = 0;
        this.category = category;
        this.viewOfNumber = 0;
        this.imagePath = imagePath;
    }


    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", releaseDate=" + releaseDate +
                ", likeOfNumber=" + likeOfNumber +
                ", dislikeOfNumber=" + dislikeOfNumber +
                ", category='" + category + '\'' +
                ", viewOfNumber=" + viewOfNumber +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public News() {
        this.releaseDate = new Timestamp(System.currentTimeMillis());
        this.dislikeOfNumber = 0;
        this.viewOfNumber = 0;
        this.likeOfNumber =0;


    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
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

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getLikeOfNumber() {
        return likeOfNumber;
    }

    public void setLikeOfNumber(int likeOfNumber) {
        this.likeOfNumber = likeOfNumber;
    }

    public int getDislikeOfNumber() {
        return dislikeOfNumber;
    }

    public void setDislikeOfNumber(int dislikeOfNumber) {
        this.dislikeOfNumber = dislikeOfNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getViewOfNumber() {
        return viewOfNumber;
    }

    public void setViewOfNumber(int viewOfNumber) {
        this.viewOfNumber = viewOfNumber;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
