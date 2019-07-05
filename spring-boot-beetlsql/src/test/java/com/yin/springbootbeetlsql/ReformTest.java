package com.yin.springbootbeetlsql;

import com.yin.springbootbeetlsql.Service.UserService;
import com.yin.springbootbeetlsql.entity.UserPO;
import com.yin.springbootbeetlsql.entity.UserVO;
import com.yin.springbootbeetlsql.repository.ReflectRepository;
import org.beetl.sql.core.engine.PageQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/4
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReformTest {


    @Test
    public  void  test() throws InstantiationException, IllegalAccessException {

        UserPO po=new UserPO();

        po.setId(999107769460064256L);
        UserPO template = UserPO.Dao.$.templateOne(po);

        UserVO reform = (UserVO) new UserService().toVO(UserVO.class, template);
        System.out.println(reform);
    }

    @Test
    public  void test2() throws InstantiationException, IllegalAccessException {
        UserPO user = UserPO.Dao.$.getUserById(999107769460064256L);
        System.out.println(user);

        UserVO reform = (UserVO) new UserService().toVO(UserVO.class, user);
        System.out.println(reform);

    }

    /**
     * list转换测试
     */
    @Test
    public  void test3() throws InstantiationException, IllegalAccessException {

        UserPO po=new UserPO();
        po.setId(999107769460064256L);
        UserPO template = UserPO.Dao.$.templateOne(po);

        List<UserPO>  pos=new ArrayList<>();
        pos.add(template);

        List<UserVO> list = new UserService().toVOs(UserVO.class,pos);

        System.out.println("aaaa");

    }

    /**
     * 在PO里可以直接用 VO来接受
     */
    @Test
    public  void test4(){

        Map<String, Object> params = new HashMap<>();
        params.put("state", 1);


        PageQuery<UserPO> query = new PageQuery<UserPO>();
        query.setPageNumber(2);
        query.setPageSize(5);
        query.setParas(params);


        // PageQuery<UserPO> dataPOs = UserPO.Dao.$.selectPage(query);
        PageQuery<UserVO> dataPOs = UserPO.Dao.$.selectPage(query);
    }
}
