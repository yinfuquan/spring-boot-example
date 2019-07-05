package com.yin.springboot.redis.service;

import com.yin.springbootbeetlsql.entity.UserPO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/3
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RedisService {
    @Cacheable(key = "#id", value = "po",unless="#result == null")
    public String get(Long id) {

        UserPO po = new UserPO();

        po.setId(id);
        return "ok::" + UserPO.Dao.$.template(po).size();

    }
}
