package com.sensen.sensenshop.service.impl;

import com.sensen.sensenshop.common.api.SenCommonPage;
import com.sensen.sensenshop.mapper.PmsProductDAO;
import com.sensen.sensenshop.nosql.elasticsearch.document.EsProduct;
import com.sensen.sensenshop.nosql.elasticsearch.repository.EsProductRepository;
import com.sensen.sensenshop.service.EsProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: sensen
 * @date: 2024/8/3 15:08
 */
@Slf4j
@Service
@AllArgsConstructor
public class EsProductServiceImpl implements EsProductService {

    private PmsProductDAO productDAO;

    private EsProductRepository productRepository;

    private TransactionTemplate transactionTemplate;

    @Override
    public int importAll() {
        List<EsProduct> esProductList = productDAO.getAllEsProductList(null);
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = productDAO.getAllEsProductList(id);
        if (esProductList.size() > 0) {
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<>();
            for (Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public SenCommonPage<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        //有第0页，这个前后端处理都行，一般是后端处理方便点
        Page<EsProduct> page = productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
        return SenCommonPage.restPage(page);
    }
}
