package com.sensen.sensenshop.common.exception;

import com.sensen.sensenshop.common.constant.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * Author:  sensen
 * Date:  2024/7/29 16:24
 */
@Getter
@Setter
public class SenBaseException extends Exception {

    private Integer code;
    private Object[] args;

    public SenBaseException() {
        super();
    }

    public SenBaseException(String message) {
        super(message);
    }

    public SenBaseException(Throwable cause) {
        super(cause);
    }

    public SenBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SenBaseException(Throwable cause, Integer code, String message, Object... args) {
        super(message, cause);
        this.code = code;
        this.args = args;
    }

    public SenBaseException(Integer code, String message, Object... args) {
        super(message);
        this.code = code;
        this.args = args;
    }

    public SenBaseException(ResultCodeEnum exceptionEnum, Object... args) {
        this(exceptionEnum.getCode(), exceptionEnum.getMessage(), args);
    }

    public SenBaseException(Throwable cause, ResultCodeEnum exceptionEnum, Object... args) {
        this(cause, exceptionEnum.getCode(), exceptionEnum.getMessage(), args);
    }

    @Override
    public String getMessage() {
        if (code != null) {
            if (args != null && args.length > 0) {
                return String.format(super.getMessage(), args);
            }
        }
        return super.getMessage();
    }

}
