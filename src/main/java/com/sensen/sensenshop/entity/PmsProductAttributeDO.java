package com.sensen.sensenshop.entity;

import java.io.Serializable;

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
@TableName ( value ="pms_product_attribute" )
public class PmsProductAttributeDO  implements Serializable {
	private static final long serialVersionUID =  7587904245622182836L;

	@TableId
   	@TableField(value = "id" )
	private Long id;

   	@TableField(value = "product_attribute_category_id" )
	private Long productAttributeCategoryId;

   	@TableField(value = "name" )
	private String name;

	/**
	 * 属性选择类型：0->唯一；1->单选；2->多选
	 */
   	@TableField(value = "select_type" )
	private Long selectType;

	/**
	 * 属性录入方式：0->手工录入；1->从列表中选取
	 */
   	@TableField(value = "input_type" )
	private Long inputType;

	/**
	 * 可选值列表，以逗号隔开
	 */
   	@TableField(value = "input_list" )
	private String inputList;

	/**
	 * 排序字段：最高的可以单独上传图片
	 */
   	@TableField(value = "sort" )
	private Long sort;

	/**
	 * 分类筛选样式：1->普通；1->颜色
	 */
   	@TableField(value = "filter_type" )
	private Long filterType;

	/**
	 * 检索类型；0->不需要进行检索；1->关键字检索；2->范围检索
	 */
   	@TableField(value = "search_type" )
	private Long searchType;

	/**
	 * 相同属性产品是否关联；0->不关联；1->关联
	 */
   	@TableField(value = "related_status" )
	private Long relatedStatus;

	/**
	 * 是否支持手动新增；0->不支持；1->支持
	 */
   	@TableField(value = "hand_add_status" )
	private Long handAddStatus;

	/**
	 * 属性的类型；0->规格；1->参数
	 */
   	@TableField(value = "type" )
	private Long type;

}
