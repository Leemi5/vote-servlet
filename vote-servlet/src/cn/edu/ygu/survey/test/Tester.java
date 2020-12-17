/**
 * 
 */
package cn.edu.ygu.survey.test;

import java.util.List;

import cn.edu.ygu.survey.dao.SurveyDao;

import cn.edu.ygu.survey.dao.SurveyDaoJDBCImpl;
import cn.edu.ygu.survey.dao.SurveyLogDao;
import cn.edu.ygu.survey.dao.SurveyLogDaoJDBCImpl;
import cn.edu.ygu.survey.domain.SurveyLog;

/**
 * @author joeyang ong
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
//		System.out.println(dao.loadAll());
//		System.out.println(dao.loadSubject(12));
		SurveyLogDao surveyLogDao = new SurveyLogDaoJDBCImpl();
		List<SurveyLog> loglist = surveyLogDao.sbDX();
		for(SurveyLog log:loglist)
			System.out.println(loglist);
		

	}

}
