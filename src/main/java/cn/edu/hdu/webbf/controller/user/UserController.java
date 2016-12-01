/*
 * File Name: LifeService.java
 * Copyright: Copyright 2016-2016 hdu All Rights Reserved.

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年5月23日

 * Modifier: Pi Chen
 * Modify Date: 2016年5月23日
 * Bugzilla Id:
 * Modify Content:
 */
package cn.edu.hdu.webbf.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hdu.webbf.common.base.BaseController;
import cn.edu.hdu.webbf.model.User;
import cn.edu.hdu.webbf.service.user.IUserService;

/**
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年5月23日
 * @see
 * @since webbf V1.0.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/getUserList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUserList(int pageNo, int pageSize)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pageNo", pageNo);
        param.put("pageSize", pageSize);
        List<User> userList = userService.query(param);
        map.put("userList", userList);
        return gson.toJson(map);
    }

    @RequestMapping(value = "/getUserById", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUserById(long id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        List<User> userList = userService.query(param);
        map.put("userList", userList);
        return gson.toJson(map);
    }

    @RequestMapping(value = "/deleteUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteUser(int userId)
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        userService.deleteUser(param);
        return gson.toJson("success");
    }

    @RequestMapping(value = "/saveUserTest", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String saveUserTest(String userName, String address)
    {
        /* test transaction */
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", userName);
        param.put("address", address);
        userService.saveUser(param);
        return gson.toJson("success");
    }
}
