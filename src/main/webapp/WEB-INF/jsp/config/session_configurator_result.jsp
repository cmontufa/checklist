<%@ include file="../includes/include.jsp" %>
<sec:authorize access="isAuthenticated()">
		<p>Log4J Global Logging Level was changed to: <c:out value="${newLog4JConfigText}"/>
		</p>
</sec:authorize>
<sec:authorize access="isAnonymous()">
	&nbsp;
</sec:authorize>