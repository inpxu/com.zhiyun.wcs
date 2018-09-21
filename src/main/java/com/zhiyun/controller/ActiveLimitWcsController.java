package com.zhiyun.controller;

import com.zhiyun.dto.ActiveLimitWcsDto;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.entity.ActiveLimitWcs;
import com.zhiyun.service.ActiveLimitWcsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 动作条件限制 前端控制器
 * </p>
 *
 * @author 邓艺
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/activeLimitWcs")
public class ActiveLimitWcsController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActiveLimitWcsController.class);
    @Autowired
    private ActiveLimitWcsService activeLimitWcsService;

    /**
     * 新增或修改设备前置条件
     *
     * @param activeLimitWcsDtos
     * @param bindingResult
     * @return com.zhiyun.dto.ResultModel<com.zhiyun.entity.ActiveLimitWcs>
     * @author 邓艺
     * @date 2018/9/7 13:53
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<ActiveLimitWcs> addOrUpdate(@Valid @RequestBody ActiveLimitWcsDto[] activeLimitWcsDtos, BindingResult bindingResult) {
        ResultModel<ActiveLimitWcs> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            activeLimitWcsService.addOrUpdate(activeLimitWcsDtos);
            result.setMessage("新增成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 删除
     *
     * @param ids
     * @return com.zhiyun.dto.ResultModel<com.zhiyun.entity.ActiveLimitWcs>
     * @author 邓艺
     * @date 2018/9/7 13:55
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<ActiveLimitWcs> delete(Long[] ids) {
        ResultModel<ActiveLimitWcs> result = new ResultModel<>();
        try {
            validateIds(ids);
            activeLimitWcsService.deleteByids(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

}

