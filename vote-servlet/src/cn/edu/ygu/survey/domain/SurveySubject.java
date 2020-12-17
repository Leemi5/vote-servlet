/**
 * 
 */
package cn.edu.ygu.survey.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 调研主题
 * 
 * @author joeyang ong
 *
 */
public class SurveySubject extends ValueObject {
	
	 /** 主题id号  */
	 private int subjectId;
	 
	 /** 主题名称 */
	 private String subjectName;
	 
	 /** 主题总票数 */
	 private int subjectTicketCnt;
	 
	 /** 主题创建时间*/
	 private Date createTime;
	 
	 /** 投票项列表*/
	 private List<SurveyItem>  items = new ArrayList<SurveyItem>();

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectTicketCnt() {
		return subjectTicketCnt;
	}

	public void setSubjectTicketCnt(int subjectTicketCnt) {
		this.subjectTicketCnt = subjectTicketCnt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<SurveyItem> getItems() {
		return items;
	}

	public void setItems(List<SurveyItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "SurveySubject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectTicketCnt="
				+ subjectTicketCnt + ", createTime=" + createTime + ", items=" + items + "]";
	}
	
	
	 	 

}
