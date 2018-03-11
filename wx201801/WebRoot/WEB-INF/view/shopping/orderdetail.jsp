<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE .HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderdetail.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="./../inc.jsp"></jsp:include>
  </head>
  
  <body>
   	<table id="grid"></table>
   	<script type="text/javascript">
   		 var $table;
        //初始化bootstrap-table的内容
        function InitMainTable () {
            //记录页面bootstrap-table全局变量$table，方便应用
            var queryUrl = '${contextPath}/order/list_order';
            $table = $('#grid').bootstrapTable({
                url: queryUrl,                      //请求后台的URL（*）
                method: 'GET',                      //请求方式（*）
             //   toolbar: '#toolbar',              //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
                pageSize: 10,                     //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: false,                      //是否显示表格搜索
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列（选择显示的列）
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 600,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                  //是否显示父子表
                //得到查询的参数
                queryParams : function (params) {
                    //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    var temp = {   
                        pageSize: params.limit,                         //页面大小
                        currentPage: (params.offset / params.limit) + 1,   //页码
                        sort: params.sort,      //排序列名  
                        sortOrder: params.order //排位命令（desc，asc） 
                    };
                    return temp;
                },
                columns: [{
                    checkbox: true,  
                    visible: true                  //是否显示复选框  
                }, {
                    field: 'id',
                    title: 'ID',
                    sortable: true
                }, {
                    field: 'orderNo',
                    title: '订单号',
                    sortable: true
                }, {
                    field: 'userId',
                    title: '用户ID',
                    sortable: true
                }, {
                    field: 'shippingId',
                    title: '购物Id'
                }, {
                    field: 'payment',
                    title: '支付金额'
                }, {
                    field: 'paymentType',
                    title: '支付状态',
                    sortable: true,
                    formatter: function (value, row, index) {
                    	if(value ==1){
                    		return '支付成功';
                    	}
                    	return '支付失败';
				    }
                }, {
                    field: 'Age',
                    title: '年龄'
                }, {
                    field: 'createTime',
                    title: '创建时间',
                    formatter: function(value){
                    	return changeDateFormat(value);
                    }
                    
                }, {
                    field: 'updateTime',
                    title: '更新时间',
                    formatter: function(value){
                    	return changeDateFormat(value);
                    }
                }, {
                    field:'id',
                    title: '操作',
                    width: 120,
                    align: 'center',
                    valign: 'middle',
                    formatter:actionFormatter
                }, ],
                onLoadSuccess: function (data) {
                	
                },
                //处理返回数据
                responseHandler: function(data) {
                	return {
                    total:data.data.total,
                	rows:data.data.list
                 };
            },
                onLoadError: function () {
                    showTips("数据加载失败！");
                },
                onDblClickRow: function (row, $element) {
                    var id = row.ID;
                    EditViewById(id, 'view');
                },
            });
        };
        InitMainTable();
         //转换日期格式(时间戳转换为datetime格式)
	    function changeDateFormat(cellval) {
	        var dateVal = cellval + "";
	        if (cellval != null) {
	            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
	            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
	            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
	            
	            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
	            
	            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
	        }
	    }
	    
	     //操作栏的格式化
        function actionFormatter(value, row, index) {
            var id = value;
            var result = "";
            result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "', view='view')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
            result += "<a href='javascript:;' class='btn btn-xs blue' onclick=\"EditViewById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
            result += "<a href='javascript:;' class='btn btn-xs red' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";

            return result;
        }
        function DeleteByIds(id){
        /*
        	var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
                return row.id;
            });
         */
        	var idlist = [parseInt(id)];
        	$table.bootstrapTable('remove', {field: 'id', values: idlist});
        }
   	</script>
  </body>
</html>
