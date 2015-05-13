<!DOCTYPE html>
<%@ include file="../../init.jspf" %>

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
            &nbsp;<spring:message code="blog.sender.th" text="Sender"/>: <c:out value="${post.user.userName}" />
            &nbsp;<spring:message code="blog.created.th" text="Created"/>: <joda:format  pattern="HH.mm // dd.MM.yyyy"  value="${post.createdOn}"/>
            &nbsp;<spring:message code="blog.modified.th" text="Modified"/>: <joda:format  pattern="HH.mm // dd.MM.yyyy"  value="${post.modifiedOn}"/>
        </legend>
        <div class="postDiv">
        	<h1><fmt:formatDate type="date" value="${post.title}" /></h1>
			<h1><c:out value="${post.title}"></c:out></h1><br>
           	<p><c:out value="${post.post}"/></p><br>
           	
			<p>
				<div class="filename">
					File name: <c:out value="${post.fileName}"/>
				</div>
            	<div class="postButtons">
                	&nbsp;<button onclick="location.href='${editPost}/${post.id}'"><spring:message code="blog.edit.th" text="Edit"/></button>
                	&nbsp;<button onclick="location.href='${deletePost}/${post.id}'"><spring:message code="blog.delete.th" text="Delete"/></button>
            	</div>
            </p>
        </div>
    </fieldset>
</c:forEach>
</body>
</html>