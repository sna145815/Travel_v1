package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	
	public static Connection getConnection()
	{
		try{
			 String jdbcUrl = "jdbc:mysql://localhost:3306/travel?useUnicode=true&characterEncoding=utf8";
		     String dbId = "root";
		     String dbPass = "1128";
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection(jdbcUrl,dbId ,dbPass);
			 return con;
		  }catch(Exception e){ 
			 e.printStackTrace();
		  }
		return null;
	}

	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs)
	{
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn,PreparedStatement pstmt)
	{
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
}
