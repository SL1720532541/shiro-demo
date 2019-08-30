package com.my.shrio.cfg;

import com.my.shrio.domain.User;
import com.my.shrio.service.IRolesPermissionsService;
import com.my.shrio.service.IUserRolesService;
import com.my.shrio.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private IUserRolesService userRolesService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRolesPermissionsService rolesPermissionsService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //为当前登录成功的用户授予权限和分配角色。
        String username = (String)principals.getPrimaryPrincipal();
        //查询用户角色
        Set<String> roles = userRolesService.selectRoleByUsername(username);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        //查询用户权限信息
        HashSet<String> permissions = new HashSet<>(16);
        if(roles != null && roles.size() != 0){
            for (String role:roles) {
                permissions.addAll(rolesPermissionsService.selectByRolename(role));
            }
        }
        if(permissions != null){
            for (String permission:permissions) {
                System.out.println("principals = [" + permission + "]");
            }
        }
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用来验证当前登录的用户，获取认证信息。
        String username = (String) token.getPrincipal();
        User user = userService.selectUserByUsername(username);
        if (user == null){
            return null;
        }
        SimpleAuthenticationInfo customerRealm = new SimpleAuthenticationInfo(username, user.getPassword(), "customerRealm");
        return customerRealm;
    }



}
