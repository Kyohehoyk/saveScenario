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
	<form:form method="post" action="regist" modelAttribute="UserRegistForm">
	<c:if test="${not empty errMsg}">
  		<div id="error">${errMsg}</div>
  	</c:if>
	<table id="login">
		<tr>
			<td>ログインID</td>
			<td><form:input path="loginId" /></td>
		</tr>
		<tr>
			<td>ニックネーム</td>
			<td><form:input path="nickname" /></td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td>確認用パスワード</td>
			<td><form:password path="confirmPassword" /></td>
		</tr>
		</table>
		<button type="submit" class="btn btn-primary">登録</button>
	</form:form>
</div>
</body>
</html>
