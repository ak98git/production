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
 * 2019/10/14 1.0          vae          Creation File
 */

package com.top.product.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * Description:
 * 测试类，控制页面跳转作用
 * @author Super.vae
 * @date 2019/10/14 23:05
 */
@Controller
public class UserController {

    private static final String PREFIX = "pages/";

    @RequestMapping("/")
    public String vae(Map<String,Object> map){
        map.put("hello","你好");
        map.put("ok","Hello World!");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "welcome";
    }

    /**
     * 登录页
     */
    @RequestMapping("/userLogin")
    public String doLogin(){
        return PREFIX+"login";
    }

    /**
     * level1页面映射
     * @param path
     * @return
     */
    @RequestMapping("/level1/{path}")
    public String info1(@PathVariable("path") String path){
        return PREFIX+"level1/"+path;
    }

    /**
     * level2页面映射
     * @param path
     * @return
     */
    @RequestMapping("/level2/{path}")
    public String info2(@PathVariable("path") String path){
        return PREFIX+"level2/"+path;
    }

}

