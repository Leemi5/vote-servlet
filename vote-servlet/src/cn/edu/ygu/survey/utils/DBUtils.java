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
 * ���ݿ⹤���ࣨ������Ҫ�����������Ӻ��ͷ���Դ)
 * 
 * @author joeyang ong
 *
 */
public class DBUtils {
	
	//���ݿ⹹����������Ҫ����Ϣ
	private static final String CONN_STR="jdbc:mysql://localhost:3306/yg_db?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
	private static final String USER = "slm";
	private static final String PWD = "slm";
	
	/**
	 * �������
	 * @return
	 */
	public static Connection getConn(){
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //����·����ȥ��֤���JAVA���Ƿ����
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
	 * �ͷ���Դ
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
