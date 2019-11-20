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

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.net.UnknownHostException;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/18 14:08
 */
@SpringBootConfiguration
public class RedisConfiguration {

    /**
     * 修改默认redisTemplate方法
     * 改变RedisTemplate默认序列化规则
     * @param redisConnectionFactory
     * @return LettuceConnectionFactory redisConnectionFactory
     * @throws UnknownHostException
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {

        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }
}