<%@ include file="../../init.jspf" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="bodyTemplate" />
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Default tiles template</title>
    <link href="<c:url value='/resources/css/css.css' />" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="<c:url value='/resources/js/js.js' />"></script>
</head>
<body>
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content">
            <tiles:insertAttribute name="menu" />


            <tiles:insertTemplate template="${bodyTemplate}" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>