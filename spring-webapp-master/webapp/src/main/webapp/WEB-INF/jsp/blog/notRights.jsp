<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:url value="/blog/index" var="indexUrl" htmlEscape="true"/>

<body>
<h1>You have no right to ${what} !</h1>

<div class="button">
    <button onclick="location.href='${indexUrl}'"><spring:message code="postAdded.moveIndex.th" text="Go back home"/></button>
</div>

</body>