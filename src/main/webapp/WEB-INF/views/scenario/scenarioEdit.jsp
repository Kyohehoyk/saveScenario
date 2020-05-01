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
<form:form method="post" action="update" modelAttribute="ScenarioEditForm">
	<h2><c:out value="${ScenarioEditForm.title}" />　<input type="submit" value="シナリオ削除" /></h2>
	<form:hidden path="sessionId" value="${ScenarioEditForm.id}"></form:hidden>
	製作者：${ScenarioEditForm.creater}<br>
	システム：${ScenarioEditForm.systemName}<br>
	募集人数：${ScenarioEditForm.participant}<br>
	想定時間：${ScenarioEditForm.estimatedTime}<br>
	<br>
	<br>
	<c:if test="${ScenarioEditForm.systemInfo==1}">
		推奨技能　：<form:input path="recommendedSkill" value="${ScenarioEditForm.recommendedSkill}" size="50"></form:input><br>
		準推奨技能：<form:input path="associateRecommendedSkill" value="${ScenarioEditForm.associateRecommendedSkill}" size="50"></form:input><br>
		非推奨技能：<form:input path="nonRecommendedSkill" value="${ScenarioEditForm.nonRecommendedSkill}" size="50"></form:input><br>
	</c:if>
	<br>
	<br>
	シナリオの概要<br>
	<form:textarea path="summary" value="${ScenarioEditForm.summary}" cols="80" rows="6"></form:textarea>
	<br>
	画像<br>
	<br>
	通過者：<br>
	<c:forEach items="${ScenarioEditForm.joinParticipant}" var="joinParticipant">
		<form:hidden path="joinParticipant[${joinParticipant.no}].no" value="${joinParticipant.no}"></form:hidden>
		<form:hidden path="joinParticipant[${joinParticipant.no}].id" value="${joinParticipant.id}"></form:hidden>
		${joinParticipant.nickname}：<form:input path="joinParticipant[${joinParticipant.no}].passing" value="${joinParticipant.passing}"></form:input><br>
		<form:hidden path="joinParticipant[${joinParticipant.no}].nickname" value="${joinParticipant.nickname}"></form:hidden>

	</c:forEach>
	<input type="submit" value="保存" />
</form:form>
</div>
</body>
</html>
