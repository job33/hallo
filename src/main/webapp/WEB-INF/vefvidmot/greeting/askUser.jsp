<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<head>
<meta charset="utf-8">
<title>Uppl�singar</title>
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


h4 {
	font-size: 2em;
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
		<a href="/greeting/spyrjaNotanda">
			<div class="navoption"
				<p>Upphaf</p>
			</div>
		</a>
	</div>
	<div class="content">
		<h4>Nauðsynlegar upplýsingar</h4>
		<form method="POST" commandName="userInfo" action="/greeting/aboutDiet">
			<table>
				<tr>
					<td>Nafn</td>
					<td><input name="name" type="text" placeholder="Nafn" /></td>
				</tr>
				<tr>
					<td>Aldur</td>
					<td><input name="age" type="number" min="10" max="110" /></td>
				</tr>
				<tr>
					<td>Hæð(cm)</td>
					<td><input name="height" type="number" min="130" max="230" /></td>
				</tr>
				<tr>
					<td>Þyngd(kg)</td>
					<td><input name="weight" type="number" min="35" max="180" /></td>
				</tr>
				<div>
				<tr>
					<td>Kyn:</td>
					<td><input type="radio" id="male" name="gender" path="gender" value="M" label="Karl"/><label for="male">Karl</label>
						<input type="radio" id="female" name="gender" path="gender" value="F" label="Kona" /><label for="female">Kona</label></td>
				</tr>
				</div>
				<div>
					<tr>
						<td>Fjöldi æfinga í hverri viku</td>
					</tr>
					<tr>
					<td>
						<input type="radio" id="0-1" name="workout" path="workout" value="1"/><label for="0-1">0-1</label>
						<input type="radio" id="2-3" name="workout" path="workout" value="2"/><label for="1-3">2-3</label>
						<input type="radio" id="4-5" name="workout" path="workout" value="3"/><label for="1-3">4-5</label>
						<input type="radio" id="6-7" name="workout" path="workout" value="4"/><label for="1-3">6-7</label>
						<input type="radio" id="8" name="workout" path="workout" value="5"/><label for="1-3">8+</label>	
					</td>
					</tr>
				</div>
				<div>
					<tr>
						<td>Markmið</td>
					</tr>
					<tr>
					<td>
						<input type="radio" id="light" name="goal" path="goal" value="1"/><label for="light">Léttast</label>
						<input type="radio" id="avg" name="goal" path="goal" value="2"/><label for="avg">Viðhalda</label>
						<input type="radio" id="heavy" name="goal" path="goal" value="3"/><label for="heavy">Þyngjast</label>
					</td>
					</tr>
				</div>
			</table>
			<div class="submit">
				<input type="submit" value="Áfram" />
			</div>
		</form>
	</content>
</body>

</html>