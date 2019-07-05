package com.yin.springbootbeetlsql.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.Date;

import static com.yin.springbootbeetlsql.config.SqlKit.mapper;


/**
 *
 *  gen by smthit 2018-04-19
 */
@Data
public class UserVO {

	private Long id;

	private Integer status;

	//登录名、默认是注册的手机号
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
	private String nm;

	private  Date createdAt;

	private  Date updatedAt;

}
