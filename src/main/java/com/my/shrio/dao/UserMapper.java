package com.my.shrio.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.shrio.domain.User;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author songlei
 * @since 2019-08-29
 */
public interface UserMapper extends BaseMapper<User> {
    User selectUserByUsername(String username);
}