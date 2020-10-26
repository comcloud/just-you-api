package com.cloud.api.bean.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
/**
 * @author hds
 * <p>项目名称:
 * <p>文件名称:
 * <p>描述:
 * @date 2020/10/26-12:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskSearchVo {
    private Long searchId;
    private String searchName;
    private Date searchTime;
}
