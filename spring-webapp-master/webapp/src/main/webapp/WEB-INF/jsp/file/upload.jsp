<%@ include file="../../init.jspf" %>

<h1>Single File Upload</h1>
<form name="fileUpload" method="post" enctype="multipart/form-data" action='<spring:url value="/file/save" htmlEscape="true" />'>
	Upload File: <input type="file" name="file">
	<br/><br/>
	<input type="submit" onclick="updatePost()" value="Save file">
</form>