<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,modeles.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Vinyl Record Collection Manager</title>
	<style type="text/css">
		<%@ include file="/css/design.css" %>
	</style>
</head>

<body>
		<div id="entete">
				<table>
					<tr><td id="et1">
						<a href="index.jsp" title="Retour à la page d'accueil">Vinyl Record </a>
							<a href="index.jsp" title="Rechercher">Search</a>
							<%ArrayList<modeles.User> listes=(ArrayList<modeles.User>) session.getAttribute("listes");
							if(listes == null || listes.size() == 0){%>
<!--								do nothing-->
							<%} else {%>
								<a href="addRecord" title="Liste des clients de la banque"> Add Album </a>
							<%}%>
					</td>
					<td id="et2">

		
						<%if(listes == null || listes.size() == 0){%>
							<a href="inscription" title="Creer un compte">Create an account</a>
							<a href="login" title="Login">Login</a>
						<%} else {
							for (User u:listes){
								if(!u.getPseudo().equals("")) { %>
									<a href="userAccount" title="Compte"><%=u.getPseudo() %></a>
									<a href="login?lien=logoff" title="Login">log out</a>
								<%}
							}
						}%>
		</td></tr></table>
		</div>

