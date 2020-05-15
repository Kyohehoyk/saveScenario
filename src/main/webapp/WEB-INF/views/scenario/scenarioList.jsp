<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div id="contents">
<!--
	<table id="scenario-detail">	<tr><th>
	タイトル</th><th>作者</th><th>更新時間</th><th>システム</th><th>募集人数</th><th>応募人数</th><th>登録者</th></tr>
		<c:forEach items="${ScenarioListForm}" var="formLine">
		<tr>
			<td>
				<a href="<c:url value="../scenarioDetail/${formLine.id}"></c:url>"><c:out value="${formLine.title}" /></a>
				</td>
			<td><c:out value="${formLine.creater}" /></td>
			<td><c:out value="${formLine.updateTime}" /></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</c:forEach>
	</table>
 -->
<!-- 未実装：検索機能
<p><input type="text" name="example1"><button class="research"><i class="fas fa-search"></i></button></p>
-->
<div class="row">
	 <c:forEach items="${ScenarioListForm}" var="formLine">
 		<div class="col-lg-3 offset-md-1 stone">
	 		<c:out value="${formLine.title}" /><br>
	 		製作者：<c:out value="${formLine.creater}" /><br>
	 		システム：<c:out value="${formLine.systemName}" /><br>
	 		募集人数：<c:out value="${formLine.participant}" /><br>
	 		想定時間：<c:out value="${formLine.estimatedTime}" /><br>
	 		<a href="<c:url value="../scenarioDetail/${formLine.id}"></c:url>" class="btn stretched-link"></a>
 		</div>
 	</c:forEach>
</div>
<div class="pagination">
<p class="center">
	<c:if test="${nowPage != 1}">
		<c:if test="${1 != beforePage}">
			<a href="<c:url value="../scenarioList/1"></c:url>">1</a>
			...
		</c:if>
		<a href="<c:url value="../scenarioList/${beforePage}"></c:url>"></a>
	</c:if>
	${nowPage}
	<c:if test="${nowPage != lastPage && lastPage > 0}">
		<a href="<c:url value="../scenarioList/${afterPage}"></c:url>">></a>
		<c:if test="${afterPage != lastPage}">
			...
			<a href="<c:url value="../scenarioList/${lastPage}"></c:url>">${lastPage}</a>
		</c:if>
	</c:if>
</p>
</div>
</div>
</body>
</html>
