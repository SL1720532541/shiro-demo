package com.my.shrio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.shrio.domain.UserRoles;

import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
public interface IUserRolesService extends IService<UserRoles> {
    public Set<String> selectRoleByUsername(String username);
}
