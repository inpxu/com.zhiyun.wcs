package com.zhiyun.controller;


import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.DeviceSitSetDto;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.dto.SystemTaskDto;
import com.zhiyun.entity.DeviceSitSet;
import com.zhiyun.entity.SystemTask;
import com.zhiyun.entity.SystemTaskSingle;
import com.zhiyun.service.DeviceSitSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 设备节点设置
 * </p>
 *
 * @author 徐飞
 * @since 2018-11-12 14:31:08
 */
@RestController
@RequestMapping("/deviceSit")
public class DeviceSitController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SitSetController.class);

    @Resource
    private DeviceSitSetService deviceSitSetService;
    /**
     * 分页查询
     *
     * @param deviceSitSet 条件封装实体
     * @return java.util.List<com.zhiyun.wcs.entity.deviceSitSet>
     * @author 徐飞
     * @date 2018-11-12 14:41:43
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<DeviceSitSetDto>> page(DeviceSitSet deviceSitSet, Pager pager) {
        ResultModel<DataGrid<DeviceSitSetDto>> result = new ResultModel<>();
        pager.setSort("id");
        pager.setOrder(Page.ORDER_DESC);
        deviceSitSet.setCompanyId(UserHolder.getCompanyId());
        DataGrid<DeviceSitSetDto> entity = deviceSitSetService.customPage(Params.create().add("entity", deviceSitSet), pager);
        result.setMessage("分页查询成功");
        result.setModel(entity);
        return result;

    }

    /**
     * 编辑
     *
     * @param deviceSitSetDto
     * @param bindingResult
     * @return
     * @author xufei
     * @date 2018-11-12 15:58:56
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultModel<DeviceSitSetDto> update(DeviceSitSetDto deviceSitSetDto, BindingResult bindingResult) {
        ResultModel<DeviceSitSetDto> result = new ResultModel<DeviceSitSetDto>();
        try {
            validateParam(bindingResult);
            deviceSitSetDto.setCompanyId(UserHolder.getCompanyId());
            deviceSitSetService.update(deviceSitSetDto);
            result.setMessage("编辑成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 新增
     *
     * @param deviceSitSetDto
     * @param bindingResult
     * @return
     * @author xufei
     * @date 2018-11-12 15:58:56
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultModel<DeviceSitSetDto> add(DeviceSitSetDto deviceSitSetDto, BindingResult bindingResult) {
        ResultModel<DeviceSitSetDto> result = new ResultModel<DeviceSitSetDto>();
        try {
            validateParam(bindingResult);
            deviceSitSetDto.setCompanyId(UserHolder.getCompanyId());
            deviceSitSetService.add(deviceSitSetDto);
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
     * @date 2018-11-12 16:36:39
     */
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public ResultModel<DeviceSitSetDto> del(Long[] ids) {
        ResultModel<DeviceSitSetDto> result = new ResultModel<>();
        try {
            validateIds(ids);
            deviceSitSetService.del(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }
}