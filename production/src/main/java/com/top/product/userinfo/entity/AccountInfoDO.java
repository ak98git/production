package com.top.product.userinfo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/14 22:53
 */
@Data
public class AccountInfoDO implements Serializable {
    private Integer id;

    private String accountId;

    private String agentId;

    private Byte accountType;

    private String nickName;

    private String headImg;

    private String userMobile;

    private String realName;

    private String certificateNumb;

    private String parentAccountId;

    private String password;

    private Byte userStatus;

    private Byte authStatus;

    private Byte updateSetting;

    private Integer memberId;

    private Byte memberRoute;

    private Integer userLevel;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private String ancestorAccountIds;

}