<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="../common/header.jsp"/>
	<script src="<c:url value="/resources/js/scenario/errCheck.js" />"></script>
	<script src="<c:url value="/resources/js/scenario/add.js" />"></script>
</head>
<body>
<div id="contents">
	<form:form method="post" action="regist" modelAttribute="ScenarioLAddForm">
	<c:if test="${not empty errMsg}">
  		<div id="error">${errMsg}</div>
  	</c:if>
  	<c:if test="${not empty msg}">
  		<div id="normal">${msg}</div>
  	</c:if>
	<table id="scenario-add" class="nonborder">
		<tr>
			<td>シナリオタイトル<span class="red">(必須)</span></td>
			<td><form:input path="title" onBlur="chkTitle()"/></td>
			<td>
				<span id="titleOK" style="display:none;"><span class="jsOK">✅</span></span>
				<span id="titleNG" style="display:none;"><span class="jsNG">❌</span></span>
			</td>
			<td>
				<span id="titleMsg"></span>
			</td>
			<td><span></span></td>
		</tr>
		<tr>
			<td>シナリオ作者<span class="red">(必須)</span></td>
			<td><form:input path="creater" onBlur="chkCreater()" /></td>
			<td>
				<span id="createrOK" style="display:none;"><span class="jsOK">✅</span></span>
				<span id="createrNG" style="display:none;"><span class="jsNG">❌</span></span>
			</td>
			<td>
				<span id="createrMsg"></span>
			</td>
		</tr>
		<tr>
			<td>参加人数</td>
			<td>
			<form:input path="participantStart" class="ws100" onBlur="chkParticipant()" />人〜
			<form:input path="participantEnd" class="ws100" onBlur="chkParticipant()" />人</td>
			<td>
				<span id="participantOK" style="display:none;"><span class="jsOK">✅</span></span>
				<span id="participantNG" style="display:none;"><span class="jsNG">❌</span></span>
			</td>
			<td>
				<span id="participantMsg"></span>
			</td>
		</tr>
		<tr>
			<td>想定時間</td>
			<td><form:input path="estimatedTimeStart" class="ws100" onBlur="chkEstimatedTime()" />時間〜
			<form:input path="estimatedTimeEnd" class="ws100" onBlur="chkEstimatedTime()" />時間</td>
			<td>
				<span id="estimatedTimeOK" style="display:none;"><span class="jsOK">✅</span></span>
				<span id="estimatedTimeNG" style="display:none;"><span class="jsNG">❌</span></span>
			</td>
			<td>
				<span id="estimatedTimeMsg"></span>
			</td>
		</tr>
		<tr>
			<td>システム<span class="red">(必須)</span></td>
			<td>
				<select name="systemInfo">
					<c:forEach var="system" items="${System}">
						<option value="${system.id}"><c:out value="${system.systemInfo}" /></option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</table>
		<button type="submit" class="btn btn-primary">登録</button>
	</form:form>
</div>
</body>
</html>
