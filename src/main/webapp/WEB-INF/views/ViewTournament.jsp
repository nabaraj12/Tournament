<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/images/main_mod.css" type="text/css" />		
</head>
<body>
<div id="wrap">
	<div id="header">
		<h1 id="logo" align="center">Tournament View<span class="gray"></span></h1>
	</div>
 		<div id="main">
			<form action="ViewTournament">
				<table align="center" id="t01" border="2" width="70%" cellpadding="2">
					<tr><th>Id</th><th>Tournament Name</th>
					<th>Prize Money</th></tr>  

				   <c:forEach var="tournament" items="${list}"> 
				   <tr>  
				   <td>${tournament.TOURNAMENT_ID}</td>  
				   <td><a align="right" href="/Tournament/viewtourdetails/${tournament.TOURNAMENT_ID}">${tournament.TOURNAMENT_NAME}</a></td> 
				   <td>${tournament.PRIZE_MONEY}</td>
				  <td><a href="/Tournament/deletetournament/${tournament.TOURNAMENT_ID}">Delete</a></td>    
				   </tr>  
				   </c:forEach> 
				   
   				</table>
   				<table align="center">
   				<tr>
   				<td><a align="center" href="/Tournament/addtournament">Add New Tournament</a></td>
   				</tr>
   				</table>
   				  
   				<br/>
   
  
  			</form>
  		</div>
 </div>
</body>
</html>