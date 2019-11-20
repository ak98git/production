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
 * 2019/10/9 1.0          vae          Creation File
 */

package com.top.util;

/**
 * Description:
 * 单例模式
 * 饿汉模式，懒汉模式
 * @author vae
 * @date 2019/10/9 13:55
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();
    //private static  Singleton instance;

    private Singleton() {}

    public static Singleton getInstance(){
        return INSTANCE;
    }

    /**
     * 懒汉模式
     */
/*    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }*/
    public void print(){
        System.out.println("获得单例模式实例化对象！");
    }
}

class Info{
    public static void main(String[] args) {
        Singleton.getInstance().print();
    }
}

