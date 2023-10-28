<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.yushi.Dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.yushi.entity.*" %>
<%
	FangJianDao dao = new FangJianDao();
	List<FangJian> list = dao.selectAll();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link href="//unpkg.com/layui@2.8.0/dist/css/layui.css" rel="stylesheet">
		<style type="text/css">
			tr{
				height: 40px; /* 表格中每一行的高度都是40像素 */
				line-height: 40px; /* 这个值和height一致 则单行的文字可垂直剧中 */
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
		</style>
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
				<th>ID</th>
				<th>房间号</th>
				<th>房间状态</th>
				<th>房间类型</th>
				<th>房间价格</th>
				<th>操作</th>
				<th>跳转</th>
				
			</tr>
<%
	for(int i=0; i<list.size(); i++){
		FangJian f = list.get(i);
%>
		<tr>
			<td><%=f.getId() %></td>
			<td><%=f.getFno() %></td>
			<td><%=f.getZhuangtai() %></td>
			<td><%=f.getLeixing() %></td>
			<td><%=f.getJiage() %></td>
	
			
			
			
			 
			 
		
			
		
			<td>
			<div class="layui-btn-group">
  <a href="fangjianupd.jsp?id=<%=f.getId() %>">
  <button type="button" class="layui-btn ">编辑</button></a>
  <a href="fangjiandel.action?id=<%=f.getId() %>">
   <button type="button" class="layui-btn">删除</button></a>
  
</div>
			
			
			</td>
			<td>
			
			
			
			<div class="layui-btn-group">
 <a href="fangjianinfo.jsp?id=<%=f.getFno() %>"><button type="button" class="layui-btn ">查看入住信息</button></a>
  <a href="shijianlist.jsp?id=<%=f.getFno() %>"><button type="button" class="layui-btn ">查看房间事件</button></a>
</div>
			 
			</td>
		</tr>
<%
	}
%>
		</table>
		
		<div class="layui-btn-container">  
  			<a href="fangjianadd.jsp"><button type="button" class="layui-btn  layui-btn-sm">添加新的房间信息</button></a>
 			
		</div> 
		
			
		
			
	</body>
</html>