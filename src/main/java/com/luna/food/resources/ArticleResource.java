package com.luna.food.resources;

import com.luna.food.entities.Article;
import com.luna.food.services.ArticleService;
import com.luna.food.services.ArticleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/articles")
public class ArticleResource {


    @Inject
    ArticleService articleService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> allArticles() {
        return articleService.getAllArticles();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Optional<Article> getArticleById(@PathParam("id") long id) {
        System.out.println("ressources");
        return articleService.getArticleById(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public long deleteArticleById(@PathParam("id") long id) {
        return articleService.removeArticleById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createArticles(Article article) {

        articleService.addArticle(article);
        return "Created";
    }

}