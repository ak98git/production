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

package com.top.product.dao;

import com.top.product.entity.Person;
import org.apache.ibatis.annotations.Select;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/15 22:53
 */
public interface BusinessDOMapper {

    @Select("select * from person where id=#{id}")
    public Person getPerson(Long id);
}

