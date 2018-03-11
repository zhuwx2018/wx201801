<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="${contextPath }/static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${contextPath }/static/css/animate.css">
<script type="text/javascript" src="${contextPath }/static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${contextPath }/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery-serialize-object/2.4.5/jquery.serialize-object.min.js"></script>
</head>

<body class="">
	<div class="container">
		<div class="text-center animated fadeInUp">
			<h1 style="font-family: Arial,Verdana,Sans-serif;font-size: 60px;font-weight: 10px;">WXPRO</h1>
			<h3>欢迎登录</h3>
			<form id="userform" class="" role="form" action="${contextPath }/user/loginCheck" method="post">
				<div class="form-group">
					<input type="email" class="form-control" placeholder="账号" name="userId" />
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码" name="userPw" />
				</div>
				
			</form>
			<button id="formbt" class="btn-block btn-success btn-lg">登录</button>
			<p class="text-center text-muted">
				<a href="#">忘记密码？</a> | <a href="#">注册一个新账号</a>
			</p>
		</div>
	</div>
	<script type="text/javascript">
		 var submitBtn = document.getElementById("formbt");
 
			 submitBtn.onclick = function (event) {
				var form = $("#userform");
				var serialStr = form.serializeObject(form);
				serialStr = JSON.stringify(serialStr);
				/**
				 $.ajax({  
				    url: "http://localhost:8080/wx201801/user/loginCheck",
				    type: "POST",  
				    contentType: "application/json", 
				    data:serialStr,
				 //   crossDomain: true,  
				    dataType:"JSON",    
				    success: function(result) {  
				        alert(JSON.stringify(result));  
				    },  
				    error: function(xhr, status, error) {  
				    alert(status);  
				    }  
				});
				*/
				$.ajax({
					url:"${contextPath}/user/loginCheck",
					method:'post',
					data:serialStr,
					dataType:'json',
					contentType:'application/json',
					success:function(data){
						console.info('hello');
						window.location.href="${contextPath}/user/login";
					}
				});
			 };
			
	</script>
</body>
</html>
