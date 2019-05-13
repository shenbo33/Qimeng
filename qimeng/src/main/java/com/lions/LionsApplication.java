package com.lions;

import com.lions.body.servlet.VerifyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class LionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LionsApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean<VerifyServlet> indexServletRegistration() {
        ServletRegistrationBean<VerifyServlet> registration = new ServletRegistrationBean<>(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }
}
