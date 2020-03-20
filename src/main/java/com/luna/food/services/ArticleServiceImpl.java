package com.luna.food.services;

import com.luna.food.entities.Article;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ArticleServiceImpl implements ArticleService {


    public List<Article> getAllArticles() {
        return Article.listAll();
    }

    @Transactional
    public void addArticle(Article article){
        Article.persist(article);
    }



}
