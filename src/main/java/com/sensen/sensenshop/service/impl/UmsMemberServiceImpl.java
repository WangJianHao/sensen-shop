package com.sensen.sensenshop.service.impl;


import com.sensen.sensenshop.common.api.SenCommonResponse;
import com.sensen.sensenshop.service.RedisService;
import com.sensen.sensenshop.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 会员管理Service实现类
 * @author sensen
 * @date 2021-01-01
 */
@Service
@Configuration
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode:'portal:authCode:'}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode:120}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public SenCommonResponse<?> generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return SenCommonResponse.success(sb.toString(), "获取验证码成功");
    }


    //对输入的验证码进行校验
    @Override
    public SenCommonResponse<?> verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return SenCommonResponse.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return SenCommonResponse.success(null, "验证码校验成功");
        } else {
            return SenCommonResponse.failed("验证码不正确");
        }
    }

    @Override
    public SenCommonResponse<?> generateMailAuthCode(String mail) {
        return null;
    }

}
