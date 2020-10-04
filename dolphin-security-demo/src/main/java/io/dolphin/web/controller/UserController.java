package io.dolphin.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.dolphin.entity.User;
import io.dolphin.entity.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-2 11:44
 */
@Validated
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user);

        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,
                            @PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {
        System.out.println(condition);

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        final List<User> userList = Arrays.asList(new User(), new User(), new User());
        return userList;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable("id") String id) {
        final User user = new User();
        user.setUsername("tom");
        return user;
    }
}
