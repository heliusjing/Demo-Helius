package com.helius.java8Api;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 日期时间api测试
 * @Author jcf
 * @Create 2020-01-24-15:27
 */
public class TimeApiTest {
    public static void main(String[] args) {
/*        LocalDate today = LocalDate.now();
        System.out.println("今天的日期：" + today);*/

/*        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Month month1 = today.getMonth();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:"+year);
        System.out.println("month:"+month);
        System.out.println("month1:"+month);
        System.out.println("day:"+day);*/

        LocalDate of = LocalDate.of(2018, 2, 4);
        System.out.println("自定义日期：" + of);
        System.out.println("=====================");
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(3);
        System.out.println("三个小时后的时间为：" + newTime);
    }
}
