package com.my.shrio.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
@TableName("roles_permissions")
public class RolesPermissions implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	@TableField(value="role_name")
	private String roleName;

	/**
	 * 
	 */
	private String permission;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
