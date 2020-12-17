/**
 * 
 */
package cn.edu.ygu.survey.domain;

import java.util.Date;

/**
 * 
 * 操作账户
 * 
 * @author joeyang ong
 *
 */
public class User extends ValueObject {
	
	/** 用户账户  */
	private String userNo;
	private String userName;
	private String userPwd;
	private Date   createTime;
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userName=" + userName + ", userPwd=" + userPwd + ", createTime="
				+ createTime + "]";
	}		
	
	
	
}
