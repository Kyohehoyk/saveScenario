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
	<c:if test="${not empty errMsg}">
  		<div id="error">${errMsg}</div>
  	</c:if>
	<c:if test="${ScenarioDetailForm.register!=userId}">
		<form:form method="post" action="../request/${ScenarioDetailForm.sessionId}" modelAttribute="ScenarioDetailForm">
			<input type="submit" value="応募" />
		</form:form>
	</c:if>
	<c:if test="${ScenarioDetailForm.register==userId}">
		<form:form method="get" action="../scenarioEdit/${ScenarioDetailForm.sessionId}" modelAttribute="ScenarioDetailForm">
			<input type="submit" value="編集" />
		</form:form>
	</c:if>
	<h2><c:out value="${ScenarioDetailForm.title}" /></h2>
	登録者：${ScenarioDetailForm.registerName}
	製作者：${ScenarioDetailForm.creater}<br>
	KP/GM：${ScenarioDetailForm.nickname}<br>
	システム：${ScenarioDetailForm.systemName}<br>
	応募人数：${ScenarioDetailForm.participant}<br>
	想定時間：${ScenarioDetailForm.estimatedTime}<br>
	<br>
	<br>
	<c:if test="${ScenarioDetailForm.systemInfo==1}">
		推奨技能：${ScenarioDetailForm.recommendedSkill}<br>
		準推奨技能：${ScenarioDetailForm.associateRecommendedSkill}<br>
		非推奨技能：${ScenarioDetailForm.nonRecommendedSkill}<br>
	</c:if>
	<br>
	<br>
	シナリオの概要<br>
	${ScenarioDetailForm.summary}<br>
	<br>
	画像<br>
	<br>
	<br>
	通過者：<br>
	<c:forEach items="${ScenarioDetailForm.joinParticipant}" var="participant">
		<c:out value="${participant}" /><br>
	</c:forEach>
</div>
</body>
</html>
