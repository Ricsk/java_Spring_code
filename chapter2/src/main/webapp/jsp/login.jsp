<%@ page languate="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http:java.sum.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
    	<title>小春论坛登陆</title>
    </head>
    <body>
    <c:if test="${!empyt error}">
    	<font color="red"><c:out value="${error}" /></font>
  	</c:if>
   	<form action="<c:url value="loginCheck.html "/>" method= "post">用户名：
    <input type="text" name="userName" >
    <br />
    密码：
    <input type="password" name="password">
    <br />
    <input type="submit" value="登陆"/>
    <input type="reset" value="重置"/>
    </form>
    </body>
    </html>