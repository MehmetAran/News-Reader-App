package com.example.appyazlab;

public class NewsDemo {

    private String category;
    private String title;
    private int image;
    private int id;

    public NewsDemo(String category, String title, int image, int id) {
        this.category = category;
        this.title = title;
        this.image = image;
        this.id = id;
    }

    public void changeText1(String text){
        category = text;
    }

    public NewsDemo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
