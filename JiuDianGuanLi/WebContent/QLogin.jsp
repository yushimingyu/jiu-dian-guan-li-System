<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
    <%//用于管理员登陆 %>
    
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
		<form action="QLogin.action" method="post">
			<h1>
				管理员登录
			</h1>
			<p>
				<span>前台账号</span>
				<input type="text" name="qsno" id="" value="" />
			</p>
			<p>
				<span>前台密码</span>
				<input type="password" name="pass" id="" value="" />
			</p>
			<p class="btn-row">
				<button type="submit">登录</button>
			</p>
			
<%
	String errorInfo = (String)request.getAttribute("error");
	if(errorInfo!=null){
%>
			<p>
				<%=errorInfo %>
			</p>
<%		
	}
%>
			
		</form>
	</body>
</html>