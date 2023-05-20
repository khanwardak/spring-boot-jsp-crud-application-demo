<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="common/navigition.jspf"  %>
<div class="container">
<h2>Add the Details Here</h>
<form:form method="post" class="form-group" modelAttribute="todo">
Description:<form:input type="text" class="form-control" path="description" required="required" id="targetDate"/>
<form:errors path="description"/>
Target Date:<form:input type="date" class="form-control" path="targetDate" required="required"/>
<form:errors path="targetDate"/>
<form:input type="hidden" class="form-control" path="id"/>
<form:input type="hidden" class="form-control" path="done"/>
<input type="submit" class="form-control" name="submit" value="Save"></input>
</form:form>
</div>

<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" rel="stylesheet"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js" rel="stylesheet"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">$('#targetDate').datepicker({
            format: 'yyyy-mm-dd',
            startDate: '-3d'
        });</script>

</body>
</html>