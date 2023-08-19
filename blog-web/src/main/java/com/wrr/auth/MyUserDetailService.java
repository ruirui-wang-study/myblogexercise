package com.wrr.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wrr.api.IUserService;
import com.wrr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailService implements UserDetailsService {


    @Autowired
    private IUserService userService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",username);
        User user=userService.getOne(wrapper);
        if(user==null){
            throw new UsernameNotFoundException("没有该用户");
        }

        MyUserDetail userDetail=new MyUserDetail();
        userDetail.setUser(user);
        userDetail.setUsername(user.getUsername());
        userDetail.setPassword("{noop}"+user.getPassword());

        System.out.println(user.toString());
        //获取用户角色
        List<String> roles=userService.getRoleByUserid(user.getId());


        if(roles.size()>0){
            Set<GrantedAuthority> authorities=new HashSet<>();
            SimpleGrantedAuthority authority;
            for(String role:roles){
                authority=new SimpleGrantedAuthority(role);
                authorities.add(authority);
            }
            userDetail.setAuthorities(authorities);
        }
        return userDetail;
    }
}
