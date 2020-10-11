package io.dolphin.exception;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-4 21:38
 */
public class UserNotExistException extends RuntimeException {
    private String id;

    public UserNotExistException(String id) {
        super("user not exits");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
