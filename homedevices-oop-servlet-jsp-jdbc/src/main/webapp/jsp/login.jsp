<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div class="main">
			<h2>Login</h2>
			<div>
				<form action="login" method="post">
					<table>
						<tr>
			            	<td>Username</td>
			        		<td><input type="text" name="username" required></td>
		        		</tr>
		        		<tr>
			        		<td>Password</td>
			        		<td><input type="password" name="password" required></td>
		        		</tr>
		        		<tr>
		        			<td><button type="submit" value="Submit">Submit</button></td>
		        		</tr>
	        		</table>
	        	</form>
			</div>
		</div>
	</body>
</html>