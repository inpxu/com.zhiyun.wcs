package com.zhiyun.controller;

import com.zhiyun.base.model.DataGrid;
import com.zhiyun.base.model.Page;
import com.zhiyun.base.model.Pager;
import com.zhiyun.base.model.Params;
import com.zhiyun.client.UserHolder;
import com.zhiyun.dto.PathCollectionsSetDto;
import com.zhiyun.dto.RelationDto;
import com.zhiyun.dto.ResultModel;
import com.zhiyun.entity.PathCollectionsSet;
import com.zhiyun.service.PathCollectionsSetService;
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
 * 设备路径集 前端控制器
 * </p>
 *
 * @author 邓艺
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/pathCollectionsSet")
public class PathCollectionsSetController extends BasicController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PathCollectionsSetController.class);
    @Autowired
    private PathCollectionsSetService pathCollectionsSetService;

    /**
     * 路径集分页查询
     *
     * @param pathCollectionsSet
     * @param pager
     * @return java.util.List<com.zhiyun.wcs.entity.SinglePathSet>
     * @author 邓艺
     * @date 2018/9/6 10:36
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public ResultModel<DataGrid<PathCollectionsSetDto>> page(PathCollectionsSet pathCollectionsSet, Pager pager) {
        pathCollectionsSet.setCompanyId(UserHolder.getCompanyId());
        ResultModel<DataGrid<PathCollectionsSetDto>> result = new ResultModel<>();
        pathCollectionsSet.setCompanyId(UserHolder.getCompanyId());
        pager.setSort("id");
        pager.setOrder(Page.ORDER_DESC);
        DataGrid<PathCollectionsSetDto> entity = pathCollectionsSetService.customPage(Params.create().add("entity", pathCollectionsSet), pager);
        //TODO 分页查询
        result.setModel(entity);
        result.setMessage("分页查询成功");
        return result;
    }

    /**
     * 路径集新增或更新
     *
     * @param pathCollectionsSet
     * @param bindingResult
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.PathCollectionsSet>
     * @author 邓艺
     * @date 2018/9/6 11:21
     */
    @RequestMapping(value = "addOrUpdate", method = RequestMethod.POST)
    public ResultModel<PathCollectionsSet> addOrUpdate(@Valid PathCollectionsSet pathCollectionsSet, BindingResult bindingResult) {
        ResultModel<PathCollectionsSet> result = new ResultModel<>();
        try {
            validateParam(bindingResult);
            pathCollectionsSet.setCompanyId(UserHolder.getCompanyId());
            pathCollectionsSetService.addOrUpdate(pathCollectionsSet);
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
     * 路径集删除
     *
     * @param ids
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.SitSet>
     * @author 邓艺
     * @date 2018/9/6 10:26
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultModel<PathCollectionsSet> delete(Long[] ids) {
        ResultModel<PathCollectionsSet> result = new ResultModel<>();
        try {
            validateIds(ids);
            //TODO 删除数据
            pathCollectionsSetService.deleteByIds(ids);
            result.setMessage("删除成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    /**
     * 保存一对多关系
     *
     * @param relationDto
     * @return com.zhiyun.wcs.utils.ResultModel<com.zhiyun.wcs.entity.PathCollectionsSet>
     * @author 邓艺
     * @date 2018/9/6 11:31
     */
    @RequestMapping(value = "saveRelations", method = RequestMethod.POST)
    public ResultModel<PathCollectionsSet> saveRelations(@RequestBody RelationDto relationDto) {
        ResultModel<PathCollectionsSet> result = new ResultModel<>();
        try {
            pathCollectionsSetService.saveRelations(relationDto);
            result.setMessage("新增成功");
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage(e.getMessage());
            LOGGER.warn(e.getMessage(), e.getCause());
        }
        return result;
    }

    @RequestMapping(value = "beforeAddSinglePath", method = RequestMethod.POST)
    public ResultModel<PathCollectionsSetDto> beforeAddSinglePath(PathCollectionsSet pathCollectionsSet) {
        ResultModel<PathCollectionsSetDto> result = new ResultModel<>();
        pathCollectionsSet.setCompanyId(UserHolder.getCompanyId());
        result.setMessage("查询成功");
        result.setModel(pathCollectionsSetService.beforeAddSinglePath(pathCollectionsSet));
        return result;
    }

}

