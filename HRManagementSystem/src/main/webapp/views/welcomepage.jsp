<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>HR Management System</title>

<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


</head>
<body>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a class="navbar-brand">HR Management System</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<li><a href="/addEmployee">Add Employee</a></li>
					<li><a href="/showLatestEntries">Last Added Employees</a></li>
					<li><a href="/sortByNameASC">Sort By First Name</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='ADD_EMPLOYEE'}">
			<div class="container text-center">
				<h3>Add/Edit Employee</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="saveEmployee">
					<input type="hidden" name="id" value="${employee.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="firstName"
								value="${employee.firstName }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="lastName"
								value="${employee.lastName }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Email </label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="email"
								value="${employee.email }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Address</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="address"
								value="${employee.address }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Country</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="country"
								value="${employee.country }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">City</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="city"
								value="${employee.city }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Postcode</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="postcode"
								value="${employee.postcode }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Telephone</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="telephone"
								value="${employee.telephone }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Salary</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="salary"
								value="${employee.salary }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="DONE" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_EMPLOYEES' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Employees</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
						<tr class="table-primary">
							<th scope="col">Employee ID</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email</th>
							<th scope="col">Address</th>
							<th scope="col">Country</th>
							<th scope="col">City</th>
							<th scope="col">Post Code</th>
							<th scope="col">Telephone</th>
							<th scope="col">Salary</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach var="employee" items="${employees}">
								<tr>
									<td> <c:out value="${employee.id}"/></td>  
									<td> <a href="/employeeInfo?id=${employee.id}"><c:out value="${employee.firstName}"/></a></td>      				
        							<td> <c:out value="${employee.lastName}"/> </td>
        							<td> <c:out value="${employee.email}"/></td>
        							<td> <c:out value="${employee.address}"/></td>
        							<td> <c:out value="${employee.country}"/></td>
        							<td> <c:out value="${employee.city}"/></td>
        							<td> <c:out value="${employee.postcode}"/></td>
        							<td> <c:out value="${employee.telephone}"/></td>
        							<td> <c:out value="${employee.salary}"/></td>
        							<td> <a href="/editEmployee?id=${employee.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td> <a href="/deleteEmployee?id=${employee.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>