package com.zhiyun.controller;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.dto.SystemTaskDto;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.service.SystemTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * <p>
 * 系统任务表 前端控制器
 * </p>
 *
 * @author 邓艺
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/systemTask")
public class SystemTaskController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemTaskController.class);
    @Autowired
    private SystemTaskService systemTaskService;

    /**
     * 手动添加任务分页查询
     *
     * @param systemTask 条件封装实体
     * @return java.util.List<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:00
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<SystemTaskDto>> page(SystemTask systemTask, Pager pager) {
        ResultModel<DataGrid<SystemTaskDto>> result = new ResultModel<>();
        pager.setSort("id");
        pager.setOrder(Page.ORDER_DESC);
        systemTask.setCompanyId(UserHolder.getCompanyId());
        DataGrid<SystemTaskDto> entity = systemTaskService.customPage(Params.create().add("entity", systemTask), pager);
        result.setMessage("分页查询成功");
        result.setModel(entity);
        return result;

    }

    /**
     * 手动添加任务或更新
     *
     * @param systemTask
     * @param bindingResult
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SystemTask>
     * @author 邓艺
     * @date 2018/9/6 14:04
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<SystemTask> addOrUpdate(@Valid SystemTask systemTask, BindingResult bindingResult) {
        ResultModel<SystemTask> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            systemTask.setCompanyId(UserHolder.getCompanyId());
            systemTask.setRequestTime(new Date());
            systemTaskService.addOrUpdate(systemTask);
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
     * 手动添加任务删除
     *
     * @param ids
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:26
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<SystemTask> delete(Long[] ids) {
        ResultModel<SystemTask> result = new ResultModel<>();
        try {
            validateIds(ids);
            systemTaskService.deleteByIds(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }
}

