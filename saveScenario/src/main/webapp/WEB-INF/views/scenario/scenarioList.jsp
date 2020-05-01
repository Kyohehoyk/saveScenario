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
	 		<c:out value="${formLine.title}" /></br>
	 		製作者<c:out value="${formLine.creater}" /></br>
	 		システム</br>
	 		募集人数</br>
	 		登録者</br>
	 		<a href="<c:url value="../scenarioDetail/${formLine.id}"></c:url>" class="btn stretched-link"></a>
 		</div>
 	</c:forEach>
</div>
</div>>
</body>
</html>
