<%@page import="dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="./display.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
	<%
	List<User> users = (List<User>) request.getAttribute("obj");
	String username = (String) request.getAttribute("username");
	%>
	   <div class="heading container">
            <h2 class="heading-title">
              Cricket Stars Hub Discover the profiles of your favorite
            </h2>
            <a href="./index.jsp" class="next-btn"><button id="login" >Add New </button></a>
        </div>
<br>




<div class="table-wrapper">
						<%
		for (User user : users) {
		%>
						<tr>
						<% if( username != null && username.equals(user.getUserName())) { %>
				<table class="fl-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Age</th>
							<th>Email</th>
							<th>Addres</th>
							<th>Phone</th>
							<th>Password</th>
							<th>Extra Actions</th>
						</tr>
					</thead>
					<tbody>

							<td><%= user.getUserId()%></td>
							<td><%= user.getUserName() %></td>
							<td><%= user.getUserAge() %> </td>
							<td><%= user.getUserEmail() %> </td>
							<td><%= user.getUserAddress() %> </td>
							<td><%= user.getUserPhone() %> </td>
							<td><%= user.getUserPassword() %> </td>
							<td>
								<div class="form__group field" id="btns">
                            <a href="UpdateServlet?id=<%= user.getUserId() %>"><button>Updated</button></a>  
                            <a  href="DeleteUserServlet?id=<%= user.getUserId() %>"><button id="login">Delete</button></a>
                        </div>
							</td> 
							<%} %> 
					    </tr>
<%
		}
		%>
					<tbody>
				</table>
			</div>


			<div class="table-wrapper"id="table-wrapper">
				<table class="fl-table">
					<thead class="fixed-header">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Age</th>
							<th>Email</th>
							<th>Addres</th>
							<th>Phone</th>
							<th>Password</th>
							<th>Extra Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
		for (User user : users) {
		%>
						<tr>
							<td><%= user.getUserId()%></td>
							<td><%= user.getUserName() %></td>
							<td><%= user.getUserAge() %> </td>
							<td><%= user.getUserEmail() %> </td>
							<td><%= user.getUserAddress() %> </td>
							<td><%= user.getUserPhone() %> </td>
							<td><%= user.getUserPassword() %> </td>
							<td>
								<div class="form__group field" id="btns">
                            <a href="UpdateServlet?id=<%= user.getUserId() %>"><button>Updated</button></a>  
                            <a  href="DeleteUserServlet?id=<%= user.getUserId() %>"><button id="login">Delete</button></a>
                        </div>
							</td>  
					    </tr>
<%
		}
		%>
					<tbody>
				</table>
			</div>

</body>

</html>