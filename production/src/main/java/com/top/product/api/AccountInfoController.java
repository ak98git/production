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
 * 2019/10/22 1.0          vae          Creation File
 */

package com.top.product.api;

import com.top.product.userinfo.entity.AccountInfoDO;
import com.top.product.userinfo.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/22 13:01
 */
@RestController
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping("/user/{id}")
    public AccountInfoDO findUserById(@PathVariable Integer id){
        return accountInfoService.findUserById(id);
    }
}

