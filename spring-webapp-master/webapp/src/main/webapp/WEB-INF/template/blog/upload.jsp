<%@ include file="../../init.jspf" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link href="<c:url value='/resources/css/blog.css' />" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="<c:url value='/resources/js/js.js' />"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
</head>

<body>

<div class="wrapper">

    <header class="header">
    </header><!-- .header-->

    <div class="middle">

        <div class="posts">
            <main class="content">
                <tiles:insertAttribute name="bodyTemplate" />
        </div><!-- .container-->

    </div><!-- .middle-->

    <footer class="footer">
        <tiles:insertAttribute name="footer" />
    </footer><!-- .footer -->

</div><!-- .wrapper -->

</body>
</html>