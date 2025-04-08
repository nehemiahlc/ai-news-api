package com.codenemo.ai_news_api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AIScrapper {
        public static List<Article> scrapeArticles(String url, String publication, String selector, String titleSelector){
            try {
                Document doc = Jsoup.connect(url).get();
                Elements articleList = doc.select(selector);
                List<Article> articles = new ArrayList<>();
                for(org.jsoup.nodes.Element article: articleList) {
                    String title = article.select(titleSelector).text();
                    Element link = article.selectFirst("a");
                    String site = link.attr("href");


                    if (title.contains("AI")){
                        Article foundArticles = new Article();
                        foundArticles.title = title;
                        foundArticles.url = site;
                        foundArticles.source = publication;
                        articles.add(foundArticles);
                    }
                }
                return articles;
            } catch (IOException e) {
                System.err.println("Error scraping articles: " + e.getMessage());
                return Collections.emptyList();
            }
        }




        public static List<Article> getTechCrunchArticles() {
            return scrapeArticles("https://techcrunch.com/category/artificial-intelligence/", "techcrunch",
                    ".post", "h3");
        }


        public static List<Article> getVergeArticles() {
            return scrapeArticles("https://www.theverge.com/ai-artificial-intelligence",
                    "theverge", "a[href]", "a" );
        }


        public static List<Article> getVentureArticles() {


            return scrapeArticles("https://venturebeat.com/category/ai/","venturebeat"
                    , ".ArticleListing__title", "h2");
        }




        public static List<Article> getZDNetArticles() {
            return scrapeArticles("https://www.zdnet.com/", "zdnet",
                    ".c-listingLatest_item" ,"div"  );
        }


        public static List<Article> getScienceDailyArticles() {


            return scrapeArticles("https://www.sciencedaily.com/news/computers_math/artificial_intelligence/",
                    "sciencedaily", ".latest-head", "div");


        }


        public static List<Article> getUniteArticles() {
            return scrapeArticles("https://www.unite.ai/", "unite",
                    ".mvp-blog-story-out", "h2");
        }


        public static List<Article> getAllArticles() {
            return Stream.of(
                            getTechCrunchArticles(),
                            getVergeArticles(),
                            getVentureArticles(),
                            getZDNetArticles(),
                            getScienceDailyArticles(),
                            getUniteArticles()
                    ).flatMap(List::stream)
                    .collect(Collectors.toList());
        }

    }
