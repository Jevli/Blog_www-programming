<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:url value="/blog/post" var="postURL" htmlEscape="true"/>
<spring:url value="/blog/editPost" var="editPost" htmlEscape="true"/>
<spring:url value="/blog/deletePost" var="deletePost" htmlEscape="true"/>

<body>
<c:set var="logedin" scope="session" value="${logedin}"/>
<c:choose>
    <c:when test="${logedin}">
        <div class="button">
            <button onclick="location.href='${postURL}'"><spring:message code="blog.newPost.th" text="Create new post"/></button>
        </div>
    </c:when>
    <c:otherwise>
        <div class="button">
            <spring:message code="blog.youneedto.th" text="You need to login for create new post"/>
        </div>
    </c:otherwise>
</c:choose>

<c:forEach items="${posts}" var="post" >
    <fieldset>
        <legend>
            &nbsp;<spring:message code="blog.sender.th" text="Sender"/>: ${post.user.userName}
            &nbsp;<spring:message code="blog.date.th" text="Date"/>: ${post.createdOn}
            &nbsp;
        </legend>
        <div class="postDiv">

            <p>${post.post}</p>

            <div class="postButtons">
                &nbsp;<button onclick="location.href='${editPost}/${post.id}'"><spring:message code="blog.edit.th" text="Edit"/></button>
                &nbsp;<button onclick="location.href='${deletePost}/${post.id}'"><spring:message code="blog.delete.th" text="Delete"/></button>
            </div>
        </div>
    </fieldset>
</c:forEach>
</body>

</html>