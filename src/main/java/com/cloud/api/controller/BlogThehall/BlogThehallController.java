package com.cloud.api.controller.BlogThehall;
import com.cloud.api.service.BlogThehall.BlogThehallService;
import com.cloud.api.util.Result;
import com.cloud.api.util.ResultGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author hds
 * <p>项目名称: 动态大厅
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/23-9:20
 */
@Controller
public class BlogThehallController {
    @Autowired
    private BlogThehallService blogThehallService;

    /**
     * 动态页面
     * @param pageNum 页码
     * @return https://s1.ax1x.com/2020/10/23/BA4qCF.png
     */
    @ResponseBody
    @GetMapping("/gotoHomePage")
    public Result gotoHomePage(@RequestParam(defaultValue="1" ,value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        return ResultGenerator.genSuccessResult(new PageInfo<>(blogThehallService.getPushAllBlog()));
    }



}
