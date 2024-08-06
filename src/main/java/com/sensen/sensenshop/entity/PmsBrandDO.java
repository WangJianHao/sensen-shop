package com.sensen.sensenshop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 实体类
 *
 * @author sensen
 * @date 2021-01-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@TableName("pms_brand")
public class PmsBrandDO implements Serializable {

    //多个主键用 @MppMultiId注解标识而不是TableId
    @TableId("id")
    @ApiModelProperty(value = "id")
    private Long id;


    @TableField("name")
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 首字母
     */
    @TableField("first_letter")
    @ApiModelProperty(value = "首字母")
    private String firstLetter;

    @TableField("sort")
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    @TableField("factory_status")
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;

    @TableField("show_status")
    @ApiModelProperty(value = "show_status")
    private Integer showStatus;

    /**
     * 产品数量
     */
    @TableField("product_count")
    @ApiModelProperty(value = "产品数量")
    private Integer productCount;

    /**
     * 产品评论数量
     */
    @TableField("product_comment_count")
    @ApiModelProperty(value = "产品评论数量")
    private Integer productCommentCount;

    /**
     * 品牌logo
     */
    @TableField("logo")
    @ApiModelProperty(value = "品牌logo")
    private String logo;

    /**
     * 专区大图
     */
    @TableField("big_pic")
    @ApiModelProperty(value = "专区大图")
    private String bigPic;

    /**
     * 品牌故事
     */
    @TableField("brand_story")
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;

    private static final long serialVersionUID = 1L;
}
