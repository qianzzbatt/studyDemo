package com.springbootdemo.study.config;

/**
 * @author huangquan
 * @Description 5.4有新写法，目前还是之前的模式
 * @Date 2022/6/15
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 过滤器
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests:配置路径拦截，表明路径访问所对应的权限，角色，认证信息。源码注释很详细
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .permitAll()
                .and()
                .csrf().disable();
    }

    /**
     * 用户验证管理
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication:定义内存用户
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin").roles("admin");
    }

    @Override
    public void configure(WebSecurity web) {
        //过滤静态文件
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }
}
