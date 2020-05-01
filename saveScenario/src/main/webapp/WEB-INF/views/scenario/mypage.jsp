<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div id="contents">
	<p>登録したシナリオ</p>
	<table class="scenario-list">
		<tr><th>タイトル</th><th>作者</th><th>システム</th>
		<c:forEach items="${ScenarioRegistForm}" var="RegistLine">
			<tr>
				<td>
					<a href="<c:url value="../scenarioDetail/${RegistLine.id}"></c:url>"><c:out value="${RegistLine.title}" /></a>
				</td>
				<td><c:out value="${RegistLine.creater}" /></td>
				<td><c:out value="${RegistLine.system}" /></td>
			</tr>
		</c:forEach>
	</table>
	<p>通過したシナリオ</p>
	<table class="scenario-list">
		<tr><th>タイトル</th><th>作者</th><th>システム</th></tr>
		<c:forEach items="${PassForm}" var="PassForm">
			<tr>
				<td>
					<a href="<c:url value="../scenarioDetail/${PassForm.id}"></c:url>"><c:out value="${PassForm.title}" /></a>
				</td>
				<td><c:out value="${PassForm.creater}" /></td>
				<td><c:out value="${PassForm.system}" /></td>
			</tr>
		</c:forEach>
	</table>
	<p>応募中のシナリオ</p>
	<table class="scenario-list">
		<tr><th>タイトル</th><th>作者</th><th>システム</th><th>募集人数</th><th>登録者</th></tr>
		<c:forEach items="${SubscriptionForm}" var="subscriptionForm">
			<tr>
				<td>
					<a href="<c:url value="../scenarioDetail/${subscriptionForm.id}"></c:url>"><c:out value="${subscriptionForm.title}" /></a>
				</td>
				<td><c:out value="${subscriptionForm.creater}" /></td>
				<td><c:out value="${subscriptionForm.system}" /></td>
				<td><c:out value="${subscriptionForm.participant}" /></td>
				<td><c:out value="${subscriptionForm.register}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>