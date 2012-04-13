<%@ include file="EnTete.jsp"%>
<div id="page">
	<br><br>
	<form name="firstForm" action="addRecord" method="POST" 
             style="width:50%;margin:auto;padding-bottom:15px;">
		
		<div style="text-align:left;">
		<table>
			<h2 style="color:black;">Add a record</h2>
			
			<tr><td>name :</td><td> <input type="text" name="name" /></td></tr>
			<tr><td>matrix number : </td><td><input type="text" name="matrix" /></td></tr>
			<tr><td>Press info :</td><td> <select name="press">
							<option selected> First</option>
							<option> Repress</option>
						</select>
			</td></tr>
			<tr><td>Type record : </td><td><select name="type">
							<option selected> LP</option>
							<option> DoubleLP</option>
							<option> EP</option>
							<option> DoubleEP</option>
							<option> MaxiSingle</option>
							<option> Single</option>
						</select>
			</td></tr>
			<tr><td>Vinyle size :</td><td> <select name="vinyle">
							<option selected> 7</option>
							<option> 10</option>
							<option> 12</option>
						</select>
			</td></tr>
			<tr><td>Number of track :</td><td> <select name="numTrack">
							<option selected> 1</option>
							<%for(int j=2;j<=50;j++){ %>
								<option><%=j %></option>
							<%} %>
							</select>
			</td></tr>
			
			<tr><td></td><td><p style="width:50%;margin:auto;"><input type="submit" name="bouton" value="Submit"/></p></td></tr>
			</table>
		</div>
	</form>
</div>
</body>
</html>