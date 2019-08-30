package com.my.shrio.service.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.shrio.domain.RolesPermissions;
import com.my.shrio.dao.RolesPermissionsMapper;
import com.my.shrio.service.IRolesPermissionsService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
@Service
public class RolesPermissionsServiceImpl extends ServiceImpl<RolesPermissionsMapper, RolesPermissions> implements IRolesPermissionsService {

    @Override
    public Set<String> selectByRolename(String roleName) {
        return this.baseMapper.selectByRolename(roleName);
    }

}
