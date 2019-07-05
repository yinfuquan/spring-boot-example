package com.yin.springbootelasticsearch.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/4
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
@Document(indexName = "users", type = "test")
@Data
@ToString
public class User {

    @Id
    private Long id;

    @Field(type = FieldType.Integer, store = true)
    private Integer status;

    //登录名、默认是注册的手机号
    @Field(type = FieldType.Text, store = true, analyzer = "ik_smart")
    private String loginName;

    //账号人、机构名
    private String name;

    //昵称
    private String nickname;

    private Date lastLoginTime;

    private String password;

    private String salt;

    private Long orgId;
    private String orgName;
}
