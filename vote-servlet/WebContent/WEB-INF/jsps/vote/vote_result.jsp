<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>投票系统v1.0-投票结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/sd/css/style.css">

  </head>
  
  <body bgcolor="#F0F0F0">
      <div style="position:absolute;left:320px;top:150px;">
	        <h3>${subject.subjectName}&nbsp;&nbsp;&nbsp;(总票数:${subject.subjectTicketCnt})</h3>
	  </div>
	  <center>
         <table border="0" cellspacing="0" cellpadding="0" width="760" height="620" background="/sd/images/showbg.jpg">
            <tr height="20">
                <td valign="top" width="40%">
                   <table border="0" width="75%" cellspacing="0" cellpadding="0" style="margin-top:310;margin-left:45">
                            <c:forEach var="item" items="${subject.items}">
                            <tr height="25">
                                <td>${item.itemContent}</td>
                                <td width="25%" align="right">${item.itemTicketCnt} 票&nbsp;&nbsp;</td> 
                            </tr> 
                            </c:forEach>
                            <tr height="25">
				              <td colspan="2"><a href="/sd/voteMgr?task=toVotePage&subjectId=${subject.subjectId}"><img src="images/backB.jpg" style="border:0"></a></td>
            			   </tr>                            
                   </table>
                </td>
                <td valign="top" width="60%">
                   <table border="0" width="40%" cellspacing="0" cellpadding="0" style="margin-top:310;margin-left:20">
                            <c:forEach var="item" items="${subject.items}">
                            <tr height="25">
                                <td>
                                  <img src="/sd/images/count.jpg" 
                                         width="${item.itemTicketCnt*100.0/subject.subjectTicketCnt}%" height="15">
                                </td>
                                <td width="25%" align="right">
                                   <fmt:formatNumber type="number" 
                                                     pattern="0.00" 
                                                     maxFractionDigits="2"
                                                     value="${item.itemTicketCnt*100.0/subject.subjectTicketCnt}">
                                  </fmt:formatNumber>%
                                </td> 
                            </tr> 
                            </c:forEach>
                           <tr height="25">
				              <td colspan="2" align="right"><a href="/sd/voteMgr?task=showSubjectList"><img src="images/indexB.jpg" style="border:0"></a></td>
                           </tr>                   
                   </table>
                </td>
           <tr>
         </table>
      </center>  
  </body>
</html>
