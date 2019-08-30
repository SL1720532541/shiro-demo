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
@TableName("user_roles")
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableField(value="user_id")
	private Long userId;

	/**
	 * 
	 */
	private String username;

	/**
	 * 
	 */
	@TableField(value="role_name")
	private String roleName;



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
