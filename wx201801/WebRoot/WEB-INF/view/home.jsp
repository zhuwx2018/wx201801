<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/sockjs-1.1.1.js"></script>
	 
	<!--/wx201801/WebRoot/static/js/sockjs-1.1.1.js
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<script type="text/javascript" src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
	-->
  </head>
  
  <body>
    home page!${pageContext.request.contextPath}
    <div id="console">
    	
    </div>
    <button onclick="sendMsg()">send</button>
    <script type="text/javascript">
    	window.onbeforeunload = closeSock;
    	//var url = "ws://"+ window.location.host +"/wx201801/socket";
    	var url = "ws://"+ window.location.host +"/wx201801/socket";
    	var sockjsUrl = "http://"+ window.location.host +"/wx201801/socket";
    	var websocket = null;
   		websocket = new SockJS(sockjsUrl);
    	websocket.onopen = function(){
	    	websocket.send("hello");
    	};
    	websocket.onmessage = function(event){

    		var msg = document.createTextNode(event.data);
    		document.getElementById("console").appendChild(msg);
    	};
    	function sendMsg(){
    		websocket.send("heloolll");
    	}
    	function closeSock(){
    		websocket.close();
    	}
    </script>
  </body>
</html>
