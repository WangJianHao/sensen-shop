package com.sensen.sensenshop.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.sensen.sensenshop.entity.PmsBrandDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author sensen
 * @date 2021-01-01
 */
@Repository
public interface PmsBrandDAO extends MppBaseMapper<PmsBrandDO> {

    IPage<PmsBrandDO> queryPmsBrandWithPage(Page<PmsBrandDO> page, @Param("queryParam") QueryWrapper<PmsBrandDO> queryWrapper);
    
}
