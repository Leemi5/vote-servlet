<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" href="/sd/vendor/bootstrap-4.5.0-dist/css/bootstrap.min.css" media="all" />
	<script type="text/javascript" src="/sd/vendor/jquery/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="/sd/vendor/popper.js/popper.min.js"></script>
	<script type="text/javascript" src="/sd/vendor/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
  

  </head>
  
  <body>

    <div class="container">
       <div class="row col-12 col-md-6 offset-md-2" style="margin-top:100px">
         <h2><b>迅科融智调研管理平台 v1.0</b></h2>
         <hr>
       </div>
       <div class="row py-5">
        <form action="/sd/securityMgr" method="post" class="col-12 col-md-6 offset-md-3">
           <input type="hidden" name="task" value="login"/>
           <div class="form-group">
		    <label for="userno">账户名称</label>
		    <input type="text" name="userno" class="form-control" placeholder="请输入6位账号信息" maxlength="6" value="${param.userno}">
		   </div>
           <div class="form-group">
		    <label for="userno">账户密码</label>
		    <input type="password" name="userpwd" class="form-control" placeholder="请输入密码信息" maxlength="6">
		   </div>
		   <c:if test="${not empty errMsg}">
            <div class="alert alert-danger text-center">
			  ${errMsg}
		    </div>		
		   </c:if>		   		   
		   <div>
		    <button class="btn btn-primary">系统登录</button>
		   </div>		   		               
        </form>
      </div>
    </div>
  </body>
</html>
