package com.springbootdemo.study.config;

/**
 * @author huangquan
 * @Description 5.4有新写法，目前还是之前的模式
 * @Date 2022/6/15
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfigDemo extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 过滤器
     * @param http
     * @throws Exception
     *
     *         .loginProcessingUrl("/doLogin") 表单提交action
     *         .usernameParameter("name")      表单用户名称设置
     *         .passwordParameter("passwd")
     *         .defaultSuccessUrl("/index")    登陆成功回掉跳转地址
     *         .successForwardUrl("/index")
     *          成功回掉
     *         .successHandler(AuthenticationSuccessHandler 对象)
     *         .successHandler((req, resp, authentication) -> {
     *             Object principal = authentication.getPrincipal();
     *             resp.setContentType("application/json;charset=utf-8");
     *             PrintWriter out = resp.getWriter();
     *             out.write(new ObjectMapper().writeValueAsString(principal));
     *             out.flush();
     *             out.close();
     *         })
     *         失败回掉
     *         .failureHandler((req, resp, e) -> {
     *             resp.setContentType("application/json;charset=utf-8");
     *             PrintWriter out = resp.getWriter();
     *             out.write(e.getMessage());
     *             out.flush();
     *             out.close();
     *         })
     *          未认证处理方案实现AuthenticationEntryPoint接口
     *         .csrf().disable().exceptionHandling()
     *         .authenticationEntryPoint((req, resp, authException) -> {
     *                     resp.setContentType("application/json;charset=utf-8");
     *                     PrintWriter out = resp.getWriter();
     *                     out.write("尚未登录，请先登录");
     *                     out.flush();
     *                     out.close();
     *                 }
     *         );
     *         注销登录
     *         .and()
     * .logout()
     * .logoutUrl("/logout")
     * .logoutSuccessHandler((req, resp, authentication) -> {
     *     resp.setContentType("application/json;charset=utf-8");
     *     PrintWriter out = resp.getWriter();
     *     out.write("注销成功");
     *     out.flush();
     *     out.close();
     * })
     * .permitAll()
     * .and()
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
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
     *
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication:定义内存用户
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin").roles("admin");
    }

    /**
     * 基于内存创建测试用户
     * @return
     */
    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("javaboy").password("123").roles("admin").build());
        manager.createUser(User.withUsername("江南一点雨").password("123").roles("user").build());
        return manager;
    }

    /**
     * 角色继承
     * @return
     */
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return hierarchy;
    }

    @Override
    public void configure(WebSecurity web) {
        //过滤静态文件
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }
}
