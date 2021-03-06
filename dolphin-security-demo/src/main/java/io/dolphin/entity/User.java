package io.dolphin.entity;

import com.fasterxml.jackson.annotation.JsonView;
import io.dolphin.validator.MyConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-2 11:46
 */
@Data
public class User {
    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    private String id;

    @MyConstraint(message = "这是一个测试")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }
}
