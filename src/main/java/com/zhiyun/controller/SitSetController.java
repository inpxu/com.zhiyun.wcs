package com.zhiyun.controller;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.dto.SitSetDto;
import com.zhiyun.entity.DeviceDefine;
import com.zhiyun.entity.SitSet;
import com.zhiyun.service.SitSetService;
import com.zhiyun.vo.ProductionDeviceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 设备节点设置 前端控制器
 * </p>
 *
 * @author 邓艺
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/sitSet")
public class SitSetController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SitSetController.class);
    @Autowired
    private SitSetService sitSetService;

    /**
     * 设备节点设置分页查询
     *
     * @param sitSet 条件封装实体
     * @return java.util.List<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:00
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<SitSetDto>> page(SitSet sitSet, Pager pager) {
        ResultModel<DataGrid<SitSetDto>> result = new ResultModel<>();
        pager.setSort("id");
        pager.setOrder(Page.ORDER_DESC);
        sitSet.setCompanyId(UserHolder.getCompanyId());
        DataGrid<SitSetDto> entity = sitSetService.customPage(Params.create().add("entity", sitSet), pager);
        //TODO 分页查询
        result.setModel(entity);
        result.setMessage("分页查询成功");
        return result;
    }

    /**
     * 新增或者更新设备节点
     *
     * @param
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:21
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<SitSet> addOrUpdate(@Valid SitSet sitSet, BindingResult bindingResult) {
        ResultModel<SitSet> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            sitSet.setCompanyId(UserHolder.getCompanyId());
            sitSetService.insertOrUpdate(sitSet);
            result.setMessage("新增或修改成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            //写入日志
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 设备节点删除
     *
     * @param ids
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:26
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<SitSet> delete(Long[] ids) {
        ResultModel<SitSet> result = new ResultModel<>();
        try {
            validateIds(ids);
            List<Long> longs = Arrays.asList(ids);
            sitSetService.deleteBatchIds(longs);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.error(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 下拉查询设备编码
     *
     * @param
     * @return com.zhiyun.dto.ResultModel<java.util.Listom.zhiyun.entity.DeviceDefine>>
     * @author 邓艺
     * @date 2018/9/7 14:01
     */
    @RequestMapping(value = "optionDeviceNo", method = RequestMethod.GET)
    public ResultModel<List<DeviceDefine>> optionDeviceNo() {
        ResultModel<List<DeviceDefine>> result = new ResultModel<>();
        result.setMessage("查询成功");
        result.setModel(sitSetService.optionDeviceNo());
        return result;
    }

    /**
     * 生产设备下拉查询
     *
     * @param
     * @return com.zhiyun.dto.ResultModel<java.util.List                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               com.zhiyun.entity.DeviceDefine>>
     * @author 邓艺
     * @date 2018/10/31 9:55
     */
    @RequestMapping(value = "optionProductionDeviceNo", method = RequestMethod.GET)
    public ResultModel<List<ProductionDeviceVo>> optionProductionDeviceNo() {
        ResultModel<List<ProductionDeviceVo>> result = new ResultModel<>();
        result.setMessage("查询成功");
        result.setModel(sitSetService.optionProductionDeviceNo());
        return result;
    }

    /**
     * 下拉节点
     *
     * @param
     * @author 邓艺
     * @date 2018/9/10 18:44
     */
    @RequestMapping(value = "optionSite", method = RequestMethod.GET)
    public ResultModel<List<SitSet>> optionSite() {
        ResultModel<List<SitSet>> result = new ResultModel<>();
        result.setMessage("查询成功");
        List<SitSet> list = sitSetService.optionSite();
        result.setModel(list);
        return result;
    }

}

