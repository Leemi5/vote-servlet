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
import cn.edu.ygu.survey.domain.SurveyItem;
import cn.edu.ygu.survey.domain.SurveyLog;
import cn.edu.ygu.survey.domain.SurveySubject;

/**
 * Servlet implementation class SurveyMgrServlet
 */
@WebServlet("/surveyMgr")
public class SurveyMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String task = request.getParameter("task");
		
		if("toInput".equals(task)){
			request.getRequestDispatcher("WEB-INF/jsps/survey/input_survey.jsp").forward(request, response);
		}
		else if("createSurvey".equals(task)){
			
			SurveySubject subject = new SurveySubject();
			
			//获得投票主题的名称
			String subjectName = request.getParameter("subjectname");
			subject.setSubjectName(subjectName);
			
			String[] contentList = request.getParameterValues("itemcontent");
			
			for(String content:contentList){
				
				SurveyItem item = new SurveyItem();
				item.setItemContent(content);		
				subject.getItems().add(item);
				
			}
			
			System.out.println(subject);
			
			//保存主题以及附属投票项进入数据库
			SurveyDao surveyDao = new SurveyDaoJDBCImpl();
			surveyDao.addSurvey(subject);
			
			response.sendRedirect("surveyMgr?task=loadSubjects");
					
		}
		else if("loadSubjects".equals(task)){
			
			SurveyDao surveyDao = new SurveyDaoJDBCImpl();
			List<SurveySubject> subjectList = surveyDao.loadAll();
			
			request.setAttribute("subjectList", subjectList);		
			request.getRequestDispatcher("WEB-INF/jsps/survey/list_survey.jsp").forward(request, response);
			
		}
		else if("removeSubject".equals(task)){
			
			int subjectId = Integer.parseInt(request.getParameter("subjectid"));
			
			SurveyDao surveyDao = new SurveyDaoJDBCImpl();
			surveyDao.removeSubject(subjectId);
			
			response.sendRedirect("surveyMgr?task=loadSubjects");		
			
		}
		else if ("showLog".equals(task)){

            SurveyLogDao surveyLogDao = new SurveyLogDaoJDBCImpl();
            List<SurveyLog> logList = surveyLogDao.sbDX();

            request.setAttribute("logList",logList);
            System.out.println(logList);
            request.getRequestDispatcher("WEB-INF/jsps/survey/list_survey_log.jsp").forward(request, response);
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
