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

package com.top.product.userinfo.service.impl;

import com.top.product.userinfo.dao.AccountInfoDOMapper;
import com.top.product.userinfo.entity.AccountInfoDO;
import com.top.product.userinfo.service.AccountInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author vae
 * @date 2019/10/14 22:55
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    @Resource
    private AccountInfoDOMapper mapper;

    @Override
    public AccountInfoDO findUserById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int delUser(Integer id) {
        return 0;
    }

    @Override
    public AccountInfoDO addUser(AccountInfoDO accountInfoDO) {
        return null;
    }
}

