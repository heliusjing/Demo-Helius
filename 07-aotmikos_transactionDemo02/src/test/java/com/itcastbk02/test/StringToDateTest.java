package com.itcastbk02.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author jcf
 * @Create 2020-01-05-16:07
 */
public class StringToDateTest {
    @Test
    public void test() throws ParseException {
        String stringDate = "201903091415";
        Date date = new SimpleDateFormat("yyyyMMddhhmm").parse("201903091415");
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        System.out.println(now);

    }
}
