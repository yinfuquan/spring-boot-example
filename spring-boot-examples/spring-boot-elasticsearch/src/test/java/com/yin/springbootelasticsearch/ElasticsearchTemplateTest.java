package com.yin.springbootelasticsearch;

import com.yin.springbootelasticsearch.entity.User;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/4
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTemplateTest {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test() {

//        创建索引
//        elasticsearchTemplate.createIndex(User.class);

        //  QueryBuilder queryBuilder = matchQuery("name", "yin");
        SearchQuery searchQuery = new NativeSearchQueryBuilder()

//               匹配
                .withQuery(matchQuery("name", "yin"))

//               过滤
                .withFilter(boolQuery().must(matchQuery("name", "yin")).filter(rangeQuery("id").gt(1L)))

//                分页
                .withPageable(PageRequest.of(0, 10))

//                排序
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
                .build();

        Page<User> users =
                elasticsearchTemplate.queryForPage(searchQuery, User.class);

        users.get().forEach(a -> System.out.println(a.getName() + a.getId()));

    }

    @Test
    public void creat() {
        //        创建索引
        elasticsearchTemplate.createIndex(User.class);

    }

}
