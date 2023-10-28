<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.yushi.Dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.yushi.entity.*" %>
<%
	RizhiDao dao = new RizhiDao();
	List<Rizhi> list = dao.selectAll();
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		
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
				<th>ID</th>
				<th>顾客姓名</th>
				<th>顾客电话</th>
				<th>顾客身份证</th>
				<th>房间号</th>
				<th>预约状态</th>
				<th>入住时间</th>
				<th>最后操作时间</th>
				<th>房间状态</th>
				<th>入支付状态</th>
				<th>备注</th>
				<th>花费</th>
				
			
			</tr>
<%
	for(int i=0; i<list.size(); i++){
		Rizhi qiantai = list.get(i);
%>
		<tr>
			<td><%=qiantai.getGid() %></td>
			<td><%=qiantai.getGname() %></td>
			<td><%=qiantai.getGtel() %></td>
			<td><%=qiantai.getGidc() %></td>
			<td><%=qiantai.getGhsno() %></td>
			<td><%=qiantai.getGyystate() %></td>
			<td><%=qiantai.getGruzhutime() %></td>
			<td><%=qiantai.getGouttime() %></td>
			<td><%=qiantai.getGhstate() %></td>
			<td><%=qiantai.getZhifustate() %></td>
			<td><%=qiantai.getBeizhu() %></td>
			<td><%=qiantai.getHuafei()%></td>
			
			
		</tr>
<%
	}
%>
		</table>
		
	
				
	</body>
</html>