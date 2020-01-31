package com.helius.service.impl;

import com.helius.service.IRepository;

/**
 * @Author jcf
 * @Create 2020-01-04-20:31
 */
public class MongGoRepository implements IRepository {
    @Override
    public void save(String data) {
        System.out.println("Save " + data + "to Mongo");
    }
}
