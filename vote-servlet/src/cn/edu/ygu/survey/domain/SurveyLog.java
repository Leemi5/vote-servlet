/**
 * 
 */
package cn.edu.ygu.survey.domain;

import java.util.Date;

/**
 * 
 * 调研日志
 * 
 * @author joeyang ong
 *
 */
public class SurveyLog extends ValueObject {
	
	private int logId;
	private int itemId;
	private String ipaddr;
	private Date creatTime;
	private String subjectName;
    private int subjectTicketCnt;
    private String itemName;
    private int itemTicketCnt;
    private int subjcetId;
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemTicketCnt() {
		return itemTicketCnt;
	}
	public void setItemTicketCnt(int itemTicketCnt) {
		this.itemTicketCnt = itemTicketCnt;
	}
	public int getSubjcetId() {
		return subjcetId;
	}
	public void setSubjcetId(int subjcetId) {
		this.subjcetId = subjcetId;
	}
	@Override
	public String toString() {
		return "SurveyLog [logId=" + logId + ", itemId=" + itemId + ", ipaddr=" + ipaddr + ", creatTime=" + creatTime
				+ ", subjectName=" + subjectName + ", subjectTicketCnt=" + subjectTicketCnt + ", itemName=" + itemName
				+ ", itemTicketCnt=" + itemTicketCnt + ", subjcetId=" + subjcetId + "]";
	}
	


}
	
	

