package com.example.yazlab2.interfaces;


import com.example.yazlab2.Entity.News;

import java.util.List;

public interface INewsService {

    public boolean addNews(News news);
    public List<News> allList();
    public News findNewsById(int id );
    public void updateNews(News news);


}

