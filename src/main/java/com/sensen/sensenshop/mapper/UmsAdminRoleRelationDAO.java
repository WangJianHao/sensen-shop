package com.sensen.sensenshop.mapper;

import com.sensen.sensenshop.entity.UmsPermissionDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:  sensen
 * Date:  2024/7/28 21:21
 */
@Repository
public interface UmsAdminRoleRelationDAO {

    List<UmsPermissionDO> listPermissionByAdminId(Long adminId);
}
