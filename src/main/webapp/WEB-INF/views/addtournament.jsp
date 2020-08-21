<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
<title>Add Tournament Details</title>
</head>
<body>
<div class="form-container">
<h1 align="center">Add Tournament</h1>
<form:form method="POST" align="center"  modelAttribute="tournament"  class="form-horizontal" action="save">
	
 <table>
	<tr>
		<td><label class="col-md-3 control-lable" for="TOURNAMENT_NAME">TOURNAMENT NAME</label></td>
		<td><form:input type="text" path="TOURNAMENT_NAME" id="TOURNAMENT_NAME" class="form-control input-sm"/></td>
		<td>
		<div class="has-error">
						<form:errors path="TOURNAMENT_NAME" class="help-inline"/>
					</div>
		</td>
	</tr>
	<tr>
		<td><label class="col-md-3 control-lable" for="PRIZE_MONEY">PRIZE MONEY</label></td>
		<td><form:input type="text" path="PRIZE_MONEY" id="PRIZE_MONEY" class="form-control input-sm"/></td>
		<td>
		<div class="has-error">
						<form:errors path="PRIZE_MONEY" class="help-inline"/> 
					</div>
					</td>
	</tr>
	<tr>
	<td><input type="submit" value="Add Tournament" class="btn btn-primary btn-sm"></td>
	</tr>

</table>

 </form:form>

</body>
</html>