package com.yin.springbootbeetlsql.entity;

import com.yin.springbootbeetlsql.page.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.beetl.sql.core.TailBean;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.annotatoin.Table;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.yin.springbootbeetlsql.config.SqlKit.mapper;


/**
 * gen by smthit 2018-04-19
 */
@Data
//@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@lombok.experimental.Accessors(chain = true)
@Table(name = "uc_users")
@ToString
public class UserPO extends TailBean {

    private static final long serialVersionUID = -7881210592511232526L;

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

    @SqlResource("/user")
    public interface Dao extends BaseMapper<UserPO> {
        Dao $ = mapper(Dao.class);


        //可以直接用 来接受VO
        UserPO getUserById(Long userId);

        //可以直接用 来接受VO
        PageQuery<UserVO> selectPage(PageQuery<UserPO> query);

    }

}
