package com.yin.springbootelasticsearch;

import com.yin.springbootelasticsearch.entity.User;
import com.yin.springbootelasticsearch.repository.UserRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticsearchApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void save() {


        User user = new User();
        user.setId(123L);
        user.setName("yin");
        user.setLoginName("fu");

        User save = userRepository.save(user);
        System.out.println(save.toString());


    }


    @Test
    public void testSeach() {

        User yin = userRepository.findByName("yin");

        System.out.println(yin.toString());


    }

}
