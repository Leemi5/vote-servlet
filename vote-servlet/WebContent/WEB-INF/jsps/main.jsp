<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/sd/vendor/bootstrap-4.5.0-dist/css/bootstrap.min.css" media="all" />
	<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Architects+Daughter">
	<script type="text/javascript" src="/sd/vendor/jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="/sd/vendor/popper.js/popper.min.js"></script>
	<script type="text/javascript" src="/sd/vendor/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	   
	   #logoutBtn{
	     cursor:pointer;
	   }
	   
	</style>

  
  </head>
  
  <body>
  
        <%@ include file="/WEB-INF/jsps/commons/menubar.jsp" %>  

        <div class="container mt-5 mb-5">
	        <div class="container">
			 <div class="jumbotron">
			  <h1 class="display-4">欢迎来到魔动投票管理系统</h1>
			  <marquee  style="font-family: Architects Daughter;font-size:40px;color:blue">new voting new star!</marquee>
			 
			  <hr class="my-4">
			   
			  <a class="btn btn-primary btn-lg col-md-3 mx-2" href='/sd/surveyMgr?task=loadSubjects'>投票管理</a>
			  <a class="btn btn-success btn-lg col-md-3 mx-2" href="/sd/userMgr?task=loadUsers" >账户管理</a>
			  <a class="btn btn-info btn-lg col-md-3 mx-2" href="/sd/surveyMgr?task=showLog" >日志跟踪</a>
			 
			       
	        </div>
        </div>
       </div> 
		 
  </body>
</html>
