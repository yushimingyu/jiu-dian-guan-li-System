<%@ page import="com.yushi.entity.FangJian"%>
<%@ page import="java.util.List"%>
<%@ page import="com.yushi.Dao.FangJianDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
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
	FangJianDao dao=new FangJianDao();
	FangJian s= dao.selectById(id);
%>	
		<form action="fangjianupd.action" method="post">
		<input type="hidden" name="id" id="" value="<%=id1 %>" />
			<p>
				<span>房间编号</span>
				<input type="text" name="fno" id="" value="<%=s.getFno() %>" />
			</p>
			<p>
				<span>房间状态</span>
				<input type="text" name="zhuangtai" id="" value="<%=s.getZhuangtai() %>" />
			</p>
			<p>
				<span>房间类型</span>
				<input type="text" name="leixing" id="" value="<%=s.getLeixing() %>" />
			</p>

			<p>
				<span>房间价格</span>
				<input type="text" name="jiage" id="" value="<%=s.getJiage() %>" />
			</p>
						

			
			<p>
				<button type="submit">添加</button>
			</p>
			
			<p>
				<a href="fangjianlist.jsp"><button type="button">返回列表</button></a>
			</p>
		</form>
		
	</body>
</html>
