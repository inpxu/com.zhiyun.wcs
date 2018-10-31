package com.zhiyun.controller;

import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.dto.SystemTaskSingleDto;
import com.zhiyun.entity.SystemTaskSingle;
import com.zhiyun.service.SystemTaskSingleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 任务节点拆分
 *
 * @author XUFEI
 * @date: 2018-10-30 16:00:00
 */
@RestController
@RequestMapping("/taskSingle")
public class SystemTaskSingleController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemTaskSingleController.class);

    @Resource
    private SystemTaskSingleService systemTaskSingleService;

    /**
     * 上下料拆分查询
     * @param systemTaskSingle
     * @param bindingResult
     * @return
     * @author xufei
     * @date 2018-10-30 16:16:13
     */
    @RequestMapping(value = "upDown", method = RequestMethod.POST)
    public ResultModel<List<SystemTaskSingleDto>> upDown(@Valid SystemTaskSingle systemTaskSingle, BindingResult bindingResult) {
        ResultModel<List<SystemTaskSingleDto>> result = new ResultModel<List<SystemTaskSingleDto>>();
        try {
            validateParam(bindingResult);
            systemTaskSingle.setCompanyId(UserHolder.getCompanyId());
            systemTaskSingle.setSingleType(0);
            result.setModel(systemTaskSingleService.upDown(systemTaskSingle));
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 移箱拆分查询
     * @param systemTaskSingle
     * @param bindingResult
     * @return
     * @author xufei
     * @date 2018-10-30 16:39:00
     */
    @RequestMapping(value = "moveBox", method = RequestMethod.POST)
    public ResultModel<List<SystemTaskSingleDto>> moveBox(@Valid SystemTaskSingle systemTaskSingle, BindingResult bindingResult) {
        ResultModel<List<SystemTaskSingleDto>> result = new ResultModel<List<SystemTaskSingleDto>>();
        try {
            validateParam(bindingResult);
            systemTaskSingle.setCompanyId(UserHolder.getCompanyId());
            systemTaskSingle.setSingleType(1);
            result.setModel(systemTaskSingleService.upDown(systemTaskSingle));
            result.setMessage("查询成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 上下料新增
     * @param systemTaskSingle
     * @param bindingResult
     * @return
     * @author xufei
     * @date 2018-10-30 16:40:47
     */
    @RequestMapping(value = "upDownAdd", method = RequestMethod.POST)
    public ResultModel<SystemTaskSingle> upDownAdd(SystemTaskSingle systemTaskSingle, BindingResult bindingResult) {
        ResultModel<SystemTaskSingle> result = new ResultModel<SystemTaskSingle>();
        try {
            validateParam(bindingResult);
            systemTaskSingle.setCompanyId(UserHolder.getCompanyId());
            systemTaskSingle.setSingleType(0);
            systemTaskSingle.setJobStatus("未完成");
            systemTaskSingleService.insert(systemTaskSingle);
            result.setMessage("新增成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 移箱新增
     * @param systemTaskSingle
     * @param bindingResult
     * @return
     * @author xufei
     * @date 2018-10-30 16:42:44
     */
    @RequestMapping(value = "moveBoxAdd", method = RequestMethod.POST)
    public ResultModel<SystemTaskSingle> moveBoxAdd(SystemTaskSingle systemTaskSingle, BindingResult bindingResult) {
        ResultModel<SystemTaskSingle> result = new ResultModel<SystemTaskSingle>();
        try {
            validateParam(bindingResult);
            systemTaskSingle.setCompanyId(UserHolder.getCompanyId());
            systemTaskSingle.setSingleType(1);
            systemTaskSingle.setJobStatus("未完成");
            systemTaskSingleService.insert(systemTaskSingle);
            result.setMessage("新增成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }


    /**
     * 编辑
     * @param systemTaskSingle
     * @param bindingResult
     * @return
     * @author xufei
     * @date 2018-10-30 16:40:47
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultModel<SystemTaskSingle> update(SystemTaskSingle systemTaskSingle, BindingResult bindingResult) {
        ResultModel<SystemTaskSingle> result = new ResultModel<SystemTaskSingle>();
        try {
            validateParam(bindingResult);
            systemTaskSingle.setCompanyId(UserHolder.getCompanyId());
            systemTaskSingleService.update(systemTaskSingle);
            result.setMessage("新增成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     * @author xufei
     * @date 2018-10-30 16:59:41
     */
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public ResultModel<SystemTaskSingle> del(Long[] ids) {
        ResultModel<SystemTaskSingle> result = new ResultModel<>();
        try {
            validateIds(ids);
            systemTaskSingleService.del(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

}