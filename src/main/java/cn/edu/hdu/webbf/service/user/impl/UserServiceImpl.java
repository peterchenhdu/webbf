/*
 * File Name: UserServiceImpl.java
 * Copyright: Copyright 2016-2016 hdu All Rights Reserved.

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年5月24日

 * Modifier: Pi Chen
 * Modify Date: 2016年5月24日
 * Bugzilla Id:
 * Modify Content:
 */
package cn.edu.hdu.webbf.service.user.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hdu.webbf.dao.IUserDao;
import cn.edu.hdu.webbf.model.User;
import cn.edu.hdu.webbf.service.user.IUserService;

/**
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年5月24日
 * @see
 * @since webbf V1.0.0
 */
@Service
public class UserServiceImpl implements IUserService
{

    @Autowired
    private IUserDao userDao;

    /**
     *
     * @see cn.edu.hdu.webbf.service.user.IUserService#queryAll()
     * @return
     * @throws Exception
     */
    @Override
    public List<User> queryAll(Map<String, Object> param) throws Exception
    {
        return userDao.queryAll(param);
    }

    /**
     *
     * @see cn.edu.hdu.webbf.service.user.IUserService#saveUser(java.util.Map)
     * @param param
     * @throws Exception
     */
    @Override
    public void saveUser(Map<String, Object> param) throws Exception
    {
        userDao.saveUser(param);

    }

    /**
     *
     * @see cn.edu.hdu.webbf.service.user.IUserService#deleteUser(java.util.Map)
     * @param param
     * @throws Exception
     */
    @Override
    public void deleteUser(Map<String, Object> param) throws Exception
    {
        userDao.deleteUser(param);
    }

}
