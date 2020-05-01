<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 検索ボタン用のCSS読み込み -->
<link href="<c:url value="https://use.fontawesome.com/releases/v5.0.6/css/all.css" />"
	rel="stylesheet">
<!-- BootstrapのCSS読み込み -->
<link href="<c:url value="/resources/css/bootstrap/bootstrap.css" />"
	rel="stylesheet">
<!-- 作成CSS -->
<link href="<c:url value="/resources/css/header.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
<!-- jqueryのJS読み込み(bootstrap前に行う) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのJS読み込み -->
	<script src="/resources/js/bootstrap/bootstrap.min.js"></script>
<!-- フォント読み込み -->
<link href="<c:url value="https://fonts.googleapis.com/earlyaccess/kokoro.css" />"
	rel="stylesheet">
<title>シナリオ倉庫</title>
</head>
<body>
<div id="header">
<h1>シナリオまとめ</h1>
	<div id="top-menu">
		<ul>
			<li><a href="../scenarioList/">一覧表示</a></li>
			<li><a href="../scenarioAdd/">登録</a></li>
			<c:choose>
				<c:when test="${empty nickname}">
					<li><a href="../login/">ログイン</a></li>
					<li><a href="../userregist/">新規登録</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="../logout/">ログアウト</a></li>
					<li><a href="../mypage/">マイページ</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>
<br>
</body>
</html>