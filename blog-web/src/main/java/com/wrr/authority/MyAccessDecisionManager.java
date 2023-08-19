package com.wrr.authority;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

    private boolean supports=true;


    /**
     * 根据请求中的权限信息是否符合约定权限来决定是否通过登录
     * @param authentication
     * @param object
     * @param configAttributes
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        //如果没有需要的权限信息直接放行
        if(configAttributes==null){
            return;
        }

//        if(authentication.isAuthenticated()){
//            throw new AccessDeniedException("权限不足");
//        }

        //获取登录用户的权限信息
        Collection<? extends GrantedAuthority> collection = authentication.getAuthorities();
        for(GrantedAuthority grantedAuthority:collection){
            //用户的角色信息
            String authority=grantedAuthority.getAuthority();
            //获取需要的权限信息
            for(ConfigAttribute configAttribute:configAttributes){
                if(authority.equals(configAttribute.getAttribute())){
                    return;
                }
            }
        }
        throw  new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
