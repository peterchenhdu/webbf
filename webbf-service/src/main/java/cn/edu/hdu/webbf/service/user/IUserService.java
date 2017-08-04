/*
 * File Name: IUserDao.java
 * Copyright: Copyright 2016-2016 hdu All Rights Reserved.

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年5月24日

 * Modifier: Pi Chen
 * Modify Date: 2016年5月24日
 * Bugzilla Id:
 * Modify Content:
 */
package cn.edu.hdu.webbf.service.user;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import cn.edu.hdu.webbf.model.User;

/**
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年5月24日
 * @see
 * @since webbf V1.0.0
 */

public interface IUserService
{


    public List<User> query(Map<String, Object> param);

    @Cacheable(value = "userCache", key = "#id")
    public User findById(long id);

    @CachePut(value = "userCache", key="#result.id")
    public User saveUser(User user);

    //注意key的类型要一致，不要一个是long，一个object or string
    @CacheEvict(value = "userCache", key = "#id")
    public void deleteUser(long id);

    public User updateUser(User user);
}
