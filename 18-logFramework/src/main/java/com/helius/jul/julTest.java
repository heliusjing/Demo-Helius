package com.helius.jul;


import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author jcf
 * @Create 2020-01-26-17:44
 */
public class julTest {
    //快速入门
    @Test
    public void testQuick() {
        //1.获取日志记录对象
        Logger logger = Logger.getLogger("com.helius.jul.julTest");
        //2.日志记录输出
        logger.info("hello jul");
        logger.log(Level.INFO,"info msg");
        String name = "helius";
        Integer age = 13;
        logger.log(Level.INFO,"用户信息：{0}，{1}",new Object[]{name,age});
    }

    @Test
    public void testLogLevel() throws Exception{
        Logger logger = Logger.getLogger("com.helius.jul.julTest");
        //jul默认的日志级别
    }


}
