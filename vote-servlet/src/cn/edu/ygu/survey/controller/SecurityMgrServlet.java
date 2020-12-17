package cn.edu.ygu.survey.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ygu.survey.dao.UserDao;
import cn.edu.ygu.survey.dao.UserDaoJDBCImpl;
import cn.edu.ygu.survey.domain.User;

/**
 * Servlet implementation class SecurityMgrServlet
 */
@WebServlet("/securityMgr")
public class SecurityMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecurityMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String task = request.getParameter("task");
		
		if("toLogin".equals(task)){
			request.getRequestDispatcher("WEB-INF/jsps/login.jsp").forward(request, response);
		}
		else if("login".equals(task)){
			
			String userNo = request.getParameter("userno");
			String userPwd = request.getParameter("userpwd");
			
//			System.out.println(userNo+","+userPwd);
			
			UserDao userDao = new UserDaoJDBCImpl();
			User user = userDao.getUserByNo(userNo);
			
			if(user==null){
				request.setAttribute("errMsg", "用户账户不存在，请检查!");
				request.getRequestDispatcher("WEB-INF/jsps/login.jsp").forward(request, response);
			}
			else if(!user.getUserPwd().equals(userPwd)){
				request.setAttribute("errMsg", "用户存在，但密码不正确，请检查!");
				request.getRequestDispatcher("WEB-INF/jsps/login.jsp").forward(request, response);
			}
			else{
				
				//保存用户到session范围
				request.getSession().setAttribute("loginedUser", user);
				response.sendRedirect("securityMgr?task=main");
				
			}
			
		}
		else if("main".equals(task)){
			
			request.getRequestDispatcher("WEB-INF/jsps/main.jsp").forward(request, response);
			
		}
		else if("logout".equals(task)){
			
			request.getSession().removeAttribute("loginedUser");
			request.getSession().invalidate();
			
			request.getRequestDispatcher("WEB-INF/jsps/login.jsp").forward(request, response);
			
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
