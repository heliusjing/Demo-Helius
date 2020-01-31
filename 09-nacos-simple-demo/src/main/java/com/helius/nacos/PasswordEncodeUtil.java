package com.helius.nacos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author jcf
 * @Create 2020-01-15-19:17
 */
public class PasswordEncodeUtil {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123");
        System.out.println("encode = " + encode);
    }
}
