package com.example.yazlab2.services;

import com.example.yazlab2.Entity.News;
import com.example.yazlab2.business.NewsBll;
import com.example.yazlab2.interfaces.INewsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsServiceImp implements INewsService {

    @Autowired
    NewsBll newsBll;

    @Override
    public boolean addNews(News news) {
        return newsBll.addNews(news);
    }

    @Override
    public List<News> allList() {
        return newsBll.allList();

    }

    @Override
    public News findNewsById(int id) {
        return newsBll.findNewsById(id);
    }

    @Override
    public void updateNews(News news) {
        newsBll.updateNews(news);
    }

}
