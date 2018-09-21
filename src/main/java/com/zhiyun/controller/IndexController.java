package com.zhiyun.controller;

import com.zhiyun.base.controller.BaseController;
import com.zhiyun.client.UserHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/index")
public class IndexController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Value("${cloudUrl}")
    private String backUrl;
    //    @Resource
    //    private InterfaceForUser interfaceForUser;
    /**
     * 系统版本
     */
    @Value("${wcsVersion}")
    private String wcsVersion;

    /**
     * 同步请求
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        logger.debug("request in");
        model.addAttribute("backUrl", backUrl);
        model.addAttribute("userName", UserHolder.getUserName());
        model.addAttribute("companyName", UserHolder.getCompanyName());
        //        List<AppMenuDto> list = interfaceForUser.getUserMenuForApp("plm", Integer.parseInt(wcsVersion), UserHolder.getId(), UserHolder.getCompanyId());
        //        if (!CollectionUtils.isEmpty(list)) {
        //            String a = JSON.toJSONString(list);
        //            model.addAttribute("menuList", JSON.toJSONString(list));
        //        } else {
        //            model.addAttribute("menuList", JSON.toJSONString("[]"));
        //        }
        return "/demo/index";
    }

}
