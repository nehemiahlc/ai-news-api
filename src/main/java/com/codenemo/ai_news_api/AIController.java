package com.codenemo.ai_news_api;

import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AIController {

    @GetMapping("/news")
    public ResponseEntity<?> getNews() {

        try {
            List<Article> articles = AIScrapper.getAllArticles();
            if (articles.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No articles available at this time. Please try again later.");
            }
            return ResponseEntity.ok(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching news articles. Please try again later.");
        }
    }


        @GetMapping("/news/{newspaperId}")
        public ResponseEntity<?> getSpecificNewsByPublication (@PathVariable String newspaperId){
            try {
                List<Article> articles = AIScrapper.getAllArticles();
                List<Article> filteredArticles = articles.stream()
                        .filter(article -> {
                            return article.getSource().equalsIgnoreCase(newspaperId);
                        })
                        .toList();
                if (filteredArticles.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("No articles found for the specified newspaperId: " + newspaperId +
                                    ". Please check the ID and try again.");
                }

                return ResponseEntity.ok(filteredArticles);
            } catch (Exception e) {
                // Log the exception for debugging
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An error occurred while fetching news for the specified source. Please try again later.");
            }
        }
    }

