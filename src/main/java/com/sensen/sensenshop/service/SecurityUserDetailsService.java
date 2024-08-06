package com.sensen.sensenshop.service;

import com.sensen.sensenshop.entity.UmsAdminDO;
import com.sensen.sensenshop.entity.UmsPermissionDO;

import java.util.List;

/**
 * Author:  sensen
 * Date:  2024/7/29 17:17
 */
public interface SecurityUserDetailsService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdminDO getAdminByUsername(String username);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UmsPermissionDO> getPermissionList(Long adminId);
}
