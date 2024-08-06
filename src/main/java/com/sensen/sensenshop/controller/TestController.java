package com.sensen.sensenshop.controller;

import com.sensen.sensenshop.common.api.SenCommonResponse;
import com.sensen.sensenshop.common.constant.ResultCodeEnum;
import com.sensen.sensenshop.common.exception.SenBaseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: sensen
 * @date: 2024/8/5 14:26
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/method1")
    public SenCommonResponse<Integer> method1() throws SenBaseException {
        throw new SenBaseException(ResultCodeEnum.SUCCESS);
    }


    @GetMapping(value = "/method4")
    public String method4() {
        // 抛出ArithmeticException异常
        return String.valueOf(1 / 0);
    }

}
