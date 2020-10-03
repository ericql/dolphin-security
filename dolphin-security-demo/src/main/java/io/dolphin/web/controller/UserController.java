package io.dolphin.web.controller;

import io.dolphin.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-2 11:44
 */
@RestController
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(@RequestParam String username) {
        System.out.println(username);
        final List<User> userList = Arrays.asList(new User(), new User(), new User());
        return userList;
    }
}
