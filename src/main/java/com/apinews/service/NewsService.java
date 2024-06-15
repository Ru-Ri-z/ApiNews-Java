package com.apinews.service;

import com.apinews.model.NewsArticle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class NewsService {

    @Value("${newsapi.url}")
    private String url;

    @Value("${newsapi.key}")
    private String apiKey;

    public List<NewsArticle> getTechNews(String country) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("country", country)
                .queryParam("category", "technology")
                .queryParam("apiKey", apiKey);

        RestTemplate restTemplate = new RestTemplate();
        NewsApiResponse response = restTemplate.getForObject(uriBuilder.toUriString(), NewsApiResponse.class);

        return response != null ? Arrays.asList(response.getArticles()) : null;
    }
}

class NewsApiResponse {
    private NewsArticle[] articles;

    public NewsArticle[] getArticles() {
        return articles;
    }

    public void setArticles(NewsArticle[] articles) {
        this.articles = articles;
    }
}
