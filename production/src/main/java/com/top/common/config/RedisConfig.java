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

import com.top.product.entity.Person;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * Description:
 *
 * @author Super.vae
 * @date 2019/10/18 14:08
 */
// @SpringBootConfiguration
public class RedisConfig {

    /**
     * 修改默认redisTemplate方法
     * 加入对象序列化规则
     * Person对象需要修改
     * @param redisConnectionFactory
     * @return
     * @throws UnknownHostException
     */
   // @Bean
    public RedisTemplate<Object, Person> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Person> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Person> Serializer = new Jackson2JsonRedisSerializer<Person>(Person.class);
        template.setDefaultSerializer(Serializer);
        return template;
    }
}

