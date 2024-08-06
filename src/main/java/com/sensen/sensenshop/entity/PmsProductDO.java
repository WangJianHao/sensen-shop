package com.sensen.sensenshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.ToString;

/**
 * @Description  
 * @author  sensen 
 * @date 2024-08-03 
 */

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
@TableName ( value ="pms_product" )
public class PmsProductDO  implements Serializable {
	private static final long serialVersionUID =  569622412543642604L;

	@TableId
   	@TableField(value = "id" )
	private Long id;

   	@TableField(value = "brand_id" )
	private Long brandId;

   	@TableField(value = "product_category_id" )
	private Long productCategoryId;

   	@TableField(value = "feight_template_id" )
	private Long feightTemplateId;

   	@TableField(value = "product_attribute_category_id" )
	private Long productAttributeCategoryId;

   	@TableField(value = "name" )
	private String name;

   	@TableField(value = "pic" )
	private String pic;

	/**
	 * 货号
	 */
   	@TableField(value = "product_sn" )
	private String productSn;

	/**
	 * 删除状态：0->未删除；1->已删除
	 */
   	@TableField(value = "delete_status" )
	private Long deleteStatus;

	/**
	 * 上架状态：0->下架；1->上架
	 */
   	@TableField(value = "publish_status" )
	private Long publishStatus;

	/**
	 * 新品状态:0->不是新品；1->新品
	 */
   	@TableField(value = "new_status" )
	private Long newStatus;

	/**
	 * 推荐状态；0->不推荐；1->推荐
	 */
   	@TableField(value = "recommand_status" )
	private Long recommandStatus;

	/**
	 * 审核状态：0->未审核；1->审核通过
	 */
   	@TableField(value = "verify_status" )
	private Long verifyStatus;

	/**
	 * 排序
	 */
   	@TableField(value = "sort" )
	private Long sort;

	/**
	 * 销量
	 */
   	@TableField(value = "sale" )
	private Long sale;

   	@TableField(value = "price" )
	private Double price;

	/**
	 * 促销价格
	 */
   	@TableField(value = "promotion_price" )
	private Double promotionPrice;

	/**
	 * 赠送的成长值
	 */
   	@TableField(value = "gift_growth" )
	private Long giftGrowth;

	/**
	 * 赠送的积分
	 */
   	@TableField(value = "gift_point" )
	private Long giftPoint;

	/**
	 * 限制使用的积分数
	 */
   	@TableField(value = "use_point_limit" )
	private Long usePointLimit;

	/**
	 * 副标题
	 */
   	@TableField(value = "sub_title" )
	private String subTitle;

	/**
	 * 商品描述
	 */
   	@TableField(value = "description" )
	private String description;

	/**
	 * 市场价
	 */
   	@TableField(value = "original_price" )
	private Double originalPrice;

	/**
	 * 库存
	 */
   	@TableField(value = "stock" )
	private Long stock;

	/**
	 * 库存预警值
	 */
   	@TableField(value = "low_stock" )
	private Long lowStock;

	/**
	 * 单位
	 */
   	@TableField(value = "unit" )
	private String unit;

	/**
	 * 商品重量，默认为克
	 */
   	@TableField(value = "weight" )
	private Double weight;

	/**
	 * 是否为预告商品：0->不是；1->是
	 */
   	@TableField(value = "preview_status" )
	private Long previewStatus;

	/**
	 * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
	 */
   	@TableField(value = "service_ids" )
	private String serviceIds;

   	@TableField(value = "keywords" )
	private String keywords;

   	@TableField(value = "note" )
	private String note;

	/**
	 * 画册图片，连产品图片限制为5张，以逗号分割
	 */
   	@TableField(value = "album_pics" )
	private String albumPics;

   	@TableField(value = "detail_title" )
	private String detailTitle;

   	@TableField(value = "detail_desc" )
	private String detailDesc;

	/**
	 * 产品详情网页内容
	 */
   	@TableField(value = "detail_html" )
	private String detailHtml;

	/**
	 * 移动端网页详情
	 */
   	@TableField(value = "detail_mobile_html" )
	private String detailMobileHtml;

	/**
	 * 促销开始时间
	 */
   	@TableField(value = "promotion_start_time" )
	private Timestamp promotionStartTime;

	/**
	 * 促销结束时间
	 */
   	@TableField(value = "promotion_end_time" )
	private Timestamp promotionEndTime;

	/**
	 * 活动限购数量
	 */
   	@TableField(value = "promotion_per_limit" )
	private Long promotionPerLimit;

	/**
	 * 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
	 */
   	@TableField(value = "promotion_type" )
	private Long promotionType;

	/**
	 * 品牌名称
	 */
   	@TableField(value = "brand_name" )
	private String brandName;

	/**
	 * 商品分类名称
	 */
   	@TableField(value = "product_category_name" )
	private String productCategoryName;

}
