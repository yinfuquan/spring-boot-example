package com.yin.springbootelasticsearch.repository;

import com.yin.springbootelasticsearch.entity.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.awt.print.Book;

public interface UserRepository  extends ElasticsearchRepository<User,Long> {

    User  findByName(String name);

/*    @Query("{"bool" : {"must" : {"field" : {"name" : "?0"}}}}")
    Page<User> findByName(String name, SpringDataWebProperties.Pageable pageable);*/

}
