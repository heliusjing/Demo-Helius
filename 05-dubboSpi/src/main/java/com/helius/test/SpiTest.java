package com.helius.test;

import com.helius.service.IRepository;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author jcf
 * @Create 2020-01-04-20:34
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<IRepository> serviceLoader = ServiceLoader.load(IRepository.class,Thread.currentThread().getContextClassLoader());
        Iterator<IRepository> it = serviceLoader.iterator();
        while (it != null & it.hasNext()) {
            IRepository iRepository = it.next();
            System.out.println("class" + iRepository.getClass().getName());
            iRepository.save("tom");
        }
    }
}
