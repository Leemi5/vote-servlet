/**
 * 
 */
package cn.edu.ygu.survey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.ygu.survey.domain.SurveyItem;
import cn.edu.ygu.survey.domain.SurveySubject;
import cn.edu.ygu.survey.utils.DBUtils;

/**
 * @author joeyang ong
 *
 */
public class SurveyDaoJDBCImpl implements SurveyDao {
	
	private static final String SQL_ADD_SUBJECT
	   = "insert into tbl_survey_subject(subject_name) values(?)";
	private static final String SQL_ADD_SUBITEM
	   = "insert into tbl_survey_item(item_content,subject_id) values(?,?)";
	private static final String SQL_LOAD_ALL_SUBJECT
	   = "select * from tbl_survey_subject order by subject_id desc";
	private static final String SQL_LOAD_ALL_SUBITEMS
	   = "select * from tbl_survey_item where subject_id=? order by item_id";
	private static final String SQL_LOAD_SUBJECT_BYID
	   = "select * from tbl_survey_subject where subject_id=?";
	private static final String SQL_REMOVE_ITEM
	   = "delete from tbl_survey_item where item_id=?";
	private static final String SQL_REMOVE_SUBJECT
	   = "delete from tbl_survey_subject where subject_id=?";
	private static final String SQL_INC_ITEM_TICKET_CNT
	   =" update tbl_survey_item set item_ticket_cnt=item_ticket_cnt+1 where item_id=? ";
	private static final String SQL_INC_SUBJECT_TICKET_CNT
	   =" update tbl_survey_subject set subject_ticket_cnt=subject_ticket_cnt+1 where subject_id=? ";
	private static final String SQL_GET_VOTE_INTERVAL
	   = "select  TIMESTAMPDIFF(MINUTE,c.create_time,now()) vote_interval "+
		 "from tbl_survey_subject a,tbl_survey_item b,tbl_survey_log c "+
	     "where a.subject_id=b.subject_id and a.subject_id=? and b.item_id=c.item_id and c.ip_addr=? order by c.create_time desc "+
	     "limit 0,1";
	

	/* (non-Javadoc)
	 * @see cn.edu.ygu.survey.dao.SurveyDao#addSurvey(cn.edu.ygu.survey.domain.SurveySubject)
	 */
	@Override
	public void addSurvey(SurveySubject subject) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		int subjectId=-1;
		
		try {
			
			//1.保存主题并获得当前主题的id
			pstmt = conn.prepareStatement(SQL_ADD_SUBJECT,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, subject.getSubjectName());
			pstmt.executeUpdate();
			rset = pstmt.getGeneratedKeys();
			if(rset.next()) {
		       subjectId = rset.getInt(1);
		       System.out.print("获取自动增加的id号=="+subjectId+"\n");
		    }
			pstmt.close();
			
			//2.保存投票项目，配合主题id做外键关联
			for(SurveyItem item:subject.getItems()){
				pstmt=conn.prepareStatement(SQL_ADD_SUBITEM);
				pstmt.setString(1, item.getItemContent());
				pstmt.setInt(2, subjectId);
				pstmt.executeUpdate();
				pstmt.close();
			}
			
			System.out.println("subject is saved ok!");
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
	 
		

	}

	@Override
	public List<SurveySubject> loadAll() {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		List<SurveySubject> subjectList = new ArrayList<>();
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_ALL_SUBJECT);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
		       SurveySubject subject = new SurveySubject();
		       subject.setSubjectId(rset.getInt("subject_id"));
		       subject.setSubjectName(rset.getString("subject_name"));
		       subject.setSubjectTicketCnt(rset.getInt("subject_ticket_cnt"));
		       subject.setCreateTime(new Date(rset.getTimestamp("create_time").getTime()));
		       subject.setItems(this.loadItems(rset.getInt("subject_id")));
		       subjectList.add(subject);
		    }
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}	
		
		return subjectList;
		
	}
	
	public List<SurveyItem> loadItems(int subjectId){
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		List<SurveyItem> itemList = new ArrayList<>();
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_ALL_SUBITEMS);
			pstmt.setInt(1, subjectId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			   SurveyItem item = new SurveyItem();
			   
			   item.setItemId(rset.getInt("item_id"));
			   item.setItemContent(rset.getString("item_content"));
			   item.setItemTicketCnt(rset.getInt("item_ticket_cnt"));
			   item.setCreateTime(new Date(rset.getTimestamp("create_time").getTime()));
			   
		       itemList.add(item);
		    }
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
		
		return itemList;
		
	}

	@Override
	public SurveySubject loadSubject(int subjectId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		SurveySubject subject = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_LOAD_SUBJECT_BYID);
			pstmt.setInt(1, subjectId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
		       subject = new SurveySubject();
		       subject.setSubjectId(rset.getInt("subject_id"));
		       subject.setSubjectName(rset.getString("subject_name"));
		       subject.setSubjectTicketCnt(rset.getInt("subject_ticket_cnt"));
		       subject.setCreateTime(new Date(rset.getTimestamp("create_time").getTime()));
		       subject.setItems(this.loadItems(rset.getInt("subject_id")));
		    }
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}	
		
		return subject;
	}

	@Override
	public void removeItem(int itemId) {
		
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_REMOVE_ITEM);
			pstmt.setInt(1, itemId);
			pstmt.executeUpdate();
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}		
		
	}

	@Override
	public void removeSubject(int subjectId) {
		
		//先删除属于这个subject的所有item
		List<SurveyItem> itemList = this.loadSubject(subjectId).getItems();
		for(SurveyItem item:itemList)
			this.removeItem(item.getItemId());
		
		//删除调研主题
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_REMOVE_SUBJECT);
			pstmt.setInt(1, subjectId);
			pstmt.executeUpdate();
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}			
		
		
	}

	@Override
	public void addItemTicketCnt(int itemId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_INC_ITEM_TICKET_CNT); //increase
			pstmt.setInt(1, itemId);
			pstmt.executeUpdate();
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}
		
		
	}

	@Override
	public void addSubjectTicketCnt(int subjectId) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_INC_SUBJECT_TICKET_CNT); //increase
			pstmt.setInt(1, subjectId);
			pstmt.executeUpdate();
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}
				
		
	}

	@Override
	public int getVoteInterval(int subjectId, String ipAddr) {

		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int interval = -1;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_GET_VOTE_INTERVAL); 
			pstmt.setInt(1,subjectId);
			pstmt.setString(2, ipAddr);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				interval = rset.getInt("vote_interval");
			}
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, rset);
		}
		
		return interval;
		
		
	}

}
