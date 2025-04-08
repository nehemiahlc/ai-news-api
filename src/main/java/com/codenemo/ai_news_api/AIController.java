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
    @GetMapping("/")
    public String home() {
        return "<html>" +
                "<head>" +
                "<title>AI News API</title>" +
                "<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css' rel='stylesheet'>" +
                "<style>" +
                "body {" +
                "font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;" +
                "margin: 0;" +
                "padding: 0;" +
                "box-sizing: border-box;" +
                "background: linear-gradient(135deg, #00bcd4, #2196F3);" +
                "color: #fff;" +
                "}" +
                "header {" +
                "text-align: center;" +
                "padding: 100px 20px;" +
                "background: #444;" +
                "border-bottom: 5px solid #2196F3;" +
                "}" +
                "h1 {" +
                "font-size: 4em;" +
                "font-weight: 700;" +
                "color: #fff;" +
                "text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.3);" +
                "}" +
                "nav {" +
                "position: sticky;" +
                "top: 0;" +
                "background-color: #333;" +
                "padding: 10px;" +
                "z-index: 100;" +
                "}" +
                "nav a {" +
                "color: white;" +
                "padding: 14px 20px;" +
                "text-decoration: none;" +
                "font-size: 1.2em;" +
                "transition: background-color 0.3s;" +
                "}" +
                "nav a:hover {" +
                "background-color: #ffeb3b;" +
                "color: #2196F3;" +
                "}" +
                ".content {" +
                "max-width: 1000px;" +
                "margin: 50px auto;" +
                "padding: 20px;" +
                "text-align: center;" +
                "}" +
                ".cards {" +
                "display: flex;" +
                "justify-content: space-around;" +
                "flex-wrap: wrap;" +
                "gap: 30px;" +
                "}" +
                ".card {" +
                "background: rgba(255, 255, 255, 0.1);" +
                "border-radius: 10px;" +
                "padding: 30px;" +
                "width: 300px;" +
                "box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);" +
                "transition: transform 0.3s;" +
                "}" +
                ".card:hover {" +
                "transform: translateY(-10px);" +
                "}" +
                ".card a {" +
                "font-size: 1.2em;" +
                "color: #ffeb3b;" +
                "text-decoration: none;" +
                "border: 2px solid #ffeb3b;" +
                "padding: 10px 20px;" +
                "border-radius: 30px;" +
                "transition: background-color 0.3s, color 0.3s;" +
                "}" +
                ".card a:hover {" +
                "background-color: #ffeb3b;" +
                "color: #2196F3;" +
                "}" +
                "footer {" +
                "background: #333;" +
                "padding: 20px 0;" +
                "text-align: center;" +
                "color: white;" +
                "font-size: 1.1em;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<header>" +
                "<h1>Welcome to AI Brief <br> The AI News API</h1>" +
                "</header>" +
                "<div class='content'>" +
                "<h2>Stay Updated with the Latest AI News</h2>" +
                "<p>Access curated AI articles from trusted sources via our API.</p>" +
                "<div class='cards'>" +
                "<div class='card'>" +
                "<h3>API Documentation</h3>" +
                "<p>Get detailed information on how to use the API.</p>" +
                "<a href='https://rapidapi.com/nehemiahlchandler/api/aibrief' target='_blank'>View Docs <i class='fas fa-arrow-right'></i></a>" +
                "</div>" +
                "<div class='card'>" +
                "<h3>Get All AI News</h3>" +
                "<p>Fetch the latest AI news from multiple sources.</p>" +
                "<a href='/news'>Get News <i class='fas fa-arrow-right'></i></a>" +
                "</div>" +
                "</div>" +
                "</div>" +
                "<footer>" +
                "<p>&copy; 2025 AI Brief. All Rights Reserved.</p>" +
                "</footer>" +
                "</body>" +
                "</html>";
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
