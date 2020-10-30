package com.cloud.api;

import com.cloud.api.bean.entity.Photoalbum;
import com.cloud.api.bean.entity.Tag;
import com.cloud.api.bean.vo.DynamicCommentsVo;
import com.cloud.api.bean.vo.TaskSearchVo;
import com.cloud.api.mapper.BlogThehall.BlogThehallMapper;
import com.cloud.api.mapper.BlogThehall.DynamicCommMapper;
import com.cloud.api.mapper.TaskHall.TaskSearchMapper;
import com.cloud.api.mapper.TaskHall.TaskHallMapper;
import com.cloud.api.mapper.VXUser.VXUserMapper;
import com.cloud.api.service.BlogThehall.DynamicCommentsService;
import com.cloud.api.service.TaskHall.impl.TaskSearchServiceImpl;
import com.cloud.api.service.VXUser.photoAlbumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiApplicationTests {
@Autowired
    DynamicCommMapper dynamicCom;
@Autowired
        DynamicCommMapper a;
@Autowired
DynamicCommentsService taskCommentsService;
@Autowired
    BlogThehallMapper aa;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    TaskHallMapper tm;

    @Autowired
    TaskSearchMapper dynamicSearchMapper;

    @Autowired
    TaskSearchMapper taskSearchServiceImpl;
    @Autowired
    DynamicCommMapper dynamicCommMapper;
    @Autowired
    VXUserMapper VXUser;
@Autowired
    photoAlbumService protoAlbumService;
    @Test
    void contextLoads() {
        System.out.println(protoAlbumService.deletePhoto(1L, "restore"));
    }


}
