<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<html>
<head>
	<meta charset="UTF-8">
	<jsp:include page="../common/header.jsp"/>
</head>
<body>
<div id="contents">
<!-- 未実装：検索機能
<p><input type="text" name="example1"><button class="research"><i class="fas fa-search"></i></button></p>
-->

	<c:set var="data" value="0" />
	<c:set var="count" value="1" />
	<article>
	 <c:forEach items="${ScenarioListForm}" var="formLine">
	 	<c:if test="${data%21 == 0}">
	 		<section data-role="page" class=" page page${count}">
			<div class="row">
			<c:set var="count" value="${count + 1}" />
		</c:if>
 		<div class="col-lg-3 offset-md-1 stone">
	 		<c:out value="${formLine.title}" /><br>
	 		製作者：<c:out value="${formLine.creater}" /><br>
	 		システム：<c:out value="${formLine.systemName}" /><br>
	 		募集人数：<c:out value="${formLine.participant}" /><br>
	 		想定時間：<c:out value="${formLine.estimatedTime}" /><br>
	 		<a href="<c:url value="../scenarioDetail/${formLine.id}"></c:url>" class="btn stretched-link"></a>
 		</div>
 		<c:if test="${data%21 == 20}">
 			</div>
 			<div class="pagination">
				<p class="center">
 					<c:if test="${count>3}">
 						<a href="#1">1</a>
 						<c:if test="${count-3 > 1}">
 							...
 						</c:if>
 					</c:if>
 					<c:if test="${count-2>0}">
 						<a href="#${count-2}">${count-2}</a>
 					</c:if>
 					${count-1}
 					<a href="#${count}">${count}</a>
 					<c:if test="${lastPage>0 && count-1 != lastPage && count != lastPage}">
 						<c:if test="${count+1 != lastPage}">
 							...
 						</c:if>
 						<a href="#${lastPage}">${lastPage}</a>
 					</c:if>
 				</p>
			</div>
			</section>
		</c:if>
		<c:set var="data" value="${data + 1}" />
 	</c:forEach>

 	<c:if test="${data%21!=0 && count-2!=1}">
 		</div>
 		<div class="pagination">
			<p class="center">
 				<c:if test="${count-1!=1}">
 					<a href="#1">1</a>...
 				</c:if>
 				<c:if test="${count-2>0}">
 					<a href="#${count-2}">${count-2}</a>
 				</c:if>
 				${count-1}
				</section>
			</p>
		</div>
	</c:if>
 	</article>
</div>
<c:if test="${data==0}">
	<p>シナリオ情報がありません。</p>
</c:if>
<script src="<c:url value="/resources/js/scenario/list.js" />"></script>
</body>
</html>
