/**
 * 
 */
package cn.edu.ygu.survey.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 数据库工具类（本类主要用来构建连接和释放资源)
 * 
 * @author joeyang ong
 *
 */
public class DBUtils {
	
	//数据库构建连接所需要的信息
	private static final String CONN_STR="jdbc:mysql://localhost:3306/yg_db?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
	private static final String USER = "slm";
	private static final String PWD = "slm";
	
	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConn(){
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //在类路径中去查证这个JAVA类是否存在
			conn = DriverManager.getConnection(CONN_STR, USER, PWD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return conn;
		
	}
	
	
	/**
	 * 释放资源
	 */
	public static void releaseRes(Connection conn, PreparedStatement pstmt, ResultSet rset){
		
		try {
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
