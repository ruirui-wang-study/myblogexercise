package com.wrr.handler.auth;

import com.wrr.Result;
import com.wrr.ResultInfo;
import com.wrr.util.JsonUtil;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MySignOutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Result result=Result.success().codeAndMessage(ResultInfo.LOGOUT_SUCCESS).data("authentication",authentication);
        try {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JsonUtil.objectToJson(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
