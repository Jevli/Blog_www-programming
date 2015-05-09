<!DOCTYPE html>
<%@ include file="../../init.jspf" %>

<spring:url value="/blog/postEdit/" var="editPostUrl" htmlEscape="true"/>

<body>

<div class="info">
    <spring:message code="edit.info.th" text="Max number of chars for post is 250"/>
</div>

<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script type="text/javascript">
tinymce.init({
    selector: "textarea",
    menubar: false
 });
</script>

<form name="postForm" method="POST"  action="/blog/postEdit/${post.id}">
    <textarea name="post" rows="10", cols="50", maxlength="250"><c:out value="${post.post}"/></textarea>
    <input type="submit" value="<spring:message code="edit.editPost.th" text="Update message"/>" />
</form>

</body>