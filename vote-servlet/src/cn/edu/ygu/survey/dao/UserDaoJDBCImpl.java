/**
 * 
 */
package cn.edu.ygu.survey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.ygu.survey.domain.User;
import cn.edu.ygu.survey.utils.DBUtils;

/**
 * @author joeyang ong
 *
 */
public class UserDaoJDBCImpl implements UserDao {
	
	private static final String SQL_ADD="insert into tbl_user values(?,?,?,?)";
	private static final String SQL_LOAD_ALL = "select * from tbl_user";
	private static final String SQL_LOAD_BYNO = "select * from tbl_user where user_no=?";
	private static final String SQL_UPDATE =
			"update tbl_user set user_pwd=?,user_name=? where user_no=?";
	private static final String SQL_DEL = "delete from tbl_user where user_no=?";

	@Override
	public void createUser(User user) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_ADD);
			pstmt.setString(1, user.getUserNo());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPwd());
			pstmt.setTimestamp(4, new java.sql.Timestamp(user.getCreateTime().getTime())); //时间的本质是一个长整数，是1970-1-1到现在所经过的毫秒数
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);				
		}		
		
	}

	@Override
	public List<User> loadUsers() {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<User> userList = new ArrayList<>();
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_ALL);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				User user = new User();
				user.setUserNo(rset.getString("user_no"));
				user.setUserName(rset.getString("user_name"));
				user.setUserPwd(rset.getString("user_pwd"));
				user.setCreateTime(new Date(rset.getTimestamp("create_time").getTime()));
	            userList.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);				
		}		
		
		return userList;
	}

	@Override
	public User getUserByNo(String userNo) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User user = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_BYNO);
			pstmt.setString(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				user = new User();
				user.setUserNo(rset.getString("user_no"));
				user.setUserName(rset.getString("user_name"));
				user.setUserPwd(rset.getString("user_pwd"));
				user.setCreateTime(new Date(rset.getTimestamp("create_time").getTime()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);				
		}	
		
		return user;
	}

	@Override
	public void updateUser(User user) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, user.getUserPwd());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserNo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);				
		}			
		
	}

	@Override
	public void delUser(String userNo) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_DEL);
			pstmt.setString(1, userNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);				
		}			
		
	}

}
