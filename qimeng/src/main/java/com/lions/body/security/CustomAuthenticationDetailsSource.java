package com.lions.body.security;

import com.lions.body.web.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 该接口用于在Spring Security登录过程中对用户的登录信息的详细信息进行填充
 * @author jitwxs
 * @since 2018/5/9 11:18
 */
@Component
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {

    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationDetailsSource.class);

    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
        logger.info("进入实现AuthenticationDetailsSource的自定义类，在登陆过程中对用户的详细信息进行填充。");
        return new CustomWebAuthenticationDetails(request);
    }
}
