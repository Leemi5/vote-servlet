<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>投票系统v1.0-开始投票</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/sd/css/style.css">
	
	<script type="text/javascript">
	    
	    function validFrm(){
	    
	       var result = false;
	       var itemidList = document.forms[0].itemid;
	       
	       //alert(itemidList.length);
	       for(var i=0;i<itemidList.length;i++){
	          if(itemidList[i].checked){
	             result = true;
	          }
	       }
	       
	       if(result==false){
	           alert("请选择一个投票选项之后再提交!");
	       }
	    
	       return result;
	    }
	
	</script>
	
  </head>
  
  <body bgcolor="#F0F0F0">
	  <center>
        <form action="/sd/voteMgr" method="post" onsubmit="return validFrm();">	
          <input type="hidden" name="task" value="createVote"/>
          <input type="hidden" name="subjectid" value="${subject.subjectId}"/>
          <table border="0" width="760" height="620" background="/sd/images/bg.jpg">
             <tr>
               <td valign="top" width="420">
                  <table border="0" cellspacing="0" cellpadding="0" width="100%"
                         style="margin-top:240;margin-left:51;width:420px;position:relative" bgcolor="#7688AE">
                     <tr height="75">
                        <td align="center" colspan="2" background="images/voteT_blank.jpg;">
                           <span style="font-size:14px; font-weight:bold; position:absolute; left:50px; top:10px;">
                             ${subject.subjectName}
                           </span>
                        </td>
                     </tr>
                     <tr>
                    	<td align="center" width="60%">
                    		<table border="0" width="100%">
                    		  <c:forEach var="item" items="${subject.items}">
                    		     <tr height="27">
                                    	<td style="text-indent:7">${item.itemContent}</td>
	                                    <td width="30%" align="center">
	                                      <input type="radio" name="itemid" value="${item.itemId}">
	                                    </td> 
    		                     </tr> 
                    		  </c:forEach>
                    		</table>
                        </td>
                    	<td valign="top">
                    			<img src="/sd/images/note.jpg"> <b><font color="white">注意事项：</font></b>
                    			<p><font color="#FDE401"><li>1小时内只能投一次票！</li></font>
                    	</td>                        
                     </tr>
                        <!-- 显示操作按钮 -->
                        <tr height="97">
                            <td align="center" valign="top" colspan="2" background="images/voteE.jpg">
                                <input type="submit" value="" style="background-image:url(images/submitB.jpg);width:68;height:26;border:0">
                                <input type="reset" value="" style="background-image:url(images/resetB.jpg);width:68;height:26;border:0">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/sd/voteMgr?task=showVoteResult&subjectId=${subject.subjectId}"><img src="/sd/images/showB.jpg" style="border:0"></a>
                                <a href="/sd/voteMgr?task=showSubjectList"><img src="/sd/images/indexB.jpg" style="border:0"></a>
                            </td>                            
                        </tr>                     
                  </table>
               </td>
             </tr>
          </table>
      </center>  
  </body>
</html>
