<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
</head>
<body>
<h1 align="center">Team Points</h1>
   
<form>
<table align="center" id="t01" border="2" width="70%" cellpadding="2">
<tr><th>TEAM NAME</th><th>OWNER</th>
<th>TOURNAMENT NAME</th><th>TOTAL POINTS</th></tr>  

   <c:forEach var="team" items="${list}"> 
   <tr>  
   <td>${team.TEAM_NAME}</td>  
   <td>${team.OWNER}</a></td> 
   <td>${team.TOURNAMENT_NAME}</td>  
   <td>${team.TOTAL_POINTS}</td> 
   <td><a href="/Tournament/editpoints/${team.OWNER}&${team.TOURNAMENT_NAME}">Edit</a></td> 
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
  </form>
</body>
</html>