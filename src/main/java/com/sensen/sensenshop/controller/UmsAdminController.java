package com.sensen.sensenshop.controller;


import com.sensen.sensenshop.common.api.SenCommonResponse;
import com.sensen.sensenshop.dto.UmsAdminLoginParam;
import com.sensen.sensenshop.entity.UmsAdminDO;
import com.sensen.sensenshop.entity.UmsPermissionDO;
import com.sensen.sensenshop.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@Controller
@Validated
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public SenCommonResponse<UmsAdminDO> register(@RequestBody UmsAdminDO umsAdminParam, BindingResult result) {
        UmsAdminDO umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            SenCommonResponse.failed();
        }
        return SenCommonResponse.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public SenCommonResponse<?> login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return SenCommonResponse.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return SenCommonResponse.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public SenCommonResponse<List<UmsPermissionDO>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermissionDO> permissionList = adminService.getPermissionList(adminId);
        return SenCommonResponse.success(permissionList);
    }
}
