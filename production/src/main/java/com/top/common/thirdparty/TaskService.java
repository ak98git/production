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
 * 2019/10/22 1.0          vae          Creation File
 */

package com.top.common.thirdparty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * 任务
 * @author Super.vae
 * @date 2019/10/22 16:09
 */
@Component
public class TaskService {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    /**
     * 告诉Spring这是一个异步方法；
     * Spring将自己开启一个线程处理
     * 处理任务将会立即响应，不再阻塞
     */
    @Async
    public void async(){

        try {
            TimeUnit.SECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("标注此注解，这是一个异步处理任务，任务处理中。。。");
    }

    /**
     * 定时任务
     * 结算，统计数据
     * 秒，分，时，日，月，周几
     * 表达式总共6位，每位用空格分隔
     */
   // @Scheduled(cron = "0/5 * * * * ?")
    public void settleAccounts(){
        System.out.println("触发定时任务：现在是"+(new Date()));
    }


    /**
     * 发送简单邮件
     */
    public void sendMali(String subject, String text, String recipients, String addresser){

        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知：今晚开会");
        message.setText("今晚10：30开黑！");
        message.setTo("vitas98@163.com");
        message.setFrom("570002519@qq.com");
        javaMailSender.send(message);

    }

    /**
     * 发送复杂邮件
     */
    public void sendEmail(String subject, String text, String recipients, String addresser) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //邮件设置
        helper.setSubject("通知：今晚开会");
        helper.setText("<b style='color:red'>今晚10：30开黑！</b>", true);
        helper.setTo("vitas98@163.com");
        helper.setFrom("570002519@qq.com");
        //附件上传文件
        helper.addAttachment("1.jpg",new File("E:\\img\\1.jpg"));

        javaMailSender.send(message);
    }
}

