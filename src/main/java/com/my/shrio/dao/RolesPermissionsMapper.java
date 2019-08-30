package com.my.shrio.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.shrio.domain.RolesPermissions;

import java.util.Set;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
public interface RolesPermissionsMapper extends BaseMapper<RolesPermissions> {
    Set<String> selectByRolename(String roleName);
}