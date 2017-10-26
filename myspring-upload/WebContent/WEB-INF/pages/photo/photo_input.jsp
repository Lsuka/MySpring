<%@ page language="java" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String photo_ipput_url = basePath + "pages/photo/upload.action";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<form action="<%=photo_ipput_url%>" method="post"
		enctype="multipart/form-data">
		请输入消息:<input type="text" name="msg" id="msg" value="哔哩哔哩干杯"><br>
		选择照片:<input type="file" name="photo" id="photo"><br> <input
			type="submit" value="发送"> <input type="reset" value="重制">
	</form>
</body>
</html>