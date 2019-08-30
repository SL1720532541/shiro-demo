package com.my.shrio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.shrio.domain.RolesPermissions;

import java.util.Set;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
public interface IRolesPermissionsService extends IService<RolesPermissions> {
    Set<String> selectByRolename(String roleName);
}
