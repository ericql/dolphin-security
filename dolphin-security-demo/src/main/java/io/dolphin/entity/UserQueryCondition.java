package io.dolphin.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-3 20:22
 */
@Data
public class UserQueryCondition {
    private String username;

    private int age;

    private int ageTo;
}
