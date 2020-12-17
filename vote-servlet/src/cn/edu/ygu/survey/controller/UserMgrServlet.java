package cn.edu.ygu.survey.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ygu.survey.dao.UserDao;
import cn.edu.ygu.survey.dao.UserDaoJDBCImpl;
import cn.edu.ygu.survey.domain.User;

/**
 * Servlet implementation class UserMgrServlet
 */
@WebServlet("/userMgr")
public class UserMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String task = request.getParameter("task");
		
		if("toInput".equals(task))
		   request.getRequestDispatcher("WEB-INF/jsps/user/input_user.jsp").forward(request, response);
		else if("createUser".equals(task)){
			
			String userNo = request.getParameter("userno");
			String userName = request.getParameter("username");
			String userPwd = request.getParameter("userpwd");
			
			User user = new User();
			user.setUserNo(userNo);
			user.setUserName(userName);
			user.setUserPwd(userPwd);
			user.setCreateTime(new Date());
			
			System.out.println(user);
			
			UserDao userDao = new UserDaoJDBCImpl();
			userDao.createUser(user);
			
			response.sendRedirect("userMgr?task=loadUsers");
			
		}
		else if("loadUsers".equals(task)){
			
			UserDao userDao = new UserDaoJDBCImpl();
			List<User> userList = userDao.loadUsers();

			request.setAttribute("userList", userList);
			 request.getRequestDispatcher("WEB-INF/jsps/user/list_user.jsp").forward(request, response);
			
		}
        else if("preUpdateUser".equals(task)){ //userMgr?task=preUpdateUser&userno=000101
			
        	String userNo = request.getParameter("userno");
        	
			UserDao userDao = new UserDaoJDBCImpl();
			User user = userDao.getUserByNo(userNo);
			
			System.out.println(user);
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/jsps/user/update_user.jsp").forward(request, response);
			
		}
		else if("updateUser".equals(task)){
			
			String userNo = request.getParameter("userno");
			String userName = request.getParameter("username");
			String originPwd = request.getParameter("orginpwd");
			String newPwd = request.getParameter("newpwd");
			
//			if(!originPwd.equals(newPwd)) return;
			
			
			User user = new User();
			user.setUserNo(userNo);
			user.setUserName(userName);
			user.setUserPwd(newPwd);
			
			UserDao userDao = new UserDaoJDBCImpl();
			userDao.updateUser(user);
			
			response.sendRedirect("userMgr?task=loadUsers");
			
		}	
		else if("removeUser".equals(task)){ //userMgr?task=removeUser&userno=000101
			
        	String userNo = request.getParameter("userno");
        	
			UserDao userDao = new UserDaoJDBCImpl();
			userDao.delUser(userNo);
			
			response.sendRedirect("userMgr?task=loadUsers");
			
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
