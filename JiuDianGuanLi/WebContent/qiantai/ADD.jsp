<%@ page import="com.yushi.entity.FangJian"%>
<%@ page import="java.util.List"%>
<%@ page import="com.yushi.Dao.FangJianDao"%>
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

		<form action="ADD.action" method="post">
		
			<p>
				<span>顾客姓名</span>
				<input type="text" name="gname" id="" value="" />
			</p>
			<p>
				<span>顾客电话</span>
				<input type="text" name="gtel" id="" value="" />
			</p>
			<p>
				<span>顾客身份证</span>
				<input type="text" name="gidc" id="" value="" />
			</p>
			<p>
				<span>房间号</span>
				<select name="ghsno">
				<option value="-1">----请选择----</option>
<%
	for(FangJian c : list){
%>
				<option value="<%=c.getFno()%>"><%=c.getFno() %><%=c.getZhuangtai() %></option>
<%
	}
%>					
				</select>
				
			</p>
						

			<p>
				<span>预约状态</span>
				<input type="radio" name="gyystate" id="1" value="已预约"/>已预约
				<input type="radio" name="gyystate" id="2" value="未预约"/>未预约
			</p>
			
			<p>
				<span>入住时间</span>
				<input type="date" name="gruzhutime" id="" value="" />
			</p>
			
			<p>
				<span>离店时间</span>
				<input type="date" name="gouttime" id="" value="" />
			</p>
			
			<p>
				<span>房间状态</span>
				<input type="radio" name="ghstate" id="1" value="空" >空
				
				<input type="radio" name="ghstate" id="2" value="满" />满
				
				<input type="radio" name="ghstate" id="3" value="满住1人" />满住1人
				<input type="radio" name="ghstate" id="4" value="满住2人" />满住2人
				
			</p>
		
			<p>
				<span>支付状态</span>
				<input type="radio" name="zhifustate" id="1" value="已支付" />已支付
				<input type="radio" name="zhifustate" id="2" value="未支付" />未支付
			</p>
			<p>
				<span>备注</span>
				<input type="text" name="beizhu" id="" value="" />
			</p>
			<p>
				<span>花费</span>
				<input type="text" name="huafei" id="" value="0" />
			</p>
			<p>
				<button type="submit">添加</button>
			</p>
			<div class="layui-btn-container">
			
 			<a href="List.jsp"><button type="button" class="layui-btn layui-btn-green">返回列表</button></a>
    		
    
			</div>
		</form>
	
		
	
		
		
	</body>
</html>
