<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="is">

<head>
    <title>Food! </title>
    <style type="text/css">
	    .navbar {
			display: flex;
			justify-items: flex-start;
			background-color: black;
			padding-left: 5px;
			padding-top: 5px;
			padding-bottom: 5px;
			margin-bottom: 30px;
		}
		
		.navoption {
			display: flex;
		    align-items: center;
			background-color: black;
			padding: 20px;
			color: white;
			font-size: 1.3em;
			font-family: Arial;
			text-transform: uppercase;
		}
		
		.navoption:hover {
			background-color: #a9a9a9;
		}
		
		a {
			text-decoration: none;
		}
		
		.content {
			display: flex;
		    flex-direction: column;
		    align-items: center;
			font-size: 16px;
		}
		
		
		h4 {
			font-size: 2em;
			margin-bottom: 10px;
		}
		
		tr {
			display: flex;
		    justify-content: space-between;
		    margin-bottom: 4px;
		}
		
		.submit {
			display: flex;
		    justify-content: center;
		}
	</style> 
</head>
<body>
	<div class="navbar">
		<a href="askUser.jsp">
			<div class="navoption"
				<p>Upphaf</p>
			</div>
		</a>
	</div>
	<div class="content">
		<h4>${userInfo.getName()}, hefur þú borðað eitthvað í dag?</h4>
		<p>Veldu máltíð hér:</p>
		<form method="POST" name="foodVar" action="/greeting/moreInfo">
		<td>
		<select name="foodVar">
	    	<c:forEach items="${allFood}" var="foodItem">
	        	<option name="${foodItem.id }" value="${foodItem.id}" ${foodItem.id == selectedRole ? 'selected' : ''}>${foodItem.name}</option>
	    	</c:forEach>
		</select>
		</td>
		<td><input type="submit" value="Velja"/></td>
		</form>
	</div>
</body>
</html>