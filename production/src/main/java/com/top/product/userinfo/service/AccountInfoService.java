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

package com.top.product.userinfo.service;

import com.top.product.userinfo.entity.AccountInfoDO;

/**
 * Description:
 *
 * @author vae
 * @date 2019/10/14 22:54
 */
public interface AccountInfoService {


    /**
     * 查询
     * @param id
     * @return
     */
    AccountInfoDO findUserById(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    int delUser(Integer id);

    /**
     * 添加
     */
    AccountInfoDO addUser(AccountInfoDO accountInfoDO);
}

