<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<<c:set scope="request" var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3.C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopingcart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="./../inc.jsp"></jsp:include>
  </head>
  <style>
  	body{
  		background-image: url("http://192.168.1.114:8052/image/102.jpg");
  	}
  </style>
  <body>
  	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
					<div class="navbar-header">
						 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
					</div>
					
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active">
								 <a href="#">Link</a>
							</li>
							<li>
								 <a href="#">Link</a>
							</li>
							<li class="dropdown">
								 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										 <a href="#">Action</a>
									</li>
									<li>
										 <a href="#">Another action</a>
									</li>
									<li>
										 <a href="#">Something else here</a>
									</li>
									<li class="divider">
									</li>
									<li>
										 <a href="#">Separated link</a>
									</li>
									<li class="divider">
									</li>
									<li>
										 <a href="#">One more separated link</a>
									</li>
								</ul>
							</li>
						</ul>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input class="form-control" type="text" />
							</div> <button type="submit" class="btn btn-default">Submit</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li>
								 <a href="#">Link</a>
							</li>
							<li class="dropdown">
								 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li>
										 <a href="#">Action</a>
									</li>
									<li>
										 <a href="#">Another action</a>
									</li>
									<li>
										 <a href="#">Something else here</a>
									</li>
									<li class="divider">
									</li>
									<li>
										 <a href="#">Separated link</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					
				</nav>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-2 column">
			</div>
			<div class="col-md-10 column">
				<div class="list-group" id="cart-list">
				</div>
			</div>
		</div>
	</div>
	 
  </body>
  <script type="text/javascript">
  	$.ajax({
  		url:"${contextPath}/cart/list",
  		contextType:"application/json",
  		success:function(data){
  			console.info(data.status);
  			if(data.status==0){
  				console.info( data.data.cartProductVo instanceof Array );
  				var prolist = data.data.cartProductVo;
  					//console.info(prolist[index]);
			    prolist.forEach(function(e){
			    	var cart_list = document.getElementById("cart-list");
			    	var list_group_item = document.createElement("div");
			    	var list_group_item_text = document.createElement("p");
			    	var badge = document.createElement("span");
			    	var img = document.createElement("img");
			    	img.setAttribute("alt", "140x140");
			    	img.setAttribute("src", "http://192.168.1.114:8052/image/default3.jpg");
			    	img.setAttribute("class", "img-circle");
			    	
			    	list_group_item.setAttribute("class", "list-group-item");
			    	list_group_item_text.setAttribute("class", "list-group-item-text");
			    	list_group_item_text.appendChild(document.createTextNode(e.userId));
			    	
			    	badge.setAttribute("class", "badge");
			    	badge.appendChild(document.createTextNode(e.quantity));
			    	list_group_item.appendChild(badge);
			    	list_group_item.appendChild(img);
			    	list_group_item.appendChild(list_group_item_text);
			    	cart_list.appendChild(list_group_item);
			    	console.info(e.userId);
			    });
  			}else{
  				alert(data.data);
  			}
  		}
  	});
  </script>
</html>
