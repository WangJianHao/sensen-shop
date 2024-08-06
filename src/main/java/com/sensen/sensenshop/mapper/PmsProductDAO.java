package com.sensen.sensenshop.mapper;

import com.sensen.sensenshop.nosql.elasticsearch.document.EsProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: sensen
 * @date: 2024/8/3 15:10
 */
@Repository
public interface PmsProductDAO {

    List<EsProduct> getAllEsProductList(Long id);
}
