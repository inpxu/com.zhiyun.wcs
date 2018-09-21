package com.zhiyun.controller;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.MotionDetailDto;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.entity.MotionSet;
import com.zhiyun.service.MotionSetService;
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
 * 设备动作设置 前端控制器
 * </p>
 *
 * @author 邓艺
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/motionSet")
public class MotionSetController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MotionSetController.class);
    @Autowired
    private MotionSetService motionSetService;

    /**
     * @param motionSet
     * @param pager
     * @return java.util.List<com.zhiyun.wcs.entity.SinglePathSet>
     * @author 邓艺
     * @date 2018/9/6 10:36
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<MotionSet>> page(MotionSet motionSet, Pager pager) {
        ResultModel<DataGrid<MotionSet>> result = new ResultModel<>();
        pager.setSort("id");
        pager.setOrder(Page.ORDER_DESC);
        DataGrid<MotionSet> entity = motionSetService.page(Params.create().add("entity", motionSet), pager);
        result.setModel(entity);
        result.setMessage("分页查询成功");
        return result;

    }

    /**
     * 动作的新增或修改
     *
     * @param motionSet
     * @param bindingResult
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SinglePathSet>
     * @author 邓艺
     * @date 2018/9/6 10:36
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<MotionSet> addOrUpdate(@Valid MotionSet motionSet, BindingResult bindingResult) {
        ResultModel<MotionSet> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            motionSet.setCompanyId(UserHolder.getCompanyId());
            motionSetService.addOrUpdate(motionSet);
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
     * 动作删除
     *
     * @param ids
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:26
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<MotionSet> delete(Long[] ids) {
        ResultModel<MotionSet> result = new ResultModel<>();
        try {
            validateIds(ids);
            motionSetService.deleteByids(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 显示详情,返回值通过dto进行封装，将返回值进行封装,只查询设备动作限制即可
     *
     * @param id
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.MotionSet>
     * @author 邓艺
     * @date 2018/9/6 14:12
     */
    @RequestMapping(value = "findDetail", method = RequestMethod.POST)
    public ResultModel<MotionDetailDto> findDetail(Long id) {
        ResultModel<MotionDetailDto> result = new ResultModel<>();
        try {
            result.setMessage("查询成功");
            MotionDetailDto returns = new MotionDetailDto();
            returns.setList(motionSetService.findDetail(id));
            result.setModel(returns);
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

}

