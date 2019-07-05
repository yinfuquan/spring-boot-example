package com.yin.springbootelasticsearch;

import com.yin.springbootelasticsearch.entity.User;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/4
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JestTest {

    @Autowired
    JestClient jestClient;
    @Test
    public void contextLoads() throws IOException {

        User user = new User();
        user.setId(123L);
        user.setName("yin");
        user.setLoginName("fu");


        Index index = new Index.Builder(user).index("user").type("u").build();
        jestClient.execute(index);

    }

    @Test
    public  void get() throws IOException {
        String json="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"name\" : \"yin\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        Search search = new Search.Builder(json).addIndex("article").addType("news").build();
        SearchResult result = jestClient.execute(search);

        System.out.println(result.getJsonString());


    }

}
