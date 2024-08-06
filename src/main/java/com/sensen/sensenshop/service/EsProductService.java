package com.sensen.sensenshop.service;

import com.sensen.sensenshop.common.api.SenCommonPage;
import com.sensen.sensenshop.nosql.elasticsearch.document.EsProduct;

import java.util.List;

/**
 * @description:
 * @author: sensen
 * @date: 2024/8/3 15:07
 */
public interface EsProductService {

    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

    /**
     * 根据id删除商品
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     */
    SenCommonPage<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
