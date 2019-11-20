/**
 * Copyright(c) Runsdata Technology Co.,Ltd.
 * All Rights Reserved.
 * <p>
 * This software is the confidential and proprietary information of Runsdata
 * Technology Co.,Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Runsdata Technology Co.,Ltd.
 * For more information about Runsdata, welcome to http://www.runsdata.com
 * <p>
 * project: production
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/10/19 1.0          vae          Creation File
 */

package com.top.common.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Description: Security权限控制配置类
 * 是否登录，是否是会员
 * @author Super.vae
 * @date 2019/10/19 14:05
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * [定义请求授权规则]
     * 控制请求访问权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //authorizeRequests表示要授权请求，antMatchers表示Controller的GetMapping路径
        //permitAll表示允许所有人访问(/public/**     members/**)，hasRole表示只有这些路径只要这个角色才可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level2/**").hasRole("VIP");
        //开启登录功能(/userLogin为自定义登录页)
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userLogin");
        //logout()开启自动配置的注销功能,退出清空Session；logoutSuccessUrl注销成功需要返回的GetMapping地址
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能，cookie
        http.rememberMe().rememberMeParameter("remember");
    }

    /**
     * [定义认证规则]
     * 给用户角色分配访问权限
     * 新版Security，
     * 需要在configure方法里面指定，对前端传过来的密码进行了加密处理
     * 对取得的密码进行Bcrypt编码加密。比对时一致，允许登录。
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //withUser()定义一个用户(inMemoryAuthentication在内存里查用户，正规应选用jdbcAuthentication()在数据库查用户)
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP")
                .and()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP");
    }

}