<!DOCTYPE html>
<%@ include file="../../init.jspf" %>

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
    <spring:message code="post.info.th" text="Max number of chars for post is 250"/>
</div>

<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script scr="<c:url value='/resources/js/fileUpload.js' />"></script>
<script type="text/javascript">
tinymce.init({
    selector: "textarea",
    menubar: false
 });
</script>

<form name="postForm" method="POST"  action="addPost">
	Date: <input name="title" type="text" id="datepicker" readonly>
    <textarea name="post" rows="10" cols="50" maxlength="250"></textarea>
    File name: <input name="fileName" type="text" value="" readonly>
    <input type="button" value="Add file" onclick="addFile()"> <br/>
    <input type="submit" value="<spring:message code="post.newPost.th" text="Post new message"/>" />
</form>

</body>