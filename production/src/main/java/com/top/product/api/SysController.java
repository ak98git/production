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

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/14 22:52
 */
@RestController
public class SysController {


    private static final String PREFIX = "pages";
    private static final String PASS_WORD = "123456";


    @PostMapping("doLogin")
    public String doLogin(String name, String pwd,
                          Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(name) && PASS_WORD.equals(pwd)){
            //登录成功
            session.setAttribute("loginUser",name);
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","账户名或密码错误");
            return "login";
        }
    }
}

