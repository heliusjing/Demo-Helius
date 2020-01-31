package com.helius.test;

import com.helius.pojo.Student;

import java.io.*;

/**
 * @Author jcf
 * @Create 2020-01-03-21:38
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student("张三", 24);
        Student s2 = new Student("李四", 22);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("record.txt"));
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.close();

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
