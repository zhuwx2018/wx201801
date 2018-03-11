<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set scope="request" var="contextPath" value="${pageContext.request.contextPath }"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML P.UBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileupload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">/wx201801/WebRoot/static/bootstrap-fileinput/css/fileinput.css
	-->
	<link href="${contextPath }/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath }/static/bootstrap-fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="${contextPath }/static/bootstrap-fileinput/themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="${contextPath }/static/bootstrap-fileinput/js/plugins/sortable.js" type="text/javascript"></script>
    <script src="${contextPath }/static/bootstrap-fileinput/js/fileinput.js" type="text/javascript"></script>
    <script src="${contextPath }/static/bootstrap-fileinput/js/locales/fr.js" type="text/javascript"></script>
    <script src="${contextPath }/static/bootstrap-fileinput/js/locales/es.js" type="text/javascript"></script>
    <script src="${contextPath }/static/bootstrap-fileinput/themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="${contextPath }/static/bootstrap-fileinput/themes/fa/theme.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>
    <script src="${contextPath }/static/bootstrap/js/bootstrap.min.js"  type="text/javascript"></script>
    <script type="text/javascript" src="${contextPath}/static/bootstrap-fileinput/js/locales/zh.js"></script>
  </head>
  <style>
  	.box{
  		width: 500px;
  		height:500px;
  	}
  </style>
  <body>
   	<form action="${contextPath }/fileController/upload" enctype="multipart/form-data" method="post">
   		<label for="fileone">选择文件</label>
   		<input type="file" name="partfile" id="fileone" accept="image/jpeg">
   		<input type="submit" value="提交"/> 
   	</form>
   	  <form id="form" action="${contextPath }/fileController/upload" method="post" enctype="multipart/form-data">
         <div class="row form-group">
            <label class="col-md-4">图片上传:</label>
            <div class="col-sm-12">
                <input id="input-id" name="partfile" multiple type="file" data-show-caption="true">
            </div>
        </div>
    </form>
    
    <script>
	  $(function () {
        initFileInput("input-id");
    })

    function initFileInput(ctrlName) {
        var control = $('#' + ctrlName);
        control.fileinput({
            language: 'zh', //设置语言
            uploadUrl: "${contextPath }/fileController/upload", //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
            uploadAsync: true, //默认异步上传
            showUpload: true, //是否显示上传按钮
            showRemove : true, //显示移除按钮
            showPreview : true, //是否显示预览
            showCaption: true,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            //dropZoneEnabled: true,//是否显示拖拽区域
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            //maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",

        }).on('filepreupload', function(event, data, previewId, index) {     //上传中
            var form = data.form, files = data.files, extra = data.extra,
            response = data.response, reader = data.reader;
            console.log('文件正在上传');
        }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功
            console.log('文件上传成功！'+data.id);

        }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
            console.log('文件上传失败！'+data.id);


        })
    }
	</script>
  </body>
</html>
