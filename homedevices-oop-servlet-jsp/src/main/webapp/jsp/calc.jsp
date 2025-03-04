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
			<h2>Calculating result</h2>
			<p>Calculated power consumption of turned on devices</p>
			<br>
			<div>
				<table>
					<c:forEach items="${devices}" var="device">
							<c:if test="${device.isStatus()}">
								<tr>
									<td>${device.toString()}</td>
								</tr>
							</c:if>
					</c:forEach>
				</table>
			</div>
			<br>
			<div>
				Total power consumption: ${sumPower}
			</div>
			<br>
			<div>
				<button type="button" onclick='window.location.href="http://localhost:8080/homedevices-oop-servlet-jsp/start"'>Return</button>
			</div>
		</div>
	</body>
</html>
