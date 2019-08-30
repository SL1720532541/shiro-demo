package com.my.shrio.service.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.shrio.domain.UserRoles;
import com.my.shrio.dao.UserRolesMapper;
import com.my.shrio.service.IUserRolesService;
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
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements IUserRolesService {

    @Override
    public Set<String> selectRoleByUsername(String username) {
        return this.baseMapper.selectRoleByUsername(username);
    }

}
