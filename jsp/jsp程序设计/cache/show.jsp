<% taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<c:choose>
		<c:when test="{param.portchoice=='news'}">
		<jsp:include page="news.jsp"/>
		</c:when>
		<c:when test="{param.portchoice=='weather'}">
		<jsp:include page="weather.jsp"/>
		</c:when>
	</c:choose>
</html>
