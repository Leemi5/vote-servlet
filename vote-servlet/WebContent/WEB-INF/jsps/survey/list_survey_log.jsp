<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/sd/vendor/bootstrap-4.5.0-dist/css/bootstrap.min.css" media="all" />
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Architects+Daughter">
<script type="text/javascript" src="/sd/vendor/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/sd/vendor/popper.js/popper.min.js"></script>
<script type="text/javascript" src="/sd/vendor/bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="/WEB-INF/jsps/commons/menubar.jsp"></jsp:include>

<!-- 面包屑导航条 -->
<nav aria-label="breadcrumb">
    <ol class="breadcrumb" style="font-family: Architects Daughter;font-size:30px">
        <li class="breadcrumb-item"  >Voting log</li>

    </ol>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">序号</th>
                    <th scope="col">主题名称</th>
                    <th scope="col">投票总票数</th>
                    <th scope="col">用户投票选项</th>
                    <th scope="col">该选项票数</th>
                    <th scope="col">用户IP</th>
                    <th scope="col">操作时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="log" items="${logList}" varStatus="idx">
                    <tr>
                        <th scope="row">${idx.index+1}</th>
                        <td>${log.subjectName}</td>
                        <td>${log.subjectTicketCnt}</td>
                        <td>${log.itemName}</td>
                        <td>${log.itemTicketCnt}</td>
                        <td>${log.ipaddr}</td>
                        <td><fmt:formatDate value="${log.creatTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>