<%@ page import="com.yushi.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.yushi.Dao.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	FangJianDao dao = new FangJianDao();
	List<FangJian>list = dao.selectAll();
%>

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
	
		<form action="fuwuadd.action" method="post">
		
			<p>
				<span>员工姓名</span>
				<input type="text" name="yname" id="" value="" />
			</p>
			<p>
				<span>员工身份证</span>
				<input type="text" name="yidc" id="" value="" />
			</p>
			<p>
				<span>员工电话</span>
				<input type="text" name="ytel" id="" value="" />
			</p>

			<p>
				<span>员工职位</span>
				<input type="text" name="zhiwei" id="" value="" />
			</p>
			
			
				
			<p>
				<span>员工位置</span>
				<select name="weizhi">
					<option value="-1">----请选择----</option>
<%
	for(FangJian f : list){
%>
					<option value="<%=f.getFno() %>"><%=f.getFno() %>房间人员状态<%=f.getZhuangtai() %></option>
<%
	}
%>					
				</select>
			</p>
			
			
			
			<p>
				<span>需求</span>
				<input type="text" name="xuqiu" id="" value="" />
			</p>	
			<p>
				<span>备注</span>
				<input type="text" name="beizhu" id="" value="" />
			</p>		

			
			<p>
				<button type="submit">添加</button>
			</p>
			<p>
				<a href="fuwulist.jsp"><button type="button">返回列表</button></a>
			</p>
		</form>
		
	</body>
</html>
