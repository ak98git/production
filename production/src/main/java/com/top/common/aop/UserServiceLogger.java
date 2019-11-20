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
 * 2019/11/3 1.0          vae          Creation File
 */

package com.top.common.aop;

import com.top.util.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/11/3 21:33
 */
@Aspect
public class UserServiceLogger {

    /**
     * 定义切点
     */
    @Pointcut("execution(* com.top.product.userinfo.service..*.*(..))")
    public void pointcut() {}

    /**
     * 前置增强
     * @param jp
     */
    @Before("pointcut()")
    public void before(JoinPoint jp) {
        LogUtil.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法入参：" + Arrays.toString(jp.getArgs()));
    }

    /**
     * 后置增强
     * @param jp
     * @param result
     */
    @AfterReturning(pointcut="pointcut()",returning="result")
    public void afterReturning(JoinPoint jp, Object result) {
        LogUtil.info("调用 " + jp.getTarget() + " 的 " + jp.getSignature().getName() + " 方法。方法返回值：" + result);
    }

    @AfterThrowing(pointcut="pointcut()",throwing="e")
    public void afterThrow(JoinPoint jp, Exception e) {
        LogUtil.info(jp.getSignature().getName() + " 方法发生异常: " + e);
    }

    @After("pointcut()")
    public void after(JoinPoint jp) {
        LogUtil.info(jp.getSignature().getName() + " 方法运行结束。");
    }

    /**
     * 环绕通知需要将切入点方法的返回值进行返回
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable{
        try {
            long begin = System.currentTimeMillis();
            //执行切入点的方法,并拿到返回值值
            Object result = jp.proceed();
            long end = System.currentTimeMillis();
            LogUtil.info("执行时间是" + (end-begin) +"毫秒" );
            //返回结果
            return result;
        } catch (Throwable e) {
            LogUtil.info("==>" + jp.getSignature().getName() + " 方法发生异常：" + e);
            throw e;
        } finally {
            LogUtil.info("==>" + jp.getSignature().getName() + " 方法结束执行。");
        }
    }
}

