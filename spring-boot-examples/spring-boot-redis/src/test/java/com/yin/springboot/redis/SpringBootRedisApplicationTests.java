package com.yin.springboot.redis;

import com.yin.springbootbeetlsql.entity.UserPO;
import com.yin.springbootbeetlsql.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {
    @Test
    public void contextLoads() {

        UserPO po=new UserPO();

        po.setId(999107769460064256L);
        List<UserPO> template = UserPO.Dao.$.template(po);
        System.out.println(template.get(0).getName());

    }

}
