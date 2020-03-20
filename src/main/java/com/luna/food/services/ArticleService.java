package com.luna.food.services;

import com.luna.food.entities.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();
    void addArticle(Article article);
}
