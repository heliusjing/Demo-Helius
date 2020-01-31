package com.helius;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @Author jcf
 * @Create 2020-01-21-11:40
 */
public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        ClassLoader classLoader = Object.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        System.out.println("===========================");
        ClassLoader classLoader1 = DNSNameService.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);
        ClassLoader classLoader2 = ClassLoaderDemo1.class.getClassLoader();
        System.out.println("classLoader2 = " + classLoader2);
        System.out.println("================================================");
        while (classLoader2 != null) {
            System.out.println("classLoader2 = " + classLoader2);
            ClassLoader parent = classLoader2.getParent();
            System.out.println("parent = " + parent);
        }

    }
}
