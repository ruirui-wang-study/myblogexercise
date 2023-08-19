package com.wrr.handler.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wrr.Result;
import com.wrr.ResultInfo;
import com.wrr.auth.MyUserDetail;
import com.wrr.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ObjectMapper objectMapper=new ObjectMapper();
        Object principle=authentication.getPrincipal();

        if(principle instanceof UserDetails){
            MyUserDetail userDetails=(MyUserDetail) principle;
            User user=userDetails.getUser();
            List<String> roles=new ArrayList<>();
            for(GrantedAuthority role:userDetails.getAuthorities()){
                roles.add(role.getAuthority());
            }
            response.getWriter().write(objectMapper.writeValueAsString(
                    Result.success().codeAndMessage(ResultInfo.LOGIN_SUCCESS)
                            .data("user",user)
                            .data("roles",roles))
                    );
        }

    }
}
