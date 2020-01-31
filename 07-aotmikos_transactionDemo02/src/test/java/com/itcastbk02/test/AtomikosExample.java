package com.itcastbk02.test;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
 
public class AtomikosExample {
 
   private static AtomikosDataSourceBean createAtomikosDataSourceBean(String dbName) {
      // 连接池基本属性
      Properties p = new Properties();
      p.setProperty("url", "jdbc:mysql://localhost:3306/" + dbName);
      p.setProperty("user", "root");
      p.setProperty("password", "admin");
 
      // 使用AtomikosDataSourceBean封装com.mysql.jdbc.jdbc2.optional.MysqlXADataSource
      AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
      //atomikos要求为每个AtomikosDataSourceBean名称，为了方便记忆，这里设置为和dbName相同
      ds.setUniqueResourceName(dbName);
      ds.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
      ds.setXaProperties(p);
      return ds;
   }
 
   public static void main(String[] args) {
 
      AtomikosDataSourceBean ds1 = createAtomikosDataSourceBean("order");
      AtomikosDataSourceBean ds2 = createAtomikosDataSourceBean("log");
 
      Connection conn1 = null;
      Connection conn2 = null;
      PreparedStatement ps1 = null;
      PreparedStatement ps2 = null;
 
      UserTransaction userTransaction = new UserTransactionImp();
      try {
         // 开启事务
         userTransaction.begin();
         // INSERT into order(money,createTime) values(?,?)
         // 执行db1上的sql
         conn1 = ds1.getConnection();
         ps1 = conn1.prepareStatement("INSERT into order_info(money,createTime) values(?,?)", Statement.RETURN_GENERATED_KEYS);
         ps1.setDouble(1, 300);
         ps1.setTimestamp(2, new Timestamp(new Date().getTime()));
         ps1.executeUpdate();
         ResultSet generatedKeys = ps1.getGeneratedKeys();
         int userId = -1;
         while (generatedKeys.next()) {
            userId = generatedKeys.getInt(1);// 获得自动生成的userId
         }

         // 执行db2上的sql
         conn2 = ds2.getConnection();
         ps2 = conn2.prepareStatement("INSERT into log_info(createTime,content) VALUES (?,?)");
         ps2.setTimestamp(1, new Timestamp(new Date().getTime()));
         ps2.setString(2,"这是一条日志3");
         ps2.executeUpdate();
         // 模拟异常 ，直接进入catch代码块，2个都不会提交
         int i=1/0;
         // 两阶段提交
         userTransaction.commit();
      } catch (Exception e) {
         try {
            e.printStackTrace();
            userTransaction.rollback();
         } catch (SystemException e1) {
            e1.printStackTrace();
         }
      } finally {
         try {
            ps1.close();
            ps2.close();
            conn1.close();
            conn2.close();
            ds1.close();
            ds2.close();
         } catch (Exception ignore) {
         }
      }
   }
}