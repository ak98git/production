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

package com.top.product.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author vae
 * @date 2019/10/14 22:53
 */
//@Component
//@ConfigurationProperties(prefix = "person")
//@Validated
//@Data
public class Person implements Serializable {

    private String userName;
    // @NotBlank(message = "年龄不能为非数字")
    private Integer age;
    private Date birth;
}

