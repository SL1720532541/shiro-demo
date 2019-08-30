package com.my.shrio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.shrio.domain.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
public interface IUserService extends IService<User> {
    User selectUserByUsername(String username);
}
