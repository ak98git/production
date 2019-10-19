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
 * 2019/10/18 1.0          vae          Creation File
 */

package com.top.common.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/18 17:09
 */
@SpringBootConfiguration
public class MyAMQPConfig {

    /**
     * JSON数据格式rabbitmq发送消息
     * @return
     */
    @Bean
    public MessageConverter messageContext(){
        return new Jackson2JsonMessageConverter();
    }
}

