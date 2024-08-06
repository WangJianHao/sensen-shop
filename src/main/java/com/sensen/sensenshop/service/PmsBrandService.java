package com.sensen.sensenshop.service;


import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.sensen.sensenshop.common.api.SenCommonPage;
import com.sensen.sensenshop.entity.PmsBrandDO;

import java.util.List;

/**
 * PmsBrandService
 * @author sensen
 * @date 2021-01-01
 */
public interface PmsBrandService extends IMppService<PmsBrandDO> {
    List<PmsBrandDO> listAllBrand();

    int createBrand(PmsBrandDO brand);

    int updateBrand(Long id, PmsBrandDO brand);

    int deleteBrand(Long id);

    PmsBrandDO getBrand(Long id);

    SenCommonPage<PmsBrandDO> listBrandWithPage(Integer pageNum, Integer pageSize);
}
