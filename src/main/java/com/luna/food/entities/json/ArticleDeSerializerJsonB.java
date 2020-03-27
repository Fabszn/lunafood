package com.luna.food.entities.json;

import com.luna.food.entities.Article;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class ArticleDeSerializerJsonB extends JsonbDeserializer<Article> {
    public ArticleDeSerializerJsonB() {
        super(Article.class);
    }
}
