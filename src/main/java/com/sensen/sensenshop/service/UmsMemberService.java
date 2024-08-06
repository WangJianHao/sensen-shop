package com.sensen.sensenshop.service;


import com.sensen.sensenshop.common.api.SenCommonResponse;

/**
 * 会员管理Service
 *
 * @author sensen
 * @date 2021-01-01
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    SenCommonResponse<?> generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    SenCommonResponse<?> verifyAuthCode(String telephone, String authCode);

    /**
     * 生成验证码
     *
     * @param mail 邮箱
     * @return 返回体
     */
    SenCommonResponse<?> generateMailAuthCode(String mail);
}
