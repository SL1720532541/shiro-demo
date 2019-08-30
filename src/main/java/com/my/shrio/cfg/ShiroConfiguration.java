package com.my.shrio.cfg;

import com.my.shrio.dao.RedisSessionDao;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

    @Bean
    public CustomerRealm customRealm() {
        CustomerRealm myRealm = new CustomerRealm();
        myRealm.setAuthenticationCachingEnabled(true);
        return myRealm;
    }

    /**
     * 设置SecurityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        //此处一定是DefaultWebSecurityManager 而不是DefaultSecurityManager，否则会报错
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setSessionManager(sessionManager());
        CustomerRealm customerRealm = customRealm();
        defaultSecurityManager.setRealm(customerRealm);
        return defaultSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403.html");

        //自定义拦截器
       /* Map<String, Filter> filtersMap = new LinkedHashMap<>();
        //限制同一帐号同时在线的个数。
        //filtersMap.put("kickout", kickoutSessionControlFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);*/

        // 权限控制map.过滤器链
        /*Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/*", "authc");*/


        // 配置不会被拦截的链接 顺序判断
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        // 从数据库获取动态的权限
        // filterChainDefinitionMap.put("/add", "perms[权限添加]");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //logout这个拦截器是shiro已经实现好了的。
        // 实际开发中需要从数据库获取
        /*
        List<SysPermissionInit> list = sysPermissionInitService.selectAll();

        for (SysPermissionInit sysPermissionInit : list) {
            filterChainDefinitionMap.put(sysPermissionInit.getUrl(), sysPermissionInit.getPermissionInit());
        }
        */

        //shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public RedisSessionDao redisSessionDAO(){
        RedisSessionDao sessionDAO = new RedisSessionDao();
        return sessionDAO;
    }

    @Bean
    public SessionManager sessionManager(){
        CustomerSessionManager sessionManager = new CustomerSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

}
