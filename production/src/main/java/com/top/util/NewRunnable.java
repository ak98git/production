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
 * project: product
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/9/28 1.0          vae          Creation File
 */

package com.top.util;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author vae
 * @date 2019/9/28 20:31
 */
public class NewRunnable implements Runnable {

    @Override
    public void run() {
        synchronized(this){
            for(int i = 0 ; i<10 ; i++){
                System.out.println(Thread.currentThread().getName()+i);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        new Thread(new NewRunnable()).start();
    }
}

