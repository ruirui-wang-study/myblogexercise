package com.wrr.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        if(request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)||request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)){

            if(!request.getMethod().equals("POST")){
                throw new AuthenticationServiceException("Authentication methods not supported:"+request.getMethod());
            }
            Map<String,String> map=new HashMap<>();
            ObjectMapper objectMapper=new ObjectMapper();


            //把request里的数据流转换成map对象
            try(InputStream is=request.getInputStream()){
                map=objectMapper.readValue(is,Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(map!=null){
                String username=map.get("username");
                String password=map.get("password");
                System.out.println(username+password);
                if (username == null) {
                    username = "";
                }
                if (password == null) {
                    password = "";
                }
                username = username.trim();

                //定义token
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

                // Allow subclasses to set the "details" property
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
            return null;
        }
        return null;
    }
}
