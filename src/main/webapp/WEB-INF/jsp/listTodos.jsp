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
<h2>User Details Table</h2>
<table class="table">
<thead>
<tr>
<th>Id</th>
<th>Description</th>
<th>Target Date</th>
<th>isDone?</th>
<th>Operations</th>
</tr>
</thead>
<tbody>

<c:forEach items="${todos}" var="todo">
<tr>
<td><c:out value="${todo.id}" /></td>
<td>${todo.description}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
<td><a href ="delete?id=${todo.id}" class="btn btn-warning">Delete</a></td>
<td><a href ="update?id=${todo.id}" class="btn btn-primary">Update</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="add-todo" class="btn btn-success">Add Details</a>

</div>

${todos}
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" rel="stylesheet"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js" rel="stylesheet"></script>
<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" rel="stylesheet"></script>
<script>


</script>
</body>
</html>

