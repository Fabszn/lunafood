package com.luna.food.streams;

import com.luna.food.entities.Article;
import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PublishArticle  {


    @Incoming("article-stream") //from In memory channel
    @Outgoing("articleTopic") // to Kafka
    public Flowable<Article> consumeArticle(Article article){
            return Flowable.just(article);
    }



}
