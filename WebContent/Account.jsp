<%@ include file="EnTete.jsp"%>
<div id="page">
	<br><br>
	<center>
		
			
				<h2>User information </h2>
			<table>
			<tr><td>Username</td><td><%=((User)request.getAttribute("user")).getPseudo() %></td></tr>
			<tr><td>Password</td><td>****</td></tr>
			<tr><td>Email</td><td><%=((User)request.getAttribute("user")).getEmail() %></td></tr>
			<tr><td>First name</td><td><%=((User)request.getAttribute("user")).getPrenom() %></td></tr>
			<tr><td>Last name</td><td><%=((User)request.getAttribute("user")).getNom() %></td></tr>
			<tr><td>Language</td>
				<td><%if(((User)request.getAttribute("user")).getId_langue() == 1){ %>
						Français
					<%} else { %>
						English
					<%} %>
				</td></tr>
			<tfoot>
				<tr>
					<td></td><td>
						<a href="editUser" title="Account">Edit user</a>
					</td>

				</tr>
			</tfoot>
		</table>
	</center>
</div>
</body>
</html>