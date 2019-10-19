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
 * 2019/10/15 1.0          vae          Creation File
 */

package com.top.common.config;

import com.top.common.listener.AuthorityInterceptor;
import com.top.utils.MyLocaleResolver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description:
 * 配置类
 * @SpringBootConfiguration注解
 * @author Super.vae
 * @date 2019/10/15 10:06
 */
@SpringBootConfiguration
public class MyAppConfig extends WebMvcConfigurerAdapter {

    /**
     * //浏览器发送什么请求到什么页面
     * //这种配置就避免了写一个空的contrller做跳页面的方法
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("welcome");
    }

    /**
     * 添加配置的拦截器
     * addPathPatterns(要拦截的页面)
     * excludePathPatterns(在过滤里剔除不过滤的页面)
     * Spring Boot已经做好了静态资源映射；不用手动处理；
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorityInterceptor());
                //.addPathPatterns("/**");
                //.excludePathPatterns("/","/welcome.html","/doLogin");
    }
    /**
     * 在配置类添加组件
     * @Bean注解标注在方法上
     * 将方法返回值添加到容器中
     * 容器内组件默认ID为方法名
     * 让容器用这个自定义的区域设置解析器
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }



}

