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

/**
 * Description:
 * 控制请求访问权限
 * @author Super.vae
 * @date 2019/10/19 14:05
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启登录
        http.formLogin();
        //开启注销,注销成功返回的页面
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //定制认证规则
        //定义一个用户
        auth.inMemoryAuthentication()
                .withUser("root").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("admin").password("123456").roles("VIP2","VIP3");
    }

}

