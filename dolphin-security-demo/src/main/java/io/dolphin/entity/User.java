package io.dolphin.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-2 11:46
 */
@Data
public class User {
    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    private String username;

    private String password;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }
}
