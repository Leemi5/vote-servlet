<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/sd/vendor/bootstrap-4.5.0-dist/css/bootstrap.min.css" media="all" />
<script type="text/javascript" src="/sd/vendor/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/sd/vendor/popper.js/popper.min.js"></script>
<script type="text/javascript" src="/sd/vendor/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">

    var willDelUserNo;
  
    function updateUser(userno){
    	location.href="/sd/userMgr?task=preUpdateUser&userno="+userno;
    }
    
    function showRemoveDlg(userno,username){
    	willDelUserNo=userno;
    	$("#msg").text("你确认要删除用户["+username+"("+userno+")]信息吗?"); //jquery
    	$("#removeUserModal").modal('show');
    }
    
    function removeUser(){
    	location.href="/sd/userMgr?task=removeUser&userno="+willDelUserNo;
    }
  
</script>
</head>
<body>

      <jsp:include page="/WEB-INF/jsps/commons/menubar.jsp"></jsp:include>
	    
 <!-- 面包屑导航条 -->
	    <nav aria-label="breadcrumb">
			  <ol class="breadcrumb" style="border-radius:0em">
			    <li class="breadcrumb-item">首页</li>
			    <li class="breadcrumb-item">操作账户</li>
			    <li class="breadcrumb-item active">账户管理</li>
			  </ol>
		</nav>
		
	    <div class="container-fluid">
		   <div class="row">
		      <div class="col-12">
		      <table class="table">
				  <thead>
				    <tr>
				      <th scope="col">序号</th>
				      <th scope="col">用户编号</th>
				      <th scope="col">用户真实姓名</th>
				      <th scope="col">用户密码</th>
				      <th scope="col">创建时间</th>
				      <th scope="col">操作</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="user" items="${userList}" varStatus="idx">
				    <tr>
				      <th scope="row">${idx.index+1}</th>
				      <td>${user.userNo}</td>
				      <td>${user.userName}</td>
				      <td>*******</td>
				      <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				      <td>
				        <button class="btn btn-primary btn-sm" onclick="updateUser('${user.userNo}')">修改</button>
				        <button class="btn btn-danger btn-sm" onclick="showRemoveDlg('${user.userNo}','${user.userName}')">删除</button>
				      </td>				      
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
		      </div>
		   </div>
		</div>	
		
		<!-- 删除用户信息模态窗 -->
		<div class="modal fade" tabindex="-1" role="dialog" id="removeUserModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">系统提示</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p id="msg">你确认要删除用户信息吗?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
		        <button type="button" class="btn btn-primary" onclick="removeUser();">删除</button>
		      </div>
		    </div>
         </div>
</div>	

</body>
</html>