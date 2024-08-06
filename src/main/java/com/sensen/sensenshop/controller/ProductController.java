package com.sensen.sensenshop.controller;


import com.sensen.sensenshop.common.api.SenCommonPage;
import com.sensen.sensenshop.common.api.SenCommonResponse;
import com.sensen.sensenshop.nosql.elasticsearch.document.EsProduct;
import com.sensen.sensenshop.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 搜索商品管理Controller
 * Created by macro on 2018/6/19.
 */
@Controller
@Api(tags = "EsProductController", description = "搜索商品管理")
@RequestMapping("/esProduct")
@AllArgsConstructor
public class ProductController {

    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public SenCommonResponse<Integer> importAllList() {
        int count = esProductService.importAll();
        return SenCommonResponse.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SenCommonResponse<Object> delete(@PathVariable Long id) {
        esProductService.delete(id);
        return SenCommonResponse.success(null);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public SenCommonResponse<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return SenCommonResponse.success(null);
    }

    @ApiOperation(value = "根据id创建商品")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public SenCommonResponse<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return SenCommonResponse.success(esProduct);
        } else {
            return SenCommonResponse.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public SenCommonResponse<SenCommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                              @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                              @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        SenCommonPage<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return SenCommonResponse.success(esProductPage);
    }

}
