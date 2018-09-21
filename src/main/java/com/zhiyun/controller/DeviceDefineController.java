package com.zhiyun.controller;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.entity.DeviceDefine;
import com.zhiyun.service.DeviceDefineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 物流设备定义 前端控制器
 * </p>
 *
 * @author 邓艺
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/deviceDefine")
public class DeviceDefineController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceDefineController.class);
    @Autowired
    private DeviceDefineService deviceDefineService;

    /**
     * @param deviceDefine
     * @param pager
     * @return java.util.List<com.zhiyun.wcs.entity.SinglePathSet>
     * @author 邓艺
     * @date 2018/9/6 10:36
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<DeviceDefine>> page(DeviceDefine deviceDefine, Pager pager) {
        ResultModel<DataGrid<DeviceDefine>> result = new ResultModel<>();
        //TODO 分页查询
        deviceDefine.setCompanyId(UserHolder.getCompanyId());
        DataGrid<DeviceDefine> entity = deviceDefineService.page(Params.create().add("entity", deviceDefine), pager);
        result.setMessage("分页查询成功");
        result.setModel(entity);
        return result;

    }

    /**
     * 新增或修改设备定义
     *
     * @param deviceDefine
     * @param bindingResult
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SinglePathSet>
     * @author 邓艺
     * @date 2018/9/6 10:36
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<DeviceDefine> addOrUpdate(@Valid DeviceDefine deviceDefine, BindingResult bindingResult) {
        ResultModel<DeviceDefine> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            deviceDefine.setCompanyId(UserHolder.getCompanyId());
            deviceDefineService.addOrUpdate(deviceDefine);
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
     * 删除设备
     *
     * @param ids
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:26
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<DeviceDefine> delete(Long[] ids) {
        ResultModel<DeviceDefine> result = new ResultModel<>();
        try {
            validateIds(ids);
            //TODO 删除数据
            deviceDefineService.deleteByIds(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 查看详情
     *
     * @param id
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.DeviceDefine>
     * @author 邓艺
     * @date 2018/9/6 13:18
     */
    @RequestMapping(value = "findDetail", method = RequestMethod.POST)
    public ResultModel<DeviceDefine> findDetail(Long id) {
        ResultModel<DeviceDefine> result = new ResultModel<>();
        try {
            DeviceDefine deviceDefine = deviceDefineService.get(id);
            result.setMessage("删除成功");
            result.setModel(deviceDefine);
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

}

