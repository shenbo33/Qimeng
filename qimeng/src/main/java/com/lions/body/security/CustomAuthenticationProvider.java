package com.lions.body.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：Shenbo
 * @Description ：
 * @date ：Created in 2019/5/10 19:35
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        logger.info("进入实现AuthenticationProvider");
        // 获取用户输入的用户名和密码
        String inputName = authentication.getName();
        String inputPassword = authentication.getCredentials().toString();
        logger.info("获取到的用户为：{},密码为：{}",inputName,inputPassword);

        CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();

        String verifyCode = details.getVerifyCode();
        if(!validateVerify(verifyCode)) {
            throw new DisabledException("验证码输入错误");
        }

        // userDetails为数据库中查询到的用户信息
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(inputName);

        // 如果是自定义AuthenticationProvider，需要手动密码校验
        if(!userDetails.getPassword().equals(inputPassword)) {
            throw new BadCredentialsException("密码错误");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, inputPassword, userDetails.getAuthorities());
    }

    private boolean validateVerify(String inputVerify) {
        //获取当前线程绑定的request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 不分区大小写
        // 这个validateCode是在servlet中存入session的名字
        String validateCode = ((String) request.getSession().getAttribute("validateCode")).toLowerCase();
        inputVerify = inputVerify.toLowerCase();

        logger.info("验证码：{},用户输入：{}",validateCode ,inputVerify);

        return validateCode.equals(inputVerify);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 这里不要忘记，和UsernamePasswordAuthenticationToken比较
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

