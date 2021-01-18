<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
<%@ include file = "Menu.jsp"%>

Bonjour, je suis dans la vue .... JSP <br/>

Modification de la JSP

<p>
<%
String variable = (String)request.getAttribute("mes");
out.println("Contenu de la variable envoyée par la servlet : "+variable);
%>
</p>

<p>
<%
for(int i=1; i<=10; i++){
	out.println("Bonjour </br>");
}
%>
</p>

<p>
<%
String c = (String)request.getAttribute("c");
if (c.equals("jour")){
	out.println("Bonjour");
}
else if (c.equals("nuit")){
	out.println("Bonne nuit");
}
else{
	out.println("Erreur");
}
%>
</p>

</body>
</html>