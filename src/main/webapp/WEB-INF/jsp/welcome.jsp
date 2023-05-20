<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<body>
<%@ include file="common/navigition.jspf"  %>
<div class="container">
<h2>
Welcome ${name}
</h2>
<a class="link-item" href="todos">Manage Data</a>
</div>
</body>
</head>
</html>