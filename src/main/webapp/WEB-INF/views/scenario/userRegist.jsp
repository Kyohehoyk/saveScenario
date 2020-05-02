<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="../common/header.jsp"/>
	<script src="<c:url value="/resources/js/scenario/errCheck.js" />"></script>
	<script src="<c:url value="/resources/js/scenario/userResgst.js" />"></script>
</head>
<body>
<div id="contents">
	<form:form method="post" action="regist" modelAttribute="UserRegistForm">
	<c:if test="${not empty errMsg}">
  		<div id="error">${errMsg}</div>
  	</c:if>
	<table id="login" class="nonborder">
		<tr>
			<td>ログインID<span class="red">(必須)</span></td>
			<td><form:input path="loginId" onBlur="chkLoginId()"/></td>
			<td>
				<span id="loginIdOK" style="display:none;"><span class="jsOK">✅</span></span>
				<span id="loginIdNG" style="display:none;"><span class="jsNG">❌</span></span>
			</td>
			<td>
				<span id="loginIdMsg"></span>
			</td>
		</tr>
		<tr>
			<td>ニックネーム<span class="red">(必須)</span></td>
			<td><form:input path="nickname" onBlur="chkNickname()" /></td>
						<td>
				<span id="nicknameOK" style="display:none;"><span class="jsOK">✅</span></span>
				<span id="nicknameNG" style="display:none;"><span class="jsNG">❌</span></span>
			</td>
			<td>
				<span id="nicknameMsg"></span>
			</td>
		</tr>
		<tr>
			<td>パスワード<span class="red">(必須)</span></td>
			<td><form:password path="password"  onBlur="chkPassword()" /></td>
			<td>
				<span id="passwordOK" style="display:none;"><span class="jsOK">✅</span></span>
				<span id="passwordNG" style="display:none;"><span class="jsNG">❌</span></span>
			</td>
			<td>
				<span id="passwordMsg"></span>
			</td>
		</tr>
		<tr>
			<td>確認用パスワード<span class="red">(必須)</span></td>
			<td><form:password path="confirmPassword" onBlur="chkConfirmPassword()" /></td>
						<td>
				<span id="confirmPasswordOK" style="display:none;"><span id="jsOK">✅</span></span>
				<span id="confirmPasswordNG" style="display:none;"><span id="jsNG">❌</span></span>
			</td>
			<td>
				<span id="confirmPasswordMsg"></span>
			</td>
		</tr>
		</table>
		<button type="submit" class="btn btn-primary">登録</button>
	</form:form>
</div>
</body>
</html>
