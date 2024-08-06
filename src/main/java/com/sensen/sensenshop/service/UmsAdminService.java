package com.sensen.sensenshop.service;

import com.sensen.sensenshop.entity.UmsAdminDO;
import com.sensen.sensenshop.entity.UmsPermissionDO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台管理员Service
 * Created by macro on 2018/4/26.
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdminDO getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdminDO register(UmsAdminDO umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermissionDO> getPermissionList(Long adminId);
}
