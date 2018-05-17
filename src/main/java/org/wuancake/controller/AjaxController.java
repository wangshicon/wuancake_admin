package org.wuancake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.wuancake.entity.Admin;
import org.wuancake.entity.Gather;
import org.wuancake.entity.Group;
import org.wuancake.entity.PageBean;
import org.wuancake.service.IGroupService;
import org.wuancake.service.IReportService;
import org.wuancake.service.IUserService;
import org.wuancake.utils.WeekNumUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专门接收ajax请求的
 */
@Controller
public class AjaxController extends FatherOfController {

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IReportService reportService;

    @RequestMapping(value = "showGroup")
    @ResponseBody
    List<Group> showGroup(HttpServletResponse response) {
        List<Group> groups = groupService.showGroup();
        return groups;
    }

    @RequestMapping(value = "showWeekNum")
    @ResponseBody
    Integer showWeekNum(HttpServletResponse response) {
        return WeekNumUtils.getMaxWeekNum();
    }

    @RequestMapping(value = "queryGatherByPage")
    String queryGatherByPage(Integer currPage, HttpServletRequest request) {

        PageBean pageBean = pageQuery(currPage, request, null);

        ArrayList<Object> sessionList = (ArrayList<Object>) request.getSession().getAttribute("sessionList");

        //更新session中的PageBean信息
        sessionList.set(1, pageBean);

        return "main";
    }

}
