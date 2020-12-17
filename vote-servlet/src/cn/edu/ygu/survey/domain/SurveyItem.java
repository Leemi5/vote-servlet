/**
 * 
 */
package cn.edu.ygu.survey.domain;

import java.util.Date;

/**
 * 
 * 调研主题下属的项目
 * 
 * @author joeyang ong
 *
 */
public class SurveyItem extends ValueObject {
	
	private int itemId;
	private String itemContent;
	private int itemTicketCnt;
	private Date createTime;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public int getItemTicketCnt() {
		return itemTicketCnt;
	}
	public void setItemTicketCnt(int itemTicketCnt) {
		this.itemTicketCnt = itemTicketCnt;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "SurveyItem [itemId=" + itemId + ", itemContent=" + itemContent + ", itemTicketCnt=" + itemTicketCnt
				+ ", createTime=" + createTime + "]";
	}
	
	

}
