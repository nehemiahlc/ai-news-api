package com.codenemo.ai_news_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AIController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to my AI News API";
    }


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
