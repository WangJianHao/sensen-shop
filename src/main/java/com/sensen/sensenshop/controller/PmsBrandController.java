package com.sensen.sensenshop.controller;


import com.sensen.sensenshop.common.api.SenCommonPage;
import com.sensen.sensenshop.common.api.SenCommonResponse;
import com.sensen.sensenshop.entity.PmsBrandDO;
import com.sensen.sensenshop.service.PmsBrandService;
import com.sensen.timelog.annotation.TimeLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 品牌管理Controller
 *
 * @author sensen
 * @date 2021-01-01
 */
@Slf4j
@RestController
@RequestMapping("/brand")
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@AllArgsConstructor
public class PmsBrandController {

    private final PmsBrandService demoService;


    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    @TimeLog
//    @PreAuthorize("hasAuthority('pms:brand:read')")
    public SenCommonResponse<List<PmsBrandDO>> getBrandList() {
        return SenCommonResponse.success(demoService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public SenCommonResponse<?> createBrand(@RequestBody PmsBrandDO PmsBrandDO) {
        SenCommonResponse<?> senCommonResponse;
        int count = demoService.createBrand(PmsBrandDO);
        if (count == 1) {
            senCommonResponse = SenCommonResponse.success(PmsBrandDO);
            log.debug("createBrand success:{}", PmsBrandDO);
        } else {
            senCommonResponse = SenCommonResponse.failed("操作失败");
            log.debug("createBrand failed:{}", PmsBrandDO);
        }
        return senCommonResponse;
    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public SenCommonResponse<?> updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrandDO pmsBrandDTO, BindingResult result) {
        SenCommonResponse<?> senCommonResponse;
        int count = demoService.updateBrand(id, pmsBrandDTO);
        if (count == 1) {
            senCommonResponse = SenCommonResponse.success(pmsBrandDTO);
            log.debug("updateBrand success:{}", pmsBrandDTO);
        } else {
            senCommonResponse = SenCommonResponse.failed("操作失败");
            log.debug("updateBrand failed:{}", pmsBrandDTO);
        }
        return senCommonResponse;
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public SenCommonResponse<?> deleteBrand(@PathVariable("id") Long id) {
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            log.debug("deleteBrand success :id={}", id);
            return SenCommonResponse.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return SenCommonResponse.failed("操作失败");
        }
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public SenCommonResponse<SenCommonPage<PmsBrandDO>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        //fixme 请求参数为空的情况下
        SenCommonPage<PmsBrandDO> senCommonPage = demoService.listBrandWithPage(pageNum, pageSize);
        return SenCommonResponse.success(senCommonPage);
    }

    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public SenCommonResponse<PmsBrandDO> brand(@PathVariable("id") Long id) {
        return SenCommonResponse.success(demoService.getBrand(id));
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/listBrandWithPage", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public SenCommonResponse<SenCommonPage<PmsBrandDO>> listBrandWithPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                          @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        //fixme 请求参数为空的情况下
        SenCommonPage<PmsBrandDO> senCommonPage = demoService.listBrandWithPage(pageNum, pageSize);
        return SenCommonResponse.success(senCommonPage);
    }
}
