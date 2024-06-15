package com.apinews.controller;

import com.apinews.model.NewsArticle;
import com.apinews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/api/news")
    public List<NewsArticle> getNews(@RequestParam String country) {
        return newsService.getTechNews(country);
    }
}
