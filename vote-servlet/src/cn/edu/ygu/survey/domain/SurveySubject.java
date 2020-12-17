/**
 * 
 */
package cn.edu.ygu.survey.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * ��������
 * 
 * @author joeyang ong
 *
 */
public class SurveySubject extends ValueObject {
	
	 /** ����id��  */
	 private int subjectId;
	 
	 /** �������� */
	 private String subjectName;
	 
	 /** ������Ʊ�� */
	 private int subjectTicketCnt;
	 
	 /** ���ⴴ��ʱ��*/
	 private Date createTime;
	 
	 /** ͶƱ���б�*/
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
