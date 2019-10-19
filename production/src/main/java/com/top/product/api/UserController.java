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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/14 23:05
 */
@Controller
public class UserController {

//    @Value("${person.userName}")
//    private String userName;

    @ResponseBody
    @RequestMapping("/test/{str}")
    public String getInfo(@PathVariable String str){
        return "会当临绝顶，"+str;
    }

    @RequestMapping("/vae")
    public String vae(Map<String,Object> map){
        map.put("hello","你好");
        map.put("ok","Ojbk!");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "welcome";
    }

    @GetMapping("/level1/{path}")
    public String info(@PathVariable String path){
        return "level1"+path;
    }

}

