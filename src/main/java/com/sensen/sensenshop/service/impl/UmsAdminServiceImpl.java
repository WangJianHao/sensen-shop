package com.sensen.sensenshop.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sensen.sensenshop.common.constant.StatusEnum;
import com.sensen.sensenshop.common.utils.JwtTokenUtil;
import com.sensen.sensenshop.dto.AdminUserDetails;
import com.sensen.sensenshop.entity.UmsAdminDO;
import com.sensen.sensenshop.entity.UmsPermissionDO;
import com.sensen.sensenshop.mapper.UmsAdminDAO;
import com.sensen.sensenshop.mapper.UmsAdminRoleRelationDAO;
import com.sensen.sensenshop.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

/**
 * UmsAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Slf4j
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UmsAdminDAO adminMapper;

    @Autowired
    private UmsAdminRoleRelationDAO adminRoleRelationDAO;

    @Override
    public UmsAdminDO getAdminByUsername(String username) {
        LambdaQueryWrapper<UmsAdminDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsAdminDO::getUsername, username);
        return adminMapper.selectOne(queryWrapper);
    }

    @Override
    public UmsAdminDO register(UmsAdminDO umsAdminParam) {
        UmsAdminDO umsAdmin = new UmsAdminDO();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setStatus(StatusEnum.ENABLE.getCode());
        //查询是否有相同用户名的用户
        UmsAdminDO adminByUsername = getAdminByUsername(umsAdmin.getUsername());
        if (Objects.nonNull(adminByUsername)) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = null;
            UmsAdminDO umsAdminDO = getAdminByUsername(username);
            Assert.notNull(umsAdminDO, "用户名不存在");

            List<UmsPermissionDO> permissionList = getPermissionList(umsAdminDO.getId());
            userDetails = new AdminUserDetails(umsAdminDO, permissionList);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.error("登录异常:{}", e.getMessage());
        } catch (Exception e) {
            log.error("登录失败");
        }
        return token;
    }


    @Override
    public List<UmsPermissionDO> getPermissionList(Long adminId) {
        return adminRoleRelationDAO.listPermissionByAdminId(adminId);
    }
}
