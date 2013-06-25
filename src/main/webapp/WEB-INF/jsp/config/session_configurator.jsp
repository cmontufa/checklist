<%@ include file="../includes/include.jsp" %>
<sec:authorize access="isAuthenticated()">
	<form name="sessionConfigForm" id="sessionConfigForm" action="sessionConfig" method="POST">
		<p>Log4J Global Logging Level(Current Level: <c:out value="${currentLogLevel}"/>):&nbsp;
			<input type="text" name="log4jConfigText" id="log4JConfigText" maxLength="50"/>&nbsp;
		</p>
		<p>
			<input type="submit" name="submit"/>
	</form>
</sec:authorize>
<sec:authorize access="isAnonymous()">
	&nbsp;
</sec:authorize>