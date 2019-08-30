package com.my.shrio.service.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.shrio.domain.User;
import com.my.shrio.dao.UserMapper;
import com.my.shrio.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User selectUserByUsername(String username) {
        return this.baseMapper.selectUserByUsername(username);
    }

}
