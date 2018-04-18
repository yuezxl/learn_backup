package com.test;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MysqlTest {
	public static void main(String[] args){
		 String driver = "com.mysql.jdbc.Driver";
		 String url = "jdbc:mysql://127.0.0.1:3306/test";
		 String user = "root"; 

         // MySQL配置时的密码
         String password = "root";
      // 连续数据�?
         try {
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()) 
	             System.out.println("Succeeded connecting to the Database!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
