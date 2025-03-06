<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Action</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="main">
			<h2>Action</h2>
			<p>There are list of home devices below, you can choose the action</p>
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
				<h3>1 Sort devices by power:</h3>
				<button type="button" onclick='window.location.href="http://localhost:8080/homedevices-oop-servlet-jsp-jdbc/sort"'>Sort</button>
			</div>
			<br>
			<div>
				<h3>2 Filter devices by power range:</h3>
				<form action="filt">
					<table>
						<tr>
							<td>From:</td>
							<td><input type="number"  name="from" required><br></td>
						</tr>
			            <tr>
							<td>To:</td>
							<td><input type="number"  name="to" required><br></td>
						</tr>
		            </table>
		            <button type="submit" value="Submit">Filter</button>
            	</form>
            </div>
            <br>
            <div>
            	<h3>3 Turn on some devices and calculate its power</h3>
	            <form action="calc">
	            	<table>
		            	<c:forEach items="${devices}" var="device" varStatus="loop">
		            		<tr>
		            			<td><input type="checkbox" name="checked" value="${loop.index}"> ${devices.get(loop.index).getDescription()}</td>
							</tr>
						</c:forEach>
	            	</table>
	            	<button type="submit" value="Submit">Calculate</button>
	            </form>
        	</div>
        	<br>
        	<div>
				<button type="button" onclick='window.location.href="http://localhost:8080/homedevices-oop-servlet-jsp-jdbc/logout"'>Logout</button>
			</div>
		</div>
	</body>
</html>