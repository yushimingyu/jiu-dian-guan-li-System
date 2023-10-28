<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.yushi.Dao.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.yushi.entity.*" %>



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
			button{
				width: 300px;
				height: 40px;
				background-color: darkgreen;
				color: #FFFFFF;
				font-size: 20px;
				border: none; /* 设定边框为 无 */
				border-radius: 5px; /* 元素的边角圆弧的半径 */
			}
		</style>

	</head>
	<body>
<%
	String id1 = request.getParameter("id");
	if(id1==null || id1.trim().equals("")){
		//如果学号信息不存在，返回列表页
		response.sendRedirect("List.jsp");
		return;
	}
	int id = Integer.parseInt(id1);
	FangJianDao sdao = new FangJianDao();
	FangJian s = sdao.selectByFno(id);
	QianTaiDao bdao = new QianTaiDao();
	List<QianTai>list = bdao.selectByQianTaiId(id);
%>	

	
		<table>
		
		<tr>
		<th>房间信息</th>
		<th><span>房间ID</span></th>
		<th><%=s.getId() %></th>
		<th><span>房间号</span></th>
		<th><%=s.getFno()  %></th>
		<th><span>房间状态</span></th>
		<th><%=s.getZhuangtai() %></th>
		<th><span>房间类型</span></th>
		<th><%=s.getLeixing() %></th>
		<th><span>房间价格</span></th>
		<th><%=s.getJiage() %></th>
		<th>&nbsp;</th>
		</tr>
		
		<tr>
		<th>ID</th>
		<th>顾客姓名</th>
		<th>顾客电话</th>
		<th>顾客身份证</th>
		<th>房间号</th>
		<th>预约状态</th>
		<th>入住时间</th>
		<th>离店时间</th>
		<th>房间状态</th>
		<th>入支付状态</th>
		<th>备注</th>
		<th>花费</th>
		</tr>
<%
	for(QianTai qiantai : list){
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
	
	
	
	
			
			<a href="tuifang.jsp"><button type="button">返回列表</button></a>
			
	</body>
</html>


