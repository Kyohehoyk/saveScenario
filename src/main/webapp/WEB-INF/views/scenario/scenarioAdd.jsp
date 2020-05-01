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
	<form:form method="post" action="regist" modelAttribute="ScenarioLAddForm">
	<c:if test="${not empty errMsg}">
  		<div id="error">${errMsg}</div>
  	</c:if>
	<table id="scenario-add">
		<tr>
			<td>シナリオタイトル</td>
			<td><form:input path="title" /></td>
		</tr>
		<tr>
			<td>シナリオ作者</td>
			<td><form:input path="creater" /></td>
		</tr>
		<tr>
			<td>参加人数</td>
			<td><form:input path="participant" /></td>
		</tr>
		<tr>
			<td>想定時間</td>
			<td><form:input path="estimatedTime" /></td>
		</tr>
		<tr>
			<td>システム</td>
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
