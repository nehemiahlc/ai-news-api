package com.codenemo.ai_news_api;

import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AIController {

    @GetMapping("/news")
    public List<Article> getNews() {
        return AIScrapper.getAllArticles();
    }


    @GetMapping("/news/{newspaperId}")
    public List<Article> getSpecificNewsByPublication(@PathVariable String newspaperId) {
        List<Article> articles = AIScrapper.getAllArticles();
        return articles.stream()
                .filter(article -> {
                    return article.getSource().equalsIgnoreCase(newspaperId);
                })
                .collect(Collectors.toList());
    }

}
