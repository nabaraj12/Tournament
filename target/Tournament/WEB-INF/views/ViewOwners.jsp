<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
</head>
<body>
<h1 align="center">Owners</h1>
   
<form>
<table align="center" id="t01" border="2" width="70%" cellpadding="2">
<tr><th>TEAM ID</th><th>TEAM_NAME</th>
<th>OWNER</th><th>LOCATION</th></tr>  

   <c:forEach var="team" items="${list}"> 
   <tr>  
   <td>${team.TEAM_ID}</td>  
   <td>${team.TEAM_NAME}</a></td> 
   <td>${team.OWNER}</td>  
   <td>${team.LOCATION}</td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
  </form>
</body>
</html>