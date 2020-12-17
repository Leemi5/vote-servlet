/**
 * 
 */
package cn.edu.ygu.survey.dao;

import java.util.List;

import cn.edu.ygu.survey.domain.User;

/**
 * @author joeyang ong
 *
 */
public interface UserDao {
	
	void createUser(User user);
	List<User> loadUsers();
	User getUserByNo(String userNo);
	void updateUser(User user);
	void delUser(String userNo);

}
