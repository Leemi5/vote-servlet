<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
   
   function showLogoutDlg(){
	    //alert('djkdf');
	    $("#logoutmsg").text("尊敬的用户-[${loginedUser.userName}],您确认要退出系统吗?");
	    $("#logoutModal").modal('show');
   }
   
   function logout(){
	   location.href="/sd/securityMgr?task=logout";
   }

</script>
    
	    <!-- 退出模态窗 -->
		<div class="modal fade" tabindex="-1" role="dialog" id="logoutModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">系统提示</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <p id="logoutmsg"></p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
		        <button type="button" class="btn btn-primary" onclick="logout();">确定</button>
		      </div>
		    </div>
         </div>
         </div>	

<!-- 顶部菜单导航条 -->
	    <nav class="navbar navbar-expand-md navbar-light bg-light">
	       <a class="navbar-brand" href="#"><b>魔动投票管理系统 </b></a>
	       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
		   </button> 
		   <div class="collapse navbar-collapse" id="navbarSupportedContent">
		       <ul class="navbar-nav mr-auto">
		          <li class="nav-item active">
			        <a class="nav-link" href="/sd/securityMgr?task=main">首页</a>
			      </li>
	              <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                    调研投票         
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">          		          
			          <a class="dropdown-item" href='/sd/surveyMgr?task=toInput'>创建投票</a>		
			          <a class="dropdown-item" href='/sd/surveyMgr?task=loadSubjects'>投票管理</a>		
			        </div>
			      </li>	
			      <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                      操作账户
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href='/sd/userMgr?task=toInput'>新增账户</a>
			          <a class="dropdown-item" href="/sd/userMgr?task=loadUsers">账户管理</a>
			        </div> 
			      </li>
			      <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			                        系统维护           
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
			          <a class="dropdown-item" href="#">参数配置</a>
			        </div>
			      </li>			      		      	      
		       </ul>
	           <ul class="navbar-nav ml-auto">
			       <li class="nav-item">
			           <a class="nav-link">
			             <i class="fas fa-user" style="color:deeppink"></i>${loginedUser.userName}
			           </a>
			       </li>
	               <li class="nav-item">
			        <a class="nav-link" id="logoutBtn" style="cursor:pointer" onclick="showLogoutDlg()">退出系统</a>
			      </li>		       
			   </ul>		       
		   </div>      
	    </nav>
