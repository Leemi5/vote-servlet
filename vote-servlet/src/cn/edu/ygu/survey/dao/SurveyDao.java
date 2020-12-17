/**
 * 
 */
package cn.edu.ygu.survey.dao;

import java.util.List;

import cn.edu.ygu.survey.domain.SurveySubject;

/**
 * @author joeyang ong
 *
 */
public interface SurveyDao {
	
	void addSurvey(SurveySubject subject);
	List<SurveySubject> loadAll();
	SurveySubject loadSubject(int subjectId);
	void removeItem(int itemId);
	void removeSubject(int subjectId);
	
	//增加某投票项票数
	void addItemTicketCnt(int itemId);
	//增加某投票主题的票数
	void addSubjectTicketCnt(int subjectId);
	
	//获得投票间隔时间（如果为-1，则代表对这个主题没有投票过）
	int getVoteInterval(int subjectId, String ipAddr);

}
