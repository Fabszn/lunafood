package com.luna.food.services;

import com.luna.food.entities.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class ArticleServiceImpl implements ArticleService {


    private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    public List<Article> getAllArticles() {
        return Article.listAll();
    }

    @Transactional
    public void addArticle(Article article){
        Article.persist(article);
    }

    @Override
    public Optional<Article> getArticleById(Long id) {
        return Article.findByIdOptional(id);
    }

    @Transactional
    public long removeArticleById(Long id) {
        return Article.delete("id", id);
    }
}
