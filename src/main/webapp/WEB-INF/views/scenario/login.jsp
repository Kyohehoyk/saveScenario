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
	<form:form method="post" action="confirm" modelAttribute="LoginForm">
		<c:if test="${not empty errMsg}">
  			<div id="error">${errMsg}</div>
  		</c:if>
  		<div class="center">
  			<div>
	   			<img src="/saveScenario/resources/image/loginIcon.png" width="250" height="200"/>
  			</div>
			ログインID<br>
			<form:input path="loginId" /><br>
			パスワード<br>
			<form:password path="password" /><br>
			<button type="submit" class="btn btn-primary">ログイン</button>
		</div>
	</form:form>
</div>
</body>
</html>