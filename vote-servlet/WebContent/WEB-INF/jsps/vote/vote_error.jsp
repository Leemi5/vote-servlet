<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>友情提示</title>
    	<link style="text/css" rel="stylesheet" href="/sd/css/style.css">    	
	</head>
	<body bgcolor="#F0F0F0">
	  <center>
        <table border="0" width="760" height="620" background="/sd/images/bg.jpg">
            <tr>
            	<td>
            		<table border="0" cellspacing="0" cellpadding="0" width="333" style="margin-top:200;margin-left:118">
            			<tr height="74"><td background="/sd/images/messT_blank.jpg"></td></tr>
			            <tr height="100">
            			    <td align="center" bgcolor="#7688AD">
			                	<font color="white">${voteErr}</font>
            			    </td>
			            </tr>
            			<tr height="114">
            				<td background="images/messE.jpg" align="center" valign="top">
			                    <a href="/sd/voteMgr?task=voteMain"><img src="images/indexB.jpg" style="border:0"></a>
            			        &nbsp;&nbsp;&nbsp;
			                    <a href="/sd/voteMgr?task=toVotePage&subjectId=44"><img src="images/backB.jpg" style="border:0"></a>
            			        &nbsp;&nbsp;&nbsp;
			                    <a href="showVote.jsp"><img src="images/showB.jpg" style="border:0"></a>
            				</td>
            			</tr>
            		</table>
            	</td>
            </tr>
        </table>
      </center>
	</body>
</html>

