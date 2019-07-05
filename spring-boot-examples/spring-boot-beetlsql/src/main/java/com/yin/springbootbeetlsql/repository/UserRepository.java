package com.yin.springbootbeetlsql.repository;

import com.yin.springbootbeetlsql.entity.UserPO;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @Author: Gabriel
 * @Date: 2018-10-14
 * @Description:
 */
@SqlResource("user")
@Component
public interface UserRepository extends BaseMapper<UserPO>{
	List<UserPO> selectByTest();

}