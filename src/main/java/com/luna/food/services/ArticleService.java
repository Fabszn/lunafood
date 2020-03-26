package com.luna.food.services;

import com.luna.food.entities.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> getAllArticles();
    Optional<Article> getArticleById(Long id);
    long removeArticleById(Long id);

    void addArticle(Article article);
}
