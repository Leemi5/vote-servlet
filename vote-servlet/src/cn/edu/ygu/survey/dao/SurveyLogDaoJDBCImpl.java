/**
 * 
 */
package cn.edu.ygu.survey.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ygu.survey.domain.SurveyLog;
import cn.edu.ygu.survey.utils.DBUtils;

/**
 * @author joeyang ong
 *
 */
public class SurveyLogDaoJDBCImpl implements SurveyLogDao {
	
	private static final String SQL_ADD_LOG
	  = "insert into tbl_survey_log(ip_addr,item_id) values(?,?)";
	 private static final String SQL_SHOW_LOG ="select  a.subject_id,a.subject_name,subject_ticket_cnt,b.item_content,b.item_ticket_cnt,c.ip_addr,c.create_time " +
	            "from tbl_survey_subject a, tbl_survey_item b, tbl_survey_log c " +
	            "where a.subject_id=b.subject_id and b.item_id=c.item_id " +
	            "order by create_time desc";


	/* (non-Javadoc)
	 * @see cn.edu.ygu.survey.dao.SurveyLogDao#addSurveyLog(cn.edu.ygu.survey.domain.SurveyLog)
	 */
	@Override
	public void addSurveyLog(SurveyLog log) {
	
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
		
		try {
			
			pstmt = conn.prepareStatement(SQL_ADD_LOG); 
			pstmt.setString(1, log.getIpaddr());
			pstmt.setInt(2,log.getItemId());
			pstmt.executeUpdate();
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.releaseRes(conn, pstmt, null);
		}		

	}


	@Override
	public List<SurveyLog> sbDX() {
		Connection conn = DBUtils.getConn();
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<SurveyLog> logList = new ArrayList<>();
        try {

        	pstmt = conn.prepareStatement(SQL_SHOW_LOG);
            rs = pstmt.executeQuery();
            while (rs.next()){
                SurveyLog log=new SurveyLog();
                log.setSubjcetId(rs.getInt("subject_id"));
                log.setIpaddr(rs.getString("ip_addr"));
                log.setCreatTime(new Date(rs.getTimestamp("create_time").getTime()));
                log.setSubjectName(rs.getString("subject_name"));
                log.setItemName(rs.getString("item_content"));
                log.setItemTicketCnt(rs.getInt("item_ticket_cnt"));
                log.setSubjectTicketCnt(rs.getInt("subject_ticket_cnt"));
                logList.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DBUtils.releaseRes(conn, pstmt, rs);
        }
        return logList;
	}


}
