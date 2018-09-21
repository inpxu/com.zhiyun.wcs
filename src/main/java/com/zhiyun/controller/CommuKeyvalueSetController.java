package com.zhiyun.controller;

import com.zhiyun.dto.ResultModel;
import com.zhiyun.entity.CommuKeySet;
import com.zhiyun.entity.CommuKeyvalueSet;
import com.zhiyun.service.CommuKeyvalueSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * (CommuKeyvalueSet)表控制层
 *
 * @author makejava
 * @since 2018-09-15 09:03:02
 */
@RestController
@RequestMapping("/commuKeyvalueSet")
public class CommuKeyvalueSetController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommuKeyvalueSetController.class);

    /**
     * 服务对象
     */
    @Resource
    private CommuKeyvalueSetService commuKeyvalueSetService;

    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<CommuKeyvalueSet> addOrUpdate(@Valid @RequestBody CommuKeyvalueSet[] commuKeyvalueSet, BindingResult bindingResult) {
        ResultModel<CommuKeyvalueSet> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            commuKeyvalueSetService.addOrUpdate(commuKeyvalueSet);
            result.setMessage("新增成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<CommuKeySet> delete(Long[] ids) {
        ResultModel<CommuKeySet> result = new ResultModel<>();
        try {
            validateIds(ids);
            //TODO 删除数据
            commuKeyvalueSetService.deleteByIds(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 通过keyid查询所有值
     *
     * @param keyId key的id
     * @return com.zhiyun.dto.ResultModel<com.zhiyun.entity.CommuKeySet>
     * @author 邓艺
     * @date 2018/9/18 14:53
     */
    @RequestMapping(value = "optionValueByKeyId", method = RequestMethod.POST)
    public ResultModel<List<CommuKeyvalueSet>> optionValueByKeyId(String keyType) {
        ResultModel<List<CommuKeyvalueSet>> result = new ResultModel<>();
        try {
            result.setModel(commuKeyvalueSetService.optionValueByKeyId(keyType));
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

}