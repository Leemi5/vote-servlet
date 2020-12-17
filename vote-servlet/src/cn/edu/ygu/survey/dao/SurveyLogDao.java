/**
 * 
 */
package cn.edu.ygu.survey.dao;

import java.util.List;

import cn.edu.ygu.survey.domain.SurveyLog;

/**
 * @author joeyang ong
 *
 */
public interface SurveyLogDao {
	
	void addSurveyLog(SurveyLog log);
	List<SurveyLog> sbDX();

}
