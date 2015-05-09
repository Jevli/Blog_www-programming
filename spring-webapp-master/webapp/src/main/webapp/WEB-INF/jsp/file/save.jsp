<%@ include file="../../init.jspf" %>

<h1>File Upload succeed</h1>
<button onclick="exit()">Click to continue!</button>

<script>
	function exit(){
		opener.document.postForm.fileName.value = "${filename}";
		self.close();
		return false;
	}
</script>