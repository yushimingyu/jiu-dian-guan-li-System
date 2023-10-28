<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.yushi.Dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.yushi.entity.*" %>
<%

	ShiJianDao sdao = new ShiJianDao();

	
	List<ShiJian>list = sdao.selectAll();
%>	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link href="//unpkg.com/layui@2.8.0/dist/css/layui.css" rel="stylesheet">
		<style type="text/css">
			tr{
				height: 60px; /* 表格中每一行的高度都是40像素 */
				line-height: 60px; /* 这个值和height一致 则单行的文字可垂直剧中 */
				
			}
			tr:nth-of-type(2n){
				/* 偶数行 */
				background-color: lightgreen;
			}
			tr:nth-of-type(2n-1){
				/* 奇数行 */
				background-color: lightblue;
			}
			th{
				background-color: darkgreen;/* 设置背景为深绿 */
				color: #fff;/* 设定文字颜色为白色 */
			}
			th,td{
				padding: 0px 10px; /* 每一个单元格上下的内部间距为0左右为10个像素 */
				width: auto;
				min-width: 50px;
				max-width: 300px;
				text-align: center;
			}
			h1{
				font-size: 24px; /* 设定字号 */
				color: #424242; /* 文字颜色 */
				text-align: center; /* 水平对齐方式 */
				height: 60px; /* 高度 */
				
			}
			form{
				margin: 100px auto; /* 表单所在的区域距离其他元素（页面边界）上下和左右的外部距离，当作有距离为auto时，水平居中 */
				width: 600px;
				height: auto;
				background-color: #ccc;
				padding: 20px 50px; /* 表单中所有内容和边界的内部的距离 上下 左右*/
				
			}
			p{
				height: 40px;
				line-height: 40px;
			}
			p span{
				display: inline-block;
				width: 100px;
				text-align: right;
				margin-right: 50px; /* 外部的元素距离我右侧的最小间隔 */
			}
			
			p input[type=text],
			p input[type=password],
			p input[type=date],
			p input[type=email]{
				height: 40px;
				width: 350px;
				outline: none;
				font-size: 16px;
			}
			p input[type=radio]{
				width: 20px;
				height: 20px;
			}
			
			p.btn-row{
				text-align: center;
			}
			
		</style>
		<link href="//unpkg.com/layui@2.8.0/dist/css/layui.css" rel="stylesheet">
		
		<ul class="layui-nav layui-bg-cyan">
  	<li class="layui-nav-item"><a href="nav.html"><a href="List.jsp">顾客管理</a></a></li>
  	<li class="layui-nav-item"><a href="nav.html"><a href="fangjianlist.jsp">房间管理</a></a></li>
  	<li class="layui-nav-item"><a href="nav.html"><a href="tuifang.jsp">退房管理</a></a></li>
	<li class="layui-nav-item"><a href="nav.html"><a href="fuwuyuan/fuwulist.jsp">服务员管理</a></a></li>

	
  	
  	
  	
  	<li class="layui-nav-item"><a href="nav.html"><a href="shijianlist1.jsp">事件管理</a></a></li>
	<li class="layui-nav-item"><a href="nav.html"><a href="rizhilist.jsp">查看日志</a></a></li>

</ul>
		
	</head>
	<body>
	
	
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th> ID </th>
				<th> 房间号 </th>
				<th> 事件 </th>
				<th> 要求 </th>
				<th> 备注 </th>
				
				<th>&nbsp;</th>
			
			</tr>
<%
	for(int i=0; i<list.size(); i++){
		ShiJian f = list.get(i);
%>
		<tr>
			<td><%=f.getSid() %></td>
			<td><%=f.getSfno() %></td>
			<td><%=f.getShijan() %></td>
			<td><%=f.getYaoqiu() %></td>
			<td><%=f.getBeizhu() %></td>

	
			<td>
			 <a href="shijandel.action?id=<%=f.getSid() %>"><button type="button" class="layui-btn ">删除</button></a>
			</td>
		</tr>
<%
	}
%>
		</table>
			<a href="shijianadd.jsp"><button type="button"  class="layui-btn ">添加事件</button></a>
			<a href="List.jsp"><button type="button"  class="layui-btn ">返回列表</button></a>
			
	</body>
</html>