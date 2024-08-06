package com.sensen.sensenshop.entity;

import java.io.Serializable;
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
 * @date 2024-07-28 
 */

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
@TableName ( value ="ums_admin_permission_relation" )
public class UmsAdminPermissionRelationDO  implements Serializable {
	private static final long serialVersionUID =  1293017351917439431L;

   	@TableField(value = "id" )
	private Long id;

   	@TableField(value = "admin_id" )
	private Long adminId;

   	@TableField(value = "permission_id" )
	private Long permissionId;

   	@TableField(value = "type" )
	private Long type;

}
