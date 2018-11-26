<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
    	<title>删除用户</title>
    </head>
   	<body>
    	<form method="post" action="<c:url value="/user/delete.html"/>">
        <table>
        	<tr>
            	<td>用户ID:</td>
                <td><input type="text" name="userId"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="提交"/></td>
            </tr>
        </table>
      	</form>
   </body>
</html>