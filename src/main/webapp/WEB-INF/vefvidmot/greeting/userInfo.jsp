<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<head>
<meta charset="utf-8">
<title>G��an daginn!</title>
<style type="text/css">
	.navbar {
		display: flex;
		justify-items: flex-start;
		background-color: black;
		padding-left: 5px;
		padding-top: 5px;
		padding-bottom: 5px;
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
	
	h1 {
		font-size: 2.5em;
		margin-bottom: -24px;
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
	    margin-left: -5px;
	    margin-top: 16px;
	}
	
	.submit form {
		margin-left: 5px;
	}
</style>
</head>
<body>
	<div class="navbar">
		<a href="/greeting/spyrjaNotanda">
			<div class="navoption"
				<p>Upphaf</p>
			</div>
		</a>
	</div>
	<div class="content">
		<h1>Góðan daginn ${userInfo.getName()}</h1>
		<h4>Þínar líkamsupplýsingar:</h4>
		<table>
			<tr>
				<td>Þyngd:</td>
				<td>${userInfo.getWeight()}</td>
			</tr>
			<tr>
				<td>Hæð:</td>
				<td>${userInfo.getHeight()}</td>
			</tr>
			<tr>
				<td>Aldur:</td>
				<td>${userInfo.getAge()}</td>
			</tr>
		</table>
		<h4>Nauðsynleg dagleg næring</h4>
		<table>
			<tr>
				<td>BMR:</td>
				<td>${userInfo.getBmr()}</td>
			</tr>
			<tr>
				<td>FAT</td>
				<td>${userInfo.nutrition.fat }</td>
			</tr>
			<tr>
				<td>CARBS</td>
				<td>${userInfo.nutrition.carbs }</td>
			</tr>
			<tr>
				<td>PROTEIN</td>
				<td>${userInfo.nutrition.protein }</td>
			</tr>
		</table>
		<div class="submit">
			<form method="POST" action="spyrjaNotanda">
				<input type="submit" value="Hreinsa" />
			</form>
			<form method="GET" action="foodList">
				<input type="submit" value="Áfram">
			</form>
		</div>
	</div>
</body>

</html>