package com.luna.food.resources;

import com.luna.food.entities.Article;
import com.luna.food.services.ArticleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/articles")
public class ArticleResource {


    @Inject
    ArticleService articleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> allArticles() {
        return articleService.getAllArticles();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createArticles(Article article) {

        articleService.addArticle(article);
        return "Created";
    }

}