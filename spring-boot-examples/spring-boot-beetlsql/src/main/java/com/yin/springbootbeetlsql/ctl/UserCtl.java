package com.yin.springbootbeetlsql.ctl;

import com.yin.springbootbeetlsql.entity.UserPO;
import com.yin.springbootbeetlsql.entity.UserVO;
import com.yin.springbootbeetlsql.page.PageParam;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date:2019/7/4
 * Time: 23:20
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class UserCtl {

    /**
     * 自定义sql查询
     * @return
     */
    @RequestMapping("/")
    public String test() {

        UserPO user = UserPO.Dao.$.getUserById(999107769460064256L);
        System.out.println(user);

        return "ok";

    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("page")
    public String page() {

        Map<String, Object> params = new HashMap<>();
        params.put("state", 1);


        PageQuery<UserPO> query = new PageQuery<UserPO>();
        query.setPageNumber(2);
        query.setPageSize(5);
        query.setParas(params);


       // PageQuery<UserPO> dataPOs = UserPO.Dao.$.selectPage(query);
        PageQuery<UserVO> dataPOs = UserPO.Dao.$.selectPage(query);
        return String.valueOf(dataPOs.getPageSize());
    }

}
