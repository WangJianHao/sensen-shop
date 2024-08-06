package com.sensen.sensenshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.sensen.sensenshop.common.api.SenCommonPage;
import com.sensen.sensenshop.entity.PmsBrandDO;
import com.sensen.sensenshop.mapper.PmsBrandDAO;
import com.sensen.sensenshop.service.PmsBrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PmsBrandService实现类
 * @author sensen
 * @date 2021-01-01
 */
@Service
@AllArgsConstructor
public class PmsBrandServiceImpl extends MppServiceImpl<PmsBrandDAO, PmsBrandDO> implements PmsBrandService {


    private PmsBrandDAO pmsBrandDAO;

    @Override
    public List<PmsBrandDO> listAllBrand() {
        return pmsBrandDAO.selectList(new QueryWrapper<>());
    }

    @Override
    public int createBrand(PmsBrandDO brand) {
        return pmsBrandDAO.insert(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrandDO brand) {
        brand.setId(id);
        return pmsBrandDAO.updateById(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandDAO.deleteById(id);
    }


    @Override
    public PmsBrandDO getBrand(Long id) {
        return pmsBrandDAO.selectById(id);
    }

    @Override
    public SenCommonPage<PmsBrandDO> listBrandWithPage(Integer pageNum, Integer pageSize) {
        Page<PmsBrandDO> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        QueryWrapper<PmsBrandDO> queryWrapper = new QueryWrapper<>();
        Page<PmsBrandDO> pmsBrandDOPage = pmsBrandDAO.selectPage(page, queryWrapper);
//        pmsBrandDAO.queryPmsBrandWithPage(page, queryWrapper);
        return SenCommonPage.restPage(pmsBrandDOPage);
    }
}
