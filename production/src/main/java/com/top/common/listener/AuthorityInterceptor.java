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

package com.top.common.listener;

import com.top.utils.LogUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * 登录检查
 * @author vae
 * @date 2019/10/14 22:47
 */
// @Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
            if(null == user){
                //未登录,拦截返回登录页
                response.sendRedirect(request.getContextPath()+"welcome.html");
                LogUtil.info("未获取到当前Session对象，拦截返回登录页。");
                return false;
            }else {
                //已登录
                return true;
            }
    }
}