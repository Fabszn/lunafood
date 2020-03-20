package com.luna.food;

import com.luna.food.entities.Article;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ArticleServiceTest {


    @Test
    public void newArticleTest(){
        Article art = new Article("pepito","Biscuit");
        assertThat(art,hasProperty("name"));
        assertThat(art,hasProperty("type"));

        assertThat("Article name",art.getName(), Matchers.equalTo("pepito"));
        assertThat("Article type",art.getType(), Matchers.equalTo("Biscuit"));
    }


}
