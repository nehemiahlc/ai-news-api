package com.codenemo.ai_news_api;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Article {
    String title;
    String url;
    String source;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
