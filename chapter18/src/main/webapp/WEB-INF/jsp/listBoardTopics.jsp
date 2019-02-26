<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sum.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="xiaochun" tagdir="/WEB-INF/tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>论坛版块页面</title>
	</head>
	<body>
		<%@ include file="includeTop.jsp" %>
		<div>
			<table boarder="1px" width="100%">
				<tr>
					<c:if test="${USER_CONTEXT.userType == 2 || isboardManager }">
						<td></td>
					</c:if>
						<td bgcolor="#EEEEEE">
							${board.boardName }
						</td>
						<td colspan="4" bgcolor="#EEEEEE" align="right">
						<a href="<c:url value="/board/addTopicPage-${board.boardId }.html"/>">
							发表新话题
						</a>
						</td>
			</tr>
			<tr>
				<c:if test="${USER_CONTEXT.userType == 2 || isboardManager }">
					<td>
						<script>
							function switchSelectBox(){
								var selectBoxs = document.all("topicIds");
								if(!selectBoxs) return;
								if(typeof(selectBoxs.length)=="undefined"){
									selectBoxs.checked = event.srcElement.checked;
								}else{
									for(var i = 0;i < selectBoxs.length;i++){
										selectBoxs[i].checked = event.srcElement.checked;
									}
								}
							}
						</script>	
						<input type="checkbox" onclick="switchSelectBox()"/>
					</td>
				</c:if>
					<td width="50%">标题</td>
					<td width="10%">发表人</td>
					<td width="10%">回复数</td>
					<td width=15%>发表时间</td>
					<td width=15%>最后回复时间</td>
			</tr>
			<!-- 判断用户是否是该版块的管理员 -->
			<c:set var="isboardManager" value="${false }"/>
			<c:forEach items="${USER_CONTEXT.manBoards }" var="manBoard">
				<c:if test="${manBoard.boardId == board.boardId}">
					<c:set var="isboardManager" value="${true }"/>
				</c:if>
			</c:forEach>
			<!-- 对保存在page对象中的分页数据进行渲染，来显示一页的数据 -->
			
			<c:forEach var="topic"  items="${pagedTopic.result }">
				<tr>
					<!-- 如果是论坛版块管理员或者论坛管理员，则显示批量操作的复选框 -->
					<c:if test="${USER_CONTEXT.userType == 2 || isboardManager }" >
						<td>
							<input type="checkbox" name="topicIds" value="${topic.topicId }"/>
						</td>
					</c:if>
						<td>
							<a href="<c:url value="/board/listTopicPosts-${topic.topicId}.html"/>">
								<!-- 如果是精华帖子，则附加星号 -->
								<c:if test="${topic.digest > 0 }">
									<font color=red>※</font>
								</c:if>
								${topic.topicTitle }
							</a>
						</td>
						<td>${topic.user.userName }<br><br></td>
						<td>${topic.replies }<br><br></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${topic.createTime }" /></td>
						<td><fmt:formateDate pattern="yyyy-MM-dd HH:mm"
							value="${topic.lastPost }"/></td>
				</tr>
			</c:forEach>
			</table>
		</div>
		<!-- 分页显示导航栏 -->
		<xiaochun:PageBar
			pageUrl="/board/listBoardTopics-${board.boardId }.html"
			pageAttrKey="pagedTopic"/>
			<!-- 如果是论坛版块管理员或者论坛管理员，则显示批量操作的按钮 -->
			<c:if test="${USER_CONTEXT.userType == 2 || isboardManager }">
			<script>
				function getSelectedTopicIds(){
					var selectBoxs = document.all("topicIds");
					if(!selectBoxs) return null;
					if(typeof(selectBoxs.length) == "undefined" && selectBoxs.checked){
						return selectBoxs.value;
					}else{
						var ids = "";
						var split = ""
						for(var i = 0;i < selectBoxs.length;i++){
							if(selectBoxs[i].checked){
								ids += split + selectBoxs[i].vlaue;
								split = ",";
							}
						}
						return ids;
					}
				}
				function deleteTopics(){
					var ids = getSelectedTopicIds();
					if(ids){
						var url = "<c:url value="/board/removeTopic.html"/>?topicIds="+
								ids+"$boardId=${board.boardId}";
						location.href = url;
					}
				}
				function setDefinedTopic(){
					var ids = getSelectedTopicIds();
					if(ids){
						var url = "<c:url value="/board/makeDigestTopic.html"/>?topicIds="+
								ids+"&boardId=${board.boardId}";
						location.href = url;
					}
				}
			</script>
			<input type="button" value="删除" onclick="deleteTopics()">
			<input type="button" value="置精华贴" onclick="setDefinedTopics()">
		</c:if>
	</body>
</html>