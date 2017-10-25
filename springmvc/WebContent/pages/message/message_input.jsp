<%@ page language="java" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String message_input_url = basePath+"pages/message/echo.action";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form action="<%=message_input_url%>" method="post">
		请输入消息:<input type="text" name="msg" id="msg" value="battel symphony">
	</form>
</body>
</html>