package com.cloud.api.bean.vo;
import	java.util.ArrayList;
import com.cloud.api.bean.entity.Tag;
import com.cloud.api.bean.entity.TaskClassification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

/**
 * @author 云顶犀
 * <p>项目名称: 任务大厅查询显示实体类
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/17-16:04
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class taskHallVo {
    public Long id;
    //任务分类 一对一
    public TaskClassificationVo taskClassification;
    //标题
    //招募人数
    public Long recruiting_number;

    private String task_description;

    public String task_title ;
    //发布日期
    public Date release_time;
    //浏览量
    public Integer traffic;
    //用户
    public userVo user;

    private List<Tag> tags=new ArrayList<> ();
}
