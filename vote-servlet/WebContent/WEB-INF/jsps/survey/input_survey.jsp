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
<script type="text/javascript">

    var itemCnt=0;

    function addSurveyNewItem(){
    	
    	itemCnt++;
    	
    	if(itemCnt==1) $("#createSurveyBtn").before("<hr>");
    	
    	$("#createSurveyBtn").before(
			    '<div class="form-group row">'+
			    ' <label class="col-sm-2 col-form-label subjectlabel">投票项目'+itemCnt+':</label>'+
			    ' <div class="col-sm-9">'+
			     ' <input type="text" name="itemcontent" class="form-control" id="staticEmail" value="请输入投票项的说明信息">'+
			     '</div>'+
			     '<button class="btn btn-danger btn-sm itembtn" title="点击删除该投票项" onclick="removeSurveyItem(this,'+itemCnt+')">删 除</button>'+
			    '</div>');
    	
    }
    
    function removeSurveyItem(btn,cnt){
    	//alert('you click me!');
    	$(btn.parentNode).remove();
		itemCnt = $(".subjectlabel").length;
    	//如果删除的不是最后一个，开始重新设置subjectlabel
    	if(cnt!=itemCnt){
    		
    		$(".subjectlabel").each(function(idx){
    			this.innerHTML="投票项目"+(idx+1);
    		});
    				
    		//$(".itembtn").each(function(idx){
    		//	this.onclick='removeSurveyItem(this,'+(idx+1)+')';
    		//});
    		
    	}
    	
    }
  
</script>
</head>
<body>

      <jsp:include page="/WEB-INF/jsps/commons/menubar.jsp"></jsp:include>
	    
 <!-- 面包屑导航条 -->
	    <nav aria-label="breadcrumb">
			  <ol class="breadcrumb" style="border-radius:0em">
			    <li class="breadcrumb-item">首页</li>
			    <li class="breadcrumb-item">调研投票</li>
			    <li class="breadcrumb-item active">创建投票</li>
			  </ol>
		</nav>
		
	    <div class="container-fluid">
		   <div class="row">
		      <div class="col-md-8">
		         <div class="text-right">
		         <button class="btn btn-outline-primary btn-sm" onclick="addSurveyNewItem()">新增投票项</button>
		         </div>
		         <form action="/sd/surveyMgr" method="post">
		              <input type="hidden" name="task" value="createSurvey"/>
					  <div class="form-group">
					    <label>投票主题</label>
					    <input name="subjectname" class="form-control" placeholder="请输入投票主题名称">				    
					  </div>				            
				      <input type="submit" class="btn btn-primary" id="createSurveyBtn" value="创建投票">					      				  	         
		         </form> 
		      </div>
		   </div>
		</div>		

</body>
</html>