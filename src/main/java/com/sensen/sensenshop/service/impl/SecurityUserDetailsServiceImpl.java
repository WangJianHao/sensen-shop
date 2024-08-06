package com.sensen.sensenshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sensen.sensenshop.dto.AdminUserDetails;
import com.sensen.sensenshop.entity.UmsAdminDO;
import com.sensen.sensenshop.entity.UmsPermissionDO;
import com.sensen.sensenshop.mapper.UmsAdminDAO;
import com.sensen.sensenshop.mapper.UmsAdminRoleRelationDAO;
import com.sensen.sensenshop.service.SecurityUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  sensen
 * Date:  2024/7/29 17:13
 */
@Slf4j
@Service
@AllArgsConstructor
public class SecurityUserDetailsServiceImpl implements UserDetailsService, SecurityUserDetailsService {

    private UmsAdminDAO umsAdminDAO;

    private UmsAdminRoleRelationDAO adminRoleRelationDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdminDO admin = getAdminByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        List<UmsPermissionDO> permissionList = getPermissionList(admin.getId());
        return new AdminUserDetails(admin, permissionList);
    }

    @Override
    public UmsAdminDO getAdminByUsername(String username) {
        LambdaQueryWrapper<UmsAdminDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsAdminDO::getUsername, username);
        return umsAdminDAO.selectOne(queryWrapper);
    }

    @Override
    public List<UmsPermissionDO> getPermissionList(Long adminId) {
        return adminRoleRelationDAO.listPermissionByAdminId(adminId);
    }
}
