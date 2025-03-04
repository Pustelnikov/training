<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Start</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="main">
			<h1>Hello ${username}</h1>
			<h2>Task 3</h2>
			<h3>Home electrical devices</h3>
			<p>This app displays a typical list of home devices, calculates power consumption,
			 sorts the devices by power.</p>
			<br>
			<p>Push the button to start</p>
			<div>
				<button type="button" onclick='window.location.href="http://localhost:8080/homedevices-oop-servlet-jsp/start"'>Start</button>
			</div>
		</div>
	</body>
</html>
