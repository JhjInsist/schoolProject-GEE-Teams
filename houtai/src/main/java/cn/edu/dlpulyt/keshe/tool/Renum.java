package cn.edu.dlpulyt.keshe.tool;

import lombok.Data;

import java.util.Map;

/**
 * @version V1.0
 * @Package com.ss.jwt.R
 * @author: Liu
 * @Date: 10:36
 */
//枚举类
public enum Renum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    USER_NOT_EXIST(1,"用户不存在"),
    USER_IS_EXISTS(2,"用户已存在"),
    DATA_IS_NULL(3,"数据为空"),
    PASSWORD_NOT_MATCH(4,"密码错误"),
    NO_AUTHORITY(5,"没有权限")
    ;
    private Integer code;
    private String msg;

  Renum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }



    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}