package com.my.shrio.domain;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;

	/**
	 * 
	 */
	private String username;

	/**
	 * 
	 */
	private String password;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
