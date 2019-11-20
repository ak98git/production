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
 * 2019/11/5 1.0          vae          Creation File
 */

package com.top.product.userinfo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.top.util.DateUtility;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/11/5 21:40
 */
@Data
public class UserRegisterInfo {

    private Long id;
    private String idNumber;  //身份证号码
    private String idNumberEnc;  //加密后身份证号码
    private String userName;  //姓名
    private String userPhone;  //电话号码
    private String userPhoneEnc;//加密后电话号码
    private String userSex;  //性别
    private String userPwd;  //密码
    private String secureCredential; //加密后的密码
    private String ylzToken; //易联众的token    //数据来自第三方
    @JsonFormat(pattern= DateUtility.FULL_DATE_TIME_FORMAT)
    private LocalDateTime registerTime;  //注册时间
    private Integer tokenVersion;
    private String isRegister;
    private String oldToken;
    private Integer[] businessType;//业务类型
    @NotBlank(message = "请选择省")
    private String censusProvince; //参保省份
    @NotBlank(message = "请选择市")
    private String censusCity; //参保地市
}

