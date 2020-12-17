<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/sd/vendor/bootstrap-4.5.0-dist/css/bootstrap.min.css" media="all" />
<script type="text/javascript" src="/sd/vendor/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/sd/vendor/popper.js/popper.min.js"></script>
<script type="text/javascript" src="/sd/vendor/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
</head>
<body>

      <jsp:include page="/WEB-INF/jsps/commons/menubar.jsp"></jsp:include>
	    
 <!-- 面包屑导航条 -->
	    <nav aria-label="breadcrumb">
			  <ol class="breadcrumb" style="border-radius:0em">
			    <li class="breadcrumb-item">首页</li>
			    <li class="breadcrumb-item">操作账户</li>
			    <li class="breadcrumb-item active">新增账户</li>
			  </ol>
		</nav>
		
	    <div class="container-fluid">
		   <div class="row">
		      <div class="col-12 col-md-6">
		         <form action="/sd/userMgr" method="post">
		              <input type="hidden" name="task" value="createUser"/>
					  <div class="form-group">
					    <label>账户名称</label>
					    <input name="userno" class="form-control" placeholder="请输入账户名称信息">
					  </div>
					  <div class="form-group">
			           <label>账户密码</label><br>
			           <input type="password" name="userpwd" class="form-control" >
			          </div>
					  <div class="form-group">
			           <label>密码确认</label><br>
			           <input type="password" name="confirmpwd" class="form-control" >
			          </div>
					  <div class="form-group">
					    <label>真实姓名</label>
					    <input name="username" class="form-control" placeholder="请输入真实姓名">
					  </div>			          
				      <input type="submit" class="btn btn-primary" value="新建账户">					      				  	         
		         </form>  
		      </div>
		   </div>
		</div>		

</body>
</html>