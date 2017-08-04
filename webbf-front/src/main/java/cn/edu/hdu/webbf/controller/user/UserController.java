/*
 * File Name: UserController.java
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

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import cn.edu.hdu.webbf.common.base.BaseController;
import cn.edu.hdu.webbf.model.User;
import cn.edu.hdu.webbf.service.mail.IMailService;
import cn.edu.hdu.webbf.service.user.IUserService;

/**
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年5月23日
 * @see
 * @since webbf V1.0.0
 */
@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;
    @Autowired
    private IMailService mailService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<User>> getUserList(
        @RequestParam(value = "offset", defaultValue = "0") long offset,
        @RequestParam(value = "limit", defaultValue = MAX_LONG_AS_STRING) long limit)
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("offset", offset);
        param.put("limit", limit);
        List<User> userList = userService.query(param);
        if (userList.size() == 0)
        {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {

        User user = userService.findById(id);
        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<User> deleteUser(@PathVariable Long id)
    {
        User user = userService.findById(id);
        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        mailService.sendEmail(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // @RequestMapping(method = RequestMethod.DELETE)
    // public ResponseEntity<User> deleteUsers() {
    // //Deleting All Users
    // userService.deleteUsers();
    // return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    // }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
    public ResponseEntity<User> saveUser(@RequestBody User user, UriComponentsBuilder ucb)
    {

        // if (userService.isUserExist(user)) {
        // System.out.println("A User with name " + user.getName() +
        // " already exist");
        // return new ResponseEntity<User>(user, HttpStatus.CONFLICT);
        // }
        User saved = userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/users/").path(String.valueOf(saved.getId())).build().toUri();
        headers.setLocation(locationUri);

        ResponseEntity<User> responseEntity = new ResponseEntity<User>(saved, headers,
            HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json; charset=utf-8")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user)
    {
        User currentUser = userService.findById(id);

        if (currentUser == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setId(id);
        currentUser.setName(user.getName());
        currentUser.setAddress(user.getAddress());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
}
