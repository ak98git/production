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
 * 2019/10/26 1.0          vae          Creation File
 */

package com.top.util;

import lombok.Data;

import java.util.Random;

/**
 * Description:
 * 抛硬币
 * @author Super.vae
 * @date 2019/10/26 13:23
 */
@Data
public class TossingCoin {

    private int front;
    private int reverse;
    private Random random = new Random();

    public void doCoin(int num){
        for(int i = 0; i<num; i++){
            int temp = random.nextInt(2);
            if(0 == temp){
                this.front++;
            }else {
                this.reverse++;
            }

        }
    }

    public static void main(String[] args) {
        TossingCoin tossingCoin = new TossingCoin();
        tossingCoin.doCoin(100);
        System.out.println("正面朝上的次数是："+tossingCoin.getFront()+"；背面朝上的次数是："+tossingCoin.getReverse());

    }

}

