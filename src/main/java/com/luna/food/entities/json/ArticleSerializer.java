package com.luna.food.entities.json;

import com.luna.food.entities.Article;

import javax.inject.Singleton;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

@Singleton
public class ArticleSerializer implements JsonbSerializer<Article> {

    @Override
    public void serialize(Article article, JsonGenerator jsonGenerator, SerializationContext serializationContext) {
        jsonGenerator.writeStartObject();
        jsonGenerator.write("name", article.getName());
        jsonGenerator.write("type", article.getType());
        jsonGenerator.writeEnd();

    }
}
