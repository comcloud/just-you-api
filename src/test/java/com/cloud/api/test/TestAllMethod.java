package com.cloud.api.test;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

public class TestAllMethod {
    @Test
    public void test() throws SQLException {
        List<Entity> test = Db.use().findAll("test");
        for (Entity entity : test) {
            String tid = entity.getStr("tid");
            String username = entity.getStr("username");
            String password = entity.getStr("password");


        }
    }
}
