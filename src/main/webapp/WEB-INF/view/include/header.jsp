<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global.css" />
<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global_color.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	var admin = '${admin}';
	if(admin==""){
		location.href="${pageContext.request.contextPath}/view/login.jsp";
	}
</script>

