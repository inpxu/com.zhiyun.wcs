package com.zhiyun.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-20 14:34
 */
@Data
public class RunningTaskDto {
    private JSONObject runningTask;
    private List<JSONObject> jobInfo;
    private List<JSONObject> singlePathInfo;
    private List<JSONObject> historyList;

}
