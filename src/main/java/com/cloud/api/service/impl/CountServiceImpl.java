package com.cloud.api.service.impl;

import com.cloud.api.mapper.countMapper;
import com.cloud.api.service.CountService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/8-20:24
 */
@Service
public class CountServiceImpl implements CountService {
@Autowired
    private countMapper countMapper;
    @Override
    public int SelecttaskCount(int id) {
        return countMapper.SelecttaskCount(id);
    }

    @Override
    public int selectUserCount() {
        return countMapper.selectUserCount();
    }

    @Override
    public int selectDynamiccount() {
        return countMapper.selectDynamiccount();
    }

    @Override
    public int sekectTaskOrder3() {
        return countMapper.sekectTaskOrder3();
    }

    @Override
    public Result<Map<String,Object>> get7CountUser() {
        int[] datecount= new int[7];
        String[] dates = new String[7];
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 多态
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        datecount[6]=countMapper.selectCountUserTime(date);
        dates[6]=df.format(date);
        for (int i=5;i>=0;i--){
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            date =  calendar.getTime();
            int i1 = countMapper.selectCountUserTime(date);
            datecount[i]=i1;

            dates[i]= df.format(date);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("dates",dates);
        map.put("datecount",datecount);

        return  ResultGenerator.genSuccessResult(map);
    }
}