<%@ include file="EnTete.jsp"%>
<div id="page">
	<br><br>
	<% if(request.getAttribute("ok").equals("false")){%>
		<center>
			<p> Error, surname or email already exist</p>
		</center>
	<%} else if(request.getAttribute("ok").equals("null")){%>
		<center>
			<p> Error, fill in the blank please</p>
		</center>
		<%} %>
	<form name="CreateAccount" action="inscription" method="POST" 
             style="width:50%;margin:auto;padding-bottom:15px;">
		
		<div style="text-align:left;">		
			<h2 style="color:black;">Create an account</h2>
			<table>
			<tr><td>Username : </td><td><input type="text" name="username" /></td></tr>
			<tr><td>Password :</td><td> <input type="password" name="password" /></td></tr>
			<tr><td>Email : </td><td><input type="text" name="email" /></td></tr>
			<tr><td>First name : </td><td><input type="text" name="prenom" /></td></tr>
			<tr><td>Last name : </td><td><input type="text" name="nom" /></td></tr>
			<tr><td>Language : </td><td><select name="langue">
							<option selected> --Select a language--</option>
							<option> English</option>
							<option> Français</option>
						</select>
			</td></tr>
			
			<tr><td></td><td><p style="width:50%;margin:auto;"><input type="submit" name="bouton" value="Submit"/></p></td></tr>
			</table>
		</div>
	</form>
</div>
</body>
</html>