package com.sensen.sensenshop.common.constant;

/**
 * 0->禁用；1->启用
 * 数据字典
 * <p>
 * Author:  sensen
 * Date:  2024/7/29 11:18
 */
public enum StatusEnum implements IEnum {

    DISABLE(0, "禁用"),

    ENABLE(1, "启用");

    private final Integer code;

    private final String desc;

    StatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getCodeString() {
        return this.code.toString();
    }

    @Override
    public String getDescription() {
        return this.desc;
    }
}
