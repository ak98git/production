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
 * 2019/10/16 1.0          vae          Creation File
 */

package com.top.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Description:
 * 区域语言解析器
 * 在th:href="@{/index.html(l='zh_CN')}"链接上携带上国际化的区域信息
 * @author Super.vae
 * @date 2019/10/16 15:15
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 解析区域信息
     * new Locale(语言代码国家代码);
     * 浏览器参数上没带区域信息就用系统指定的，参数上带了区域信息就用我们指定的区域信息
     * @param httpServletRequest
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

