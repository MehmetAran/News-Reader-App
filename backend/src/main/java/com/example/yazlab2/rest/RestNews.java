package com.example.yazlab2.rest;

import com.example.yazlab2.Entity.News;
import com.example.yazlab2.interfaces.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class RestNews {
    @Autowired
    INewsService newsServiceImp;

    //Yeni haber ekler
    @RequestMapping(value = "/addNews" , method = RequestMethod.POST)
    public ResponseEntity addNews(@RequestBody News news) throws IOException {
        if(!newsServiceImp.addNews(news))
            return new ResponseEntity("not",HttpStatus.CONFLICT);
        news.setImagePath("C:\\Users\\warri\\Desktop\\images\\"+news.getNewsId()+".jpg");
        newsServiceImp.updateNews(news);
        return new ResponseEntity("ok",HttpStatus.CREATED);
    }
    //Bütün haberleri listeler
    @RequestMapping(value = "/news/list" , method = RequestMethod.GET)
    public ResponseEntity<List<News>> allList(){
        List<News> list = newsServiceImp.allList();
        if( list == null)
            return new ResponseEntity("empty",HttpStatus.CONFLICT);
        return new ResponseEntity<List<News>>(list,HttpStatus.OK);
    }
    //id'ye bağlı olarak haberi döndürür her döndürdüğünde de haberin görüntülenme sayısını artırır
    @RequestMapping(value = "/news/list/{id}" , method = RequestMethod.GET)
    public ResponseEntity<News> findNewsById(@PathVariable int id){
        News news = newsServiceImp.findNewsById(id);
        if( news == null)
            return new ResponseEntity("empty",HttpStatus.CONFLICT);
        news.setViewOfNumber(news.getViewOfNumber()+1);
        newsServiceImp.updateNews(news);
        return new ResponseEntity<News>(news,HttpStatus.OK);
    }
    //like sayısını artırır
    @RequestMapping(value = "/increaseLike/{id}" , method = RequestMethod.GET)
    public ResponseEntity<News> increaseLike(@PathVariable int id ) {
        News news = newsServiceImp.findNewsById(id);
        news.setLikeOfNumber(news.getLikeOfNumber()+1);
        newsServiceImp.updateNews(news);
        return new ResponseEntity<News>(news,HttpStatus.OK);
    }
    //like sayısını azaltır
    @RequestMapping(value = "/decreaseLike/{id}" , method = RequestMethod.GET)
    public ResponseEntity<News> decreaseLike(@PathVariable int id  ) {
        News news = newsServiceImp.findNewsById(id);
        news.setLikeOfNumber(news.getLikeOfNumber()-1);
        newsServiceImp.updateNews(news);
        return new ResponseEntity(news,HttpStatus.CREATED);
    }
    //dislike sayısını artırır
    @RequestMapping(value = "/increaseDislike/{id}" , method = RequestMethod.GET)
    public ResponseEntity<News> increaseDislike(@PathVariable int id) {
        News news = newsServiceImp.findNewsById(id);
        news.setDislikeOfNumber(news.getDislikeOfNumber()+1);
        newsServiceImp.updateNews(news);
        return new ResponseEntity(news,HttpStatus.CREATED);
    }
    //dislike sayısını azaltır
    @RequestMapping(value = "/decreaseDislike/{id}" , method = RequestMethod.GET)
    public ResponseEntity<News> decreaseDislike(@PathVariable int id ) {
        News news = newsServiceImp.findNewsById(id);
        news.setDislikeOfNumber(news.getDislikeOfNumber()-1);
        newsServiceImp.updateNews(news);
        return new ResponseEntity(news,HttpStatus.CREATED);
    }


}
