package com.zhiyun.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-20 14:35
 */
@Data
public class WaittingTaskDto {
    private JSONObject waittingTask;
    private List<JSONObject> jobInfo;
    private List<JSONObject> singlePathInfo;
    private List<JSONObject> historyList;

}
