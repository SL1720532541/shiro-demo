package com.my.shrio.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.shrio.domain.UserRoles;

import java.util.Set;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
public interface UserRolesMapper extends BaseMapper<UserRoles> {

    public Set<String> selectRoleByUsername(String username);

}