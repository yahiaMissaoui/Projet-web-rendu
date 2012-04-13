<%@ include file="EnTete.jsp"%>
 
<div id="page">
	<br><br>
		<form name="rechercheForm" action="recherche" method="POST" 
	             style="width:50%;margin:auto;padding-bottom:15px;">
			
			<div id="research" style="text-align:center;">
				
				<p id="search"><input  style="width:50%;" type="text" name="recherche" value="Search music"  onclick="recherche.value='';"/></p>
				<p id="p1" style="visibility:visible">Filter : 
					<input type="radio" name="filter" value="none"> None
					<input type="radio" name="filter" value="track"> Track title
					<input type="radio" name="filter" value="person"> Artist name
					<input type="radio" name="filter" value="record"> Record name 
				</p>
				<p style="width:50%;margin:auto;"><input type="submit" name="bouton" value="Search"/></p>
			</div>
		</form>
</div>
</body>
</html>