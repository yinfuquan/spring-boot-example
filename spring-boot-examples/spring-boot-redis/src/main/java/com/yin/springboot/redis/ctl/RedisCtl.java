package com.yin.springboot.redis.ctl;

import com.yin.springboot.redis.service.RedisService;
import com.yin.springbootbeetlsql.entity.UserPO;
import com.yin.springbootbeetlsql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/3
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class RedisCtl {

    @Autowired
    RedisService redisService;

    @RequestMapping("/")
    public String test() {

        return redisService.get(999107769460064256L);
    }

}
