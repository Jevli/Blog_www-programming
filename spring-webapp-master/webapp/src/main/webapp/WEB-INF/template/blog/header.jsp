<%@ include file="../../init.jspf" %>

<spring:url value="?language=en" htmlEscape="true" var="enUrL"/>
<spring:url value="?language=fi" htmlEscape="true" var="fiUrL"/>

<spring:url value="/blog/index" var="homeUrl" htmlEscape="true"/>
<spring:url value="/login" var="loginUrl" htmlEscape="true"/>
<spring:url value="/j_spring_security_logout" var="logoutUrl" htmlEscape="true"/>
<spring:url value="/blog/manage" var="manageUrl" htmlEscape="true"/>

<p>
    <a href="${homeUrl}"><spring:message code="menu.home.th" text="Home" /></a>
    &nbsp;&nbsp;|&nbsp;&nbsp;

    <c:choose>
        <c:when test="${logedin}">
            <a href="${logoutUrl}"><spring:message code="menu.logout.th" text="Logout" /></a>

            <c:choose>
                <c:when test="${admin}">
                    &nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="${manageUrl}"><spring:message code="menu.manage.th" text="Manage Accounts"/></a>
                </c:when>
            </c:choose>

        </c:when>

        <c:otherwise>
            <a href="${loginUrl}"><spring:message code="menu.login.th" text="Login" /></a>
        </c:otherwise>
    </c:choose>

    &nbsp;&nbsp;|&nbsp;&nbsp;
   <a href="${enUrL}"><spring:message code="menu.english.th" text="English" /></a>
   &nbsp;&nbsp;|&nbsp;&nbsp;
   <a href="${fiUrL}"><spring:message code="menu.finnish.th" text="Finnish" /></a>
<p>