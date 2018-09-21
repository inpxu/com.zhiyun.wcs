package com.zhiyun.controller;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.dto.SinglePathSetDto;
import com.zhiyun.entity.SinglePathSet;
import com.zhiyun.service.SinglePathSetService;
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
 * 设备单路径设置 前端控制器
 * </p>
 *
 * @author 邓艺
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/singlePathSet")
public class SinglePathSetController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SinglePathSetController.class);

    @Autowired
    private SinglePathSetService singlePathSetService;

    /**
     * @param singlePathSet
     * @param pager
     * @return java.util.List<com.zhiyun.wcs.entity.SinglePathSet>
     * @author 邓艺
     * @date 2018/9/6 10:36
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<SinglePathSetDto>> page(SinglePathSet singlePathSet, Pager pager) {
        ResultModel<DataGrid<SinglePathSetDto>> result = new ResultModel<>();
        singlePathSet.setCompanyId(UserHolder.getCompanyId());
        pager.setSort("id");
        pager.setOrder(Page.ORDER_DESC);
        DataGrid<SinglePathSetDto> entity = singlePathSetService.customPage(Params.create().add("entity", singlePathSet), pager);
        result.setModel(entity);
        result.setMessage("分页查询成功");
        return result;

    }

    /**
     * 但路径的新增或更新
     *
     * @param singlePathSet
     * @param bindingResult
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 11:17
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<SinglePathSet> addOrUpdate(@Valid SinglePathSet singlePathSet, BindingResult bindingResult) {
        ResultModel<SinglePathSet> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            singlePathSet.setCompanyId(UserHolder.getCompanyId());
            singlePathSetService.addOrUpdate(singlePathSet);
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
     * 设备节点删除
     *
     * @param ids
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:26
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<SinglePathSet> delete(Long[] ids) {
        ResultModel<SinglePathSet> result = new ResultModel<>();
        try {
            validateIds(ids);
            //TODO 删除数据
            singlePathSetService.deleteByIds(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

}

