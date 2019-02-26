<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pageUrl" required="true" rtexprvalue="true"
	description="分页页面对应的URL"%>
<%@ attribute name="pageAttrKey" required="true" rtexprvalue="true"
	description="Page对象在Request域中的键名称" %>
<c:set var="pageUrl" value="${pageUrl}" />
<!-- 将一些标签中需要引用的对象放置到pageConext属性中以便后面可以直接通过EL表达式引用 -->
<%
	String separator = pageUrl.indexOf("?") > -1?"&":"?";
	jspContext.setAttribute("pageReslut", request.getAttribute(pageAttrKey));
	jspContext.setAttribute("pageUrl", pageUrl);
	jspContext.setAttribute("seprator", separator);
%>
<!-- 构造分页导航栏 -->
<div style="font:12px;background-color:#DDDDDD">
	共${pageResult.totalPageCount }页，第${pageResult.currentPageNo }页
	<c:if test="${pageResult.currentPageNo <= 1 }">
		首页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.currentPageNo > 1 }">
	<a href="<c:url value="${pageUrl }"/>
		${separator }pageNo=1">首页
		</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.hasPreviousPage }">
		<a href="<c:url value="${pageUrl }"/>
		${separator }pageNo=${pageResult.currentPageNo - 1 }">
		上一页</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${!pageResult.hasPreviousPage }">
		上一页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.hasNextPage }">
		<a href="<c:url value="${pageUrl }"/>
		${sparator }pageNo=${pageResult.currentPageNo + 1 }">
		下一页
		</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${!pageResult.hasNextPage }">
		下一页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.currentPageNo >= pageResult.totalPageCount}">
		末页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.currentPageNo < pageResult.totalPageCount }">
		<a href="<c:url value="${pageUrl }"/>
		${separator }pageNo=${pageResult.totalPageCount }">
		末页</a>&nbsp;&nbsp
	</c:if>
</div>