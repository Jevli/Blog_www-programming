<!DOCTYPE html>
<%@ include file="../../init.jspf" %>

<body>



<div class="info">
    <spring:message code="post.info.th" text="Max number of chars for post is 250"/>
</div>

<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script type="text/javascript">
tinymce.init({
    selector: "textarea",
    menubar: false
 });
</script>

<form method="POST"  action="addPost">
    <textarea name="post" rows="10", cols="50", maxlength="250"></textarea>
    <input type="submit" value="<spring:message code="post.newPost.th" text="Post new message"/>" />
</form>

</body>