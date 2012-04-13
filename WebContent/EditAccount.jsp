<%@ include file="EnTete.jsp"%>
<div id="page">
	<br><br>
	<center>
		<form name="firstForm" action="editUser" method="POST" 
             style="width:50%;margin:auto;padding-bottom:15px;">
		
			<div style="text-align:left;">		
				<h2 style="color:black;">Edit user information</h2>
				<table>
				<tr><td>Username :</td><td> <input type="text" name="pseudo" value=<%=((User)request.getAttribute("user")).getPseudo() %> onclick="pseudo.value='';" /></td></tr>
				<tr><td>Email : </td><td><input type="text" name="email" value=<%=((User)request.getAttribute("user")).getEmail() %> onclick="email.value='';" /></td></tr>
				<tr><td>First name : </td><td><input type="text" name="prenom" value=<%=((User)request.getAttribute("user")).getPrenom() %> onclick="prenom.value='';" /></td></tr>
				<tr><td>Last name :</td><td> <input type="text" name="nom" value=<%=((User)request.getAttribute("user")).getNom() %> onclick="nom.value='';" /></td></tr>
				<tr><td>Language :</td><td>
					<%if (((User)request.getAttribute("user")).getId_langue() == 1){%>
						<select name="langue">
							<option> English</option>
							<option selected> Français</option>
						</select>
					<%} else { %>
						<select name="langue">
							<option selected> English</option>
							<option> Français</option>
						</select>
					<%} %>
							</td></tr>
				<tr><td><p style="width:50%;margin:auto;"></td><td><input type="submit" name="bouton" value="Submit"/></p></td></tr>
				</table>
			</div>
		</form>	
	</center>
</div>

</body>
</html>