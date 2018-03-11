<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>  
<c:set var="ctx" value="${pageContext.request.contextPath}"/>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";  
      
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html>  
<head lang="en">  

    <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>  
    <!-- 新 Bootstrap 核心 CSS 文件 -->  
    <link rel="stylesheet" href="${ctxStatic }/css/bootstrap.css">  
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 --> 
    <script src="${ctxStatic}/js/jquery-3.2.1.js" type="text/javascript"></script>  
    <!--<script type="text/javascript" src="js/jquery-1.7.2.js"></script>-->  
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->  
    <script src="${ctxStatic }/js/bootstrap.min.js"></script>  
    <%-- <script src="${ctxStatic }/stomp/stomp.mini.js"></script> --%>  
    <script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.min.js"></script>  
      
    <title>stomp测试</title>  
<script type="text/javascript">  
$(document).ready(function() {  
    var sock = new SockJS("${ctx}/hello");  
    var stomp = Stomp.over(sock);  
      
    stomp.connect('guest', 'guest', function(frame) {  
        console.log('*****  Connected  *****');  
        $('#msg').append("<b>*****  Connected  *****</b><br/>");  
        //一次性订阅，只返回一次  
        stomp.subscribe("/app/subscribeme", handleOneTime);  
        //订阅代理，代理发消息将会接收到  
        stomp.subscribe("/topic/hi", handleMsg);  
    }, function(error) {  
        console.log('error:'+error);  
          
    });  
      
    function handleOneTime(message) {  
        //alert('123');  
        console.log('Received: ', message);  
        $('#msg').append("<b>handleOneTime - Received: " +  
               message.body + "</b><br/>");  
    }  
  
    function handleMsg(message) {  
        console.log('Received: ', message);  
        $('#msg').append("<b>Received: " +  
                message.body + "</b><br/>");  
       // if (JSON.parse(message.body).message === 'Polo!') {  
       //     setTimeout(function(){sayMarco()}, 2000);  
       // }  
    }  
  
    function handleErrors(message) {  
        console.log('RECEIVED ERROR: ', message);  
        $('#msg').append("<b>GOT AN ERROR!!!: " +  
                JSON.parse(message.body).message + "</b><br/>");  
    }  
  
    function send() {  
        console.log('Sending msg!');  
        //发送  
        stomp.send("/app/hi", {},  
                JSON.stringify({ 'message':  $('#message').val()}));  
//        stomp.send("/topic/marco", {},  
//                JSON.stringify({ 'message': 'Marco!' }));  
        $('#msg').append("<b>Send: " + $('#message').val() + "!</b><br/>");  
    }  
  
    $('#stop').click(function() {  
        sock.close();  
          $('#msg').append("<b>Connection closed!</b><br/>");   
    });  
      
    $('#send').bind('click', function() {  
        send();  
    });  
      
});  
</script>  
</head>  
<body>  
  
<div class="page-header" id="tou">  
    webSocket-stomp测试程序  
     <button class="btn btn-default" type="button" id="stop" >关闭连接</button>  
</div>  
<div class="well" id="msg">  
</div>  
<div class="col-lg">  
    <div class="input-group">  
        <input type="text" class="form-control" placeholder="发送信息..." id="message">  
      <span class="input-group-btn">  
        <button class="btn btn-default" type="button" id="send" >发送</button>  
      </span>  
    </div><!-- /input-group -->  
</div><!-- /.col-lg-6 -->  
</body>  
</html>  