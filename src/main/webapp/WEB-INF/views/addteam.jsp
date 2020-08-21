<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>

</head>
<body>
<form:form method="POST" align="center"  modelAttribute="team"  class="form-horizontal" action="addNewTeam">
	
 <table>
	
	<tr>
		<td><label class="col-md-3 control-lable" for="OWNER">OWNER</label></td>
		<td><form:select path="OWNER" id="OWNER" class="form-control input-sm">
				        <form:option value="">Select OWNER</form:option>
			    	    <form:options items="${Owners}" />
				    </form:select></td>
		<td>
		<div class="has-error">
						<form:errors path="OWNER" class="help-inline"/> 
					</div>
					</td>
	</tr>
	<tr>
	<tr>
		<td><label class="col-md-3 control-lable" for="TOURNAMENT_NAME">TOURNAMENT NAME</label></td>
		<td><form:select path="TOURNAMENT_NAME" id="TOURNAMENT_NAME" class="form-control input-sm">
				        <form:option value="">Select Tournament</form:option>
			    	    <form:options items="${TourList}" />
				    </form:select></td>
		<td>
		<div class="has-error">
						<form:errors path="TOURNAMENT_NAME" class="help-inline"/> 
					</div>
					</td>
	</tr>
	<tr>
		<td><label class="col-md-3 control-lable" for="TOURNAMENT_TEAM">TOURNAMENT TEAM</label></td>
		<td><form:textarea rows="3" columns="5" path="TOURNAMENT_TEAM" id="TOURNAMENT_TEAM" class="form-control input-sm"/></td>
		<td>
		<div class="has-error">
						<form:errors path="TOURNAMENT_TEAM" class="help-inline"/>
					</div>
		</td>
	</tr>
	<tr>
	<td><input type="submit" value="Add TEAM" class="btn btn-primary btn-sm"></td>
	</tr>

</table>

 </form:form>

</body>
</html>