package com.sensen.sensenshop.controller;


import com.sensen.sensenshop.common.api.SenCommonResponse;
import com.sensen.sensenshop.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员登录注册管理Controller
 *
 * @author sensen
 * @date 2021-01-01
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
@AllArgsConstructor
public class UmsMemberController {

    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public SenCommonResponse<?> getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public SenCommonResponse<?> verifyAuthCode(@RequestParam String telephone,
                                               @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }

    @ApiOperation("获取邮箱验证码")
    @RequestMapping(value = "/getMailAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public SenCommonResponse<?> getMailAuthCode(@RequestParam String mail) {
        return memberService.generateMailAuthCode(mail);
    }
}
