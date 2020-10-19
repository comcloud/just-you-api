package com.cloud.api.mapper;

import com.cloud.api.bean.dto.OrderSearchObject;
import com.cloud.api.bean.entity.Task;
import com.cloud.api.bean.entity.TaskOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/14 21:13
 */
@Mapper
public interface OrderMapper {

    List<Task> selectTaskData();

    List<TaskOrder> selectOrderData();

    Integer selectNumberFromTaskId(Long id);

    String selectOpenIdFromUserId(@Param("orderUserId") Long orderUserId);

    Long selectTaskIdFromOpenId(@Param("openId") String openId);

    Task selectTaskIdFromId(Long taskId);

    boolean deleteTaskOrderById(Integer id);

    List<TaskOrder> selectOrderDataBySearch(OrderSearchObject orderSearchObject);
}
