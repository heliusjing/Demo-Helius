package com.helius.volatileTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author jcf
 * @Create 2020-01-22-14:37
 */
public class reflicetTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获得构造器
        Constructor con = Singleton03.class.getDeclaredConstructor();
        //设置为可访问
        con.setAccessible(true);
        //构造两个不同的对象
        Singleton03 singletonA = (Singleton03) con.newInstance();
        Singleton03 singletonB = (Singleton03) con.newInstance();
        //验证是否是相同对象
        System.out.println(singletonA.equals(singletonB));
    }
}
