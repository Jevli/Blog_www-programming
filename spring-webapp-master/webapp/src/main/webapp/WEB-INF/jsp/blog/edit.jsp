<!DOCTYPE html>
<%@ include file="../../init.jspf" %>

<spring:url value="/blog/postEdit/" var="editPostUrl" htmlEscape="true"/>

<script>
	function addFile() {
		addFileWindow = open("/file/upload", "upload", 'resizable=no,width=500,height=250');
		if (addFileWindow.opener == null) addFileWindow.opener = self;
	}
	
	$(function() {
	    $( "#datepicker" ).datepicker();
	});
</script>

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
	Date: <input name="title" type="text" id="datepicker" value="${post.title}" readonly>
    <textarea name="post" rows="10" cols="50" maxlength="250"><c:out value="${post.post}"/></textarea>
    File name: <input name="fileName" type="text" value="${post.fileName}" readonly>
    <input type="button" value="Add file" onclick="addFile()"> <br/>
    <input type="submit" value="<spring:message code="edit.editPost.th" text="Update message"/>" />
</form>

</body>