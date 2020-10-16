package com.cloud.api.test;
import com.cloud.api.bean.entity.User;
import com.cloud.api.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;


/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/7-13:05
 */
@SpringBootTest
public class UserText {
    @Autowired
    UserMapper userMapper;
    @Test
    public void test() throws ParseException {
        List<User> users = userMapper.searchUserByTimeQuantum("2000-11-07", "2020--11-02");
        System.out.println(users);

    }
}
