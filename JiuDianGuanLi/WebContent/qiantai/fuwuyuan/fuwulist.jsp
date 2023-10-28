<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.yushi.Dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.yushi.entity.*" %>
<%
	FuWuDao dao = new FuWuDao();
	List<FuWu> list = dao.selectAll();
	
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
  	<li class="layui-nav-item"><a href="nav.html"><a href="../List.jsp">顾客管理</a></a></li>
  	<li class="layui-nav-item"><a href="nav.html"><a href="../fangjianlist.jsp">房间管理</a></a></li>
  	<li class="layui-nav-item"><a href="nav.html"><a href="../tuifang.jsp">退房管理</a></a></li>
	<li class="layui-nav-item"><a href="nav.html"><a href="../fuwuyuan/fuwulist.jsp">服务员管理</a></a></li>

	
  	<li class="layui-nav-item"><a href="nav.html"><a href="../shijianlist1.jsp">事件管理</a></a></li>
	<li class="layui-nav-item"><a href="nav.html"><a href="rizhilist.jsp">查看日志</a></a></li>

</ul>
		
		
	</head>
	<body>
	
	
		<table border="" cellspacing="" cellpadding="">
			<tr>
				<th>ID</th>
				<th>员工姓名</th>
				<th>员工身份证</th>
				<th>员工电话</th>
				<th>员工职位</th>
				<th>员工位置</th>
				<th>工作需求</th>
				<th>备注</th>
				<th>&nbsp;</th>
				
			</tr>
<%
	for(int i=0; i<list.size(); i++){
		FuWu f = list.get(i);
%>
		<tr>
			<td><%=f.getYid() %></td>
			<td><%=f.getYname() %></td>
			<td><%=f.getYidc() %></td>
			<td><%=f.getYtel() %></td>
			<td><%=f.getZhiwei() %></td>
			<td><%=f.getWeizhi() %></td>
			<td><%=f.getXuqiu() %></td>
			<td><%=f.getBeizhu() %></td>
	
			<td>
			 <a href="fuwuupd.jsp?id=<%=f.getYid() %>"><button type="button"  class="layui-btn ">编辑</button></a>
			</td>
		
			
		</tr>
<%
	}
%>
		</table>
			<a href="fuwuadd.jsp"><button type="button"  class="layui-btn ">添加新的员工信息</button></a>
		
			
	</body>
</html>