package com.zhiyun.controller;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.CommuKeySetDto;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.entity.CommuKeySet;
import com.zhiyun.service.CommuKeySetService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * (CommuKeySet)表控制层
 *
 * @author makejava
 * @since 2018-09-15 09:03:01
 */
@RestController
@RequestMapping("/commuKeySet")
public class CommuKeySetController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommuKeySetController.class);

    /**
     * 服务对象
     */
    @Resource
    private CommuKeySetService commuKeySetService;

    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<CommuKeySet>> page(CommuKeySet commuKeySet, Pager pager) {
        ResultModel<DataGrid<CommuKeySet>> result = new ResultModel<>();
        //TODO 分页查询
        pager.setSort("id");
        pager.setOrder(Page.ORDER_DESC);
        commuKeySet.setCompanyId(UserHolder.getCompanyId());
        DataGrid<CommuKeySet> entity = commuKeySetService.customPage(Params.create().add("entity", commuKeySet), pager);
        result.setMessage("分页查询成功");
        result.setModel(entity);
        return result;

    }

    /**
     * 新增或修改
     *
     * @param commuKeySet
     * @param bindingResult
     * @return com.zhiyun.dto.ResultModel<com.zhiyun.entity.CommuKeySet>
     * @author 邓艺
     * @date 2018/9/15 9:05
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<CommuKeySet> addOrUpdate(@Valid CommuKeySet commuKeySet, BindingResult bindingResult) {
        ResultModel<CommuKeySet> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            commuKeySet.setCompanyId(UserHolder.getCompanyId());
            commuKeySetService.addOrUpdate(commuKeySet);
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
            commuKeySetService.deleteByIds(ids);
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
     * @return com.zhiyun.dto.ResultModel<com.zhiyun.dto.CommuKeySetDto>
     * @author 邓艺
     * @date 2018/9/15 10:43
     */
    @RequestMapping(value = "queryDetail", method = RequestMethod.POST)
    public ResultModel<CommuKeySetDto> queryDetail(Long id, HttpServletRequest request) {
        String id1 = request.getParameter("id");
        ResultModel<CommuKeySetDto> result = new ResultModel<>();
        try {
            result.setModel(commuKeySetService.queryDetail(id));
            result.setMessage("查询详情成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 通过设备编码下拉查询通讯键值
     *
     * @param
     * @return com.zhiyun.dto.ResultModel<com.zhiyun.dto.CommuKeySetDto>
     * @author 邓艺
     * @date 2018/9/18 10:44
     */
    @RequestMapping(value = "optionKey", method = RequestMethod.POST)
    public ResultModel<List<CommuKeySet>> optionKey(String macNo) {
        ResultModel<List<CommuKeySet>> result = new ResultModel<>();
        try {
            if (StringUtils.isNotBlank(macNo)) {
                result.setMessage("查询详情成功");
                result.setModel(commuKeySetService.optionKey(macNo));
            }
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

}