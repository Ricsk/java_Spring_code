<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    <meta http-equiv="Context-Type" content="text/html; charset=ISO-8859-1">
    <title>主页</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>
    <body>
    	${user.userName},welcome, your code is :${user.credits};
    </body>
</html>