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
 * 2019/10/24 1.0          vae          Creation File
 */

package com.top.common.constant;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/24 21:47
 */
public enum InsuranceTypeEnum {

    /**
     * 城乡居民基本养老保险
     */
    YANGLAO_CXJM(170, "城乡居民基本养老保险"),
    YANGLAO_CXJM_SD(171, "城乡居民失地保险"),
    YANGLAO_QYZG(110, "城镇职工基本养老保险"),
    YNAGLAO_QYZG_YS(111, "企业职工遗属保险"),
    YANGLAO_JGSY(120, "机关事业单位养老保险"),
    YILIAO_JM(390, "城乡居民基本医疗保险"),
    YILIAO_QYZG(310, "城镇职工基本医疗保险"),
    GONGSHANG_GS(410, "工伤保险");

    public Integer value;
    public String name;

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    private InsuranceTypeEnum(Integer value, String name) {
        this.name = name;
        this.value = value;
    }

    public static String getInsuranceTypeName(Integer value) {
        String name = "";
        switch (value) {
            case 170:
                name = YANGLAO_CXJM.getName();
                break;
            case 110:
                name = YANGLAO_QYZG.getName();
                break;
            case 310:
                name = YILIAO_QYZG.getName();
                break;
            case 390:
                name = YILIAO_JM.getName();
                break;
            default:
                break;
        }
        return name;
    }
}

