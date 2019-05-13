package com.lions.body.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/12 21:43
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
           HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功,{}", authentication);

        response.sendRedirect("/");
    }
}
