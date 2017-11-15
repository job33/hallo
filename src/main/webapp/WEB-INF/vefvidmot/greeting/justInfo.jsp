<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<head>
	<title>Check</title>
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
		}
		
		tr {
			text-align: center;
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
	<h4>Svona gengur þér, ${userInfo.getName()}, að uppfylla þína næringarþörf</h4>
		<table>
		   <thead>
	       <tr>
	           <th></th>
	           <th>��rf</th>
	           <th>Bor�a�</th>
	           <th>Hlutfall komi�</th>
	        </tr>
	        </thead>
			<tr>
				<td>BMR:</td>
				<td>${userInfo.bmr }</td>
			</tr>
			<tr>
				<td>FAT</td>
				<td>${userInfo.nutrition.fat }</td>
				<td>${userInfo.nutrition.pfat }</td>
				<td>${userInfo.nutrition.procentFat }%</td>
			</tr>
			<tr>
				<td>CARBS</td>
				<td>${userInfo.nutrition.carbs }</td>
				<td>${userInfo.nutrition.pcar }</td>
				<td>${userInfo.nutrition.procentCarbs }%</td>
			</tr>
			<tr>
				<td>PROTEIN</td>
				<td>${userInfo.nutrition.protein }</td>
				<td>${userInfo.nutrition.ppro }</td>
				<td>${userInfo.nutrition.procentProtein }%</td>
			</tr>
		</table>
		<p>${userInfo.getName()}, hefur þú borðað eitthvað meira?</p>
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