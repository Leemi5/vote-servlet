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
	
	//����ĳͶƱ��Ʊ��
	void addItemTicketCnt(int itemId);
	//����ĳͶƱ�����Ʊ��
	void addSubjectTicketCnt(int subjectId);
	
	//���ͶƱ���ʱ�䣨���Ϊ-1���������������û��ͶƱ����
	int getVoteInterval(int subjectId, String ipAddr);

}
