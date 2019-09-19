<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<%@include file="include/header.jsp" %>
		<script type="text/javascript">
			$(function(){
				$("#smit").click(function(){
					$("#loginForm").submit();
				})
				
				$("#imgv").click(function(){
					var date = new Date();
					$(this).attr("src","${pageContext.request.contextPath }/admin/imageValidateAction.do?d="+date);
				})
			})
		
		</script>
	</head>
	<body class="index">
		<div class="login_box">
			<form id="loginForm" action="${pageContext.request.contextPath }/admin/loginAction.do" method="post">
						<span class="required">${errorMsg}</span>	
				<table>
					<tr>
						<td class="login_info">账号：</td>
						<td colspan="2"><input name="acname" type="text" class="width150" /></td>
						<td class="login_error_info"><span class="required"></span></td>
					</tr>
					<tr>
						<td class="login_info">密码：</td>
						<td colspan="2"><input name="apwd" type="password" class="width150" /></td>
						<td><span class="required"></span></td>
					</tr>
					<tr>
	                    <td class="login_info">验证码：</td>
	                    <td class="width70"><input name="valicode" type="text" class="width70" /></td>
	                    <td><img id="imgv" src="${pageContext.request.contextPath }/admin/imageValidateAction.do" alt="验证码" title="点击更换" /></td>  
	                    <td><span class="required"></span></td>              
                	</tr>   
					<tr>
						<td></td>
						<td class="login_button" colspan="2"><a id="smit">
						<img src="${pageContext.request.contextPath }/assets/images/login_btn.png" /></a></td>
						<td><span class="required"></span></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
