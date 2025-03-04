<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Result</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="main">
			<h2>Filtering result</h2>
			<p> Filtered devices by power range from ${from} to ${to}</p>
			<br>
			<div>
				<table>
					<c:forEach items="${devices}" var="device">
						<tr>
							<td>${device.toString()}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br>
			<div>
				<button type="button" onclick='window.location.href="http://localhost:8080/homedevices-oop-servlet-jsp/start"'>Return</button>
			</div>
		</div>
	</body>
</html>
