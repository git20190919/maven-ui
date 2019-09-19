<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@include file="include/header.jsp"%>
</head>
<body class="index">
	<div id="header">
		<span
			style="margin: 5px 5px;color: blue; font-size: 15px;font-weight: bold;">${admin.aname }</span>
		<%-- <img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="logo" class="left"/> --%>
		<a href="${pageContext.request.contextPath}/user/exitAction.do">[退出]</a>
	</div>
	<div id="index_navi">
		<ul id="menu">
			<c:forEach items="${admin.lp}" var="priv">
				<li><a href="${pageContext.request.contextPath}${priv.purl }"
					class="${priv.pclass}_off"></a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
