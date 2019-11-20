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
 * 2019/10/6 1.0          vae          Creation File
 */

package com.top.util;

import lombok.Data;

/**
 * Description:
 *
 * @author vae
 * @date 2019/10/6 14:00
 */
@Data
public class Test {

    private String name;
    private int age;

    static {
        System.out.println("【静态块】执行，为类中static属性初始化作用！【最先执行】只执行一次");
    }

    public Test(){
        System.out.println("-----【构造方法】执行------");
    }

    public Test(String name, int age){
        this(); //构造方法调用
        this.setName(name);
        this.setAge(age);
    }

    public String getInfo(){
        return "我的名字叫"+this.getName()+"；年龄"+this.getAge()+"岁。";
    }

    public static void main(String[] args) {
        Test test = new Test("易烊千玺",25);
        System.out.println(test.getInfo());
    }
}

class TestDemo{

    /**
     * 帮别人买饭功能
     * 方法需要被不断地复用才是优秀的方法
     */
    public String getFan(double money) {

/*        if (money >= 10.0) {
            //则进行买饭操作
            return "返回要带的饭，以及找零：" + (money - 10.0);
        } else {
            return "钱不够买饭";
        }*/

        String msg;
        return msg = money >= 10.0 ? "返回要带的饭，以及找零：" + (money - 10.0) : "钱不够买饭";
    }

    public static void main(String[] args) {
        System.out.println(new TestDemo().getFan(9.0));
    }
}

class Str{

    public static void main(String[] args) {

        String str = "H2lloWorld";
        System.out.println(isNumber(str)? "由数字所组成":"不是数字组成");
        System.out.println(isNumber("1234567")? "由数字组成":"不是数字组成");
        byte[] bytes = str.getBytes();
        char[] chars = str.toCharArray();
        str.equalsIgnoreCase("");
        boolean contains = str.contains("");
        boolean www = str.startsWith("www.");
        boolean com = str.endsWith(".com");
        new StringBuffer(str).replace(2, 5, "****");
        String substring = str.substring(2, 4);
        String[] split = str.split(" ");

        String s = str.substring(0, 1).toUpperCase() + str.substring(1);
        str.substring(str.indexOf("o"),str.lastIndexOf("l"));

    }

    /**
     * 判断字符串是否由数字组成
     * 字符串先转成字符数组
     * 再遍历字符数组，判断字符是否为数字组成
     * 返回boolean值
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
        char[] result = str.toCharArray();
        for(int i = 0; i<result.length; i++){
            if(result[i]<'0' || result[i]>'9'){
                return false;
            }
        }
        return true;
    }
}
