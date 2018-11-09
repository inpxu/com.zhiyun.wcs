package com.zhiyun.controller;

import com.alibaba.fastjson.JSON;
import com.zhiyun.base.dto.BaseResult;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.service.DispatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务调度控制器
 *
 * @author 邓艺
 * @version v1.0
 * @date 2018-09-07 15:13
 */
@RestController
@RequestMapping("/dispatcher")
public class DispatcherController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherController.class);
    @Autowired
    private DispatcherService dispatcherService;

    /**
     * 任务顺序调整controller
     *
     * @return com.zhiyun.dto.ResultModel<java.lang.String>
     * @author Bruce
     * @date 2018/9/8 22:57
     */
    public ResultModel<String> changeOrder() {
        ResultModel<String> resultModel = new ResultModel<>();
        //TODO 业务调整逻辑
        Boolean b = dispatcherService.changeOrder();
        if (!b) {
            resultModel.setResult(false);
            resultModel.setMessage("调整任务已经在执行或系统错误");
            LOGGER.error("改变任务顺序错误");
        }
        return resultModel;

    }

    public ResultModel<String> systemCtl() {
        ResultModel<String> resultModel = new ResultModel<>();
        return resultModel;
    }

    @ResponseBody
    @RequestMapping(value = "/startMission", method = RequestMethod.POST)
    public String startMission(SystemTask systemTask) {
        BaseResult<String> baseResult = new BaseResult<>();
        try {
            baseResult.setResult(true);
            baseResult.setMessage("任务开始执行");
            dispatcherService.startMission(systemTask);
        } catch (Exception e) {
            baseResult.setResult(false);
            baseResult.setMessage("任务执行失败");
            e.printStackTrace();
        }
        /**
         * 出发任务执行
         */
        return JSON.toJSONString(baseResult);
    }

}
