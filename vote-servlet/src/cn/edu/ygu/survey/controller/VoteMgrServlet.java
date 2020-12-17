package cn.edu.ygu.survey.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ygu.survey.dao.SurveyDao;
import cn.edu.ygu.survey.dao.SurveyDaoJDBCImpl;
import cn.edu.ygu.survey.dao.SurveyLogDao;
import cn.edu.ygu.survey.dao.SurveyLogDaoJDBCImpl;
import cn.edu.ygu.survey.domain.SurveyLog;
import cn.edu.ygu.survey.domain.SurveySubject;

/**
 * Servlet implementation class VoteMgrServlet
 */
@WebServlet("/voteMgr")
public class VoteMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String task = request.getParameter("task");
		
		if("voteMain".equals(task)){
			request.getRequestDispatcher("WEB-INF/jsps/vote/vote_main.jsp").forward(request, response);
		}
		else if("toVotePage".equals(task)){ //voteMgr?task=toVotePage&subjectId=1
			
			int subjectId = Integer.parseInt(request.getParameter("subjectId"));
			
			SurveyDao dao = new SurveyDaoJDBCImpl();
			SurveySubject subject = dao.loadSubject(subjectId);
			
			request.setAttribute("subject", subject);
			
			request.getRequestDispatcher("WEB-INF/jsps/vote/show_vote.jsp").forward(request, response);
			
		}
		else if("createVote".equals(task)){
			
			int itemId = Integer.parseInt(request.getParameter("itemid"));
			int subjectId = Integer.parseInt(request.getParameter("subjectid"));
			
			String ipAddr = request.getRemoteAddr();
			
			System.out.println(itemId+","+subjectId+","+ipAddr);
			
			SurveyDao dao = new SurveyDaoJDBCImpl();
			SurveyLogDao logDao = new SurveyLogDaoJDBCImpl();
			
			//2分钟重复投票检测
			int interval = dao.getVoteInterval(subjectId, ipAddr);
			
			SurveyLog log = new SurveyLog();
			log.setIpaddr(ipAddr);
			log.setItemId(itemId);
							
			dao.addItemTicketCnt(itemId);
			dao.addSubjectTicketCnt(subjectId);
			logDao.addSurveyLog(log);
			
			response.sendRedirect("voteMgr?task=showVoteResult&subjectId="+subjectId);
			
//			if(interval==-1 || interval>=2){
//			
//				SurveyLog log = new SurveyLog();
//				log.setIpaddr(ipAddr);
//				log.setItemId(itemId);
//								
//				dao.addItemTicketCnt(itemId);
//				dao.addSubjectTicketCnt(subjectId);
//				logDao.addSurveyLog(log);
//				
//			}
//			else{
//				System.out.println("不能重复投票，否则报警!");
//				String subjectName = dao.loadSubject(subjectId).getSubjectName();
//				String voteMsg = "您在投票主题["+subjectName+"]已经投过票了，一小时内不能重复投票!";
//				
//				request.setAttribute("voteErr", voteMsg);
//				
//				request.getRequestDispatcher("WEB-INF/jsps/vote/vote_error.jsp").forward(request, response);
//				
//			}
				
		}
		else if("showVoteResult".equals(task)){
			
			int subjectId = Integer.parseInt(request.getParameter("subjectId"));
			
			SurveyDao dao = new SurveyDaoJDBCImpl();
			SurveySubject subject = dao.loadSubject(subjectId);
			
			request.setAttribute("subject", subject);
			
			request.getRequestDispatcher("WEB-INF/jsps/vote/vote_result.jsp").forward(request, response);			
			
			
		}
		else if("showSubjectList".equals(task)){
			
			SurveyDao dao = new SurveyDaoJDBCImpl();
			List<SurveySubject> subjectList = dao.loadAll();
			
			request.setAttribute("subjectList", subjectList);
			
			request.getRequestDispatcher("WEB-INF/jsps/vote/vote_subject_list.jsp").forward(request, response);			
			
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
