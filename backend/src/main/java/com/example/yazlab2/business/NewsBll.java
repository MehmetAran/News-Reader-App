package com.example.yazlab2.business;


import com.example.yazlab2.Entity.News;
import com.example.yazlab2.interfaces.INewsService;
import com.example.yazlab2.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NewsBll implements INewsService {

    @Autowired
    NewsRepository newsRepository;

    public boolean addNews(News news){
        if(news.getCategory().equals("") || news.getCategory() == null)
            return false;
        if(news.getContent().equals("") || news.getContent() == null)
            return false;
        if(news.getTitle().equals("") || news.getTitle() == null )
           return false;
        newsRepository.save(news);
            return true;
    }


    @Override
    public void updateNews(News news) {
        newsRepository.save(news);
    }

    @Override
    public List<News> allList() {
        return (List<News>)newsRepository.findAll();
    }
    public News findNewsById(int id ){
        Optional<News> news = newsRepository.findById(id);
        News newss = new News();
        newss.setViewOfNumber(news.get().getViewOfNumber());
        newss.setDislikeOfNumber(news.get().getDislikeOfNumber());
        newss.setLikeOfNumber(news.get().getLikeOfNumber());
        newss.setImagePath(news.get().getImagePath());
        newss.setCategory(news.get().getCategory());
        newss.setContent(news.get().getContent());
        newss.setNewsId(news.get().getNewsId());
        newss.setTitle(news.get().getTitle());
        newss.setReleaseDate(news.get().getReleaseDate());
        if(news != null)
            return newss;
        return null;
    }

}
