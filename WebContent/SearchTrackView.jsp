<%@ include file="EnTete.jsp"%>
<%@ page import="java.text.SimpleDateFormat"%>
<script>

</script>
<div id="page">
	<br><br>
	<center>
		<form name="rechercheForm" action="recherche" method="POST" 
	             style="width:50%;margin:auto;padding-bottom:15px;">
			
			<div style="text-align:center;">
				
				<input type="text" name="recherche" value="Search music"  onclick="recherche.value='';"/>
				<select name="menu" onchange="affiche(this);">
					<option selected> Track View</option>
					<option> Records View</option>
				</select><br>
				<p id="p1" style="visibility:visible">Filter : 
					<input type="radio" name="filter" value="none"> None
					<input type="radio" name="filter" value="track"> Track title
					<input type="radio" name="filter" value="person"> Person name
					<input type="radio" name="filter" value="record"> Record name 
				</p>
				
				<p style="width:50%;margin:auto;"><input type="submit" name="bouton" value="Search"/></p>
			</div>
		</form>
	</center>
	<br><br>
	<%ArrayList<Track> arrayOfTrack = new ArrayList<Track>();
	arrayOfTrack = (ArrayList<Track>)request.getAttribute("arrayOfTrack");
	if(!arrayOfTrack.isEmpty()){%>
		<center>
			<table>
				<thead>
					<tr> <th>Title</th> <th>Artist</th> <th>Playing time</th> <th>Record</th> <th>Type artist</th> <th>Rhythm</th> <th>Label</th> <th>Release date</th> <th>Style</th> </tr>
				</thead>
				<tbody>
					<%for(Track track : arrayOfTrack){%>
						<tr>
							<td>
								<%=track.getTitre() %>
							</td>
							<td>
								<%=track.getArtiste().getNom() %>
							</td>
							<td>
								<%SimpleDateFormat dateFormatTime = new SimpleDateFormat("mm:ss"); 
								String playingTimeString = dateFormatTime.format(track.getDuree());%>
								<%=playingTimeString %>
							</td>
							<td>
								<a href="profilUser" title="Album"/><%=track.getRecord().getName() %></a>
							</td>
							<td>
								<%=track.getStyle() %>
							</td>
							<td>
								<%=track.getLabel() %>
							</td>
							<td>
								<%SimpleDateFormat dateFormatDate = new SimpleDateFormat("yyyy/MM/dd"); 
								String releaseDateString = dateFormatDate.format(track.getDate_de_sortie());%>
								<%=releaseDateString %>
							</td>
							<td>
								<%=track.getStyle() %>
							</td>
						</tr>
					<%}%>
				</tbody>
			</table>
		</center>
		<%}%>

</div>
</body>
</html>