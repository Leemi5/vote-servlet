<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>投票系统v1.0</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/sd/css/style.css">
	<style>
	    
	     tr,td{
	        border:1px solid blue;
	     }
	     
	     table,tr,td{
	       font-size:13px;
	       font-weight:normal;
	     }
	     
	     h3{
	       font-size:16px;
	     }
	
	</style>
  </head>
  
  <body bgcolor="#F0F0F0">
       <center>       
	       <table border="0" width="760" height="620" cellspacing="0" cellpadding="0" background="/sd/images/bg.jpg">
	            <tr>
	              <td style="padding-top:100px;padding-left:10px;">
	               <h3>投票主题列表</h3>
	               <table width="70%" border="1" cellspacing="0" cellpadding="3">
	                 <tr>
	                  <th>序号</th>
	                  <th>内容</th>
	                  <th>投票项数量</th>
	                  <th>已投票量</th>
	                  <th>发布时间</th>
	                  <th>操作</th>
	                 </tr>
	                 <c:forEach var="subject" items="${subjectList}">
	                 <tr>
	                   <td>${subject.subjectId}</td>
	                   <td>${subject.subjectName}</td>
	                   <td>${subject.items.size()}</td>
	                   <td>${subject.subjectTicketCnt}</td>
	                   <td>
	                    <fmt:formatDate value="${subject.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	                   </td>
	                   <td>
	                     <a href="/sd/voteMgr?task=toVotePage&subjectId=${subject.subjectId}"
	                        title="点击去参与投票-${subject.subjectName}"> 去投票 </a> 
	                   </td>
	                 </tr>
	                 </c:forEach>
	               </table>
	              </td>
	            </tr>
	        </table>
        </center>  
  </body>
</html>
