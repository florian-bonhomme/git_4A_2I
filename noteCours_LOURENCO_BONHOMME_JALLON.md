# Systèmes distribués - 18/01
## Rappel

* Language Compilé : langage dont le code est transformé par une compilateur avant d'être utilisé
* Langauge Interprété : langage dont le code est directemenet expolitable après developpement
* Language itnermédiaire : dont le code est compilé et a besoin d'être interprété par un outil tierce, l'exemple de JAVA


* ***web.xml*** permet de définir le mapping des composants web disponibles sur votre applicaiton et de, par exemple, assigner une ***URL*** à une ***servlet*** qui est un controleur de l'application.


2 méthodes, Get et Post : 

* Get : récuperer des infos via une URL

* Post : envoyer des données

2 objets, Request et Response

Request : requête HTTP, récuperer les requêtes d'un utilisateur

Response : objet qu'on doit construire pour envoyer une réponse

## Modèle Vue Controlleur ( MVC)


Quand une requête arrive, elle va au contrôleur. Le contrôleur a le rôle d'un aiguilleur, tout va passer par lui.

Dans un modèle MVC, on doit passer par le controleur, sinon ce n'est pas une bonne pratique.

### Rôle du MVC

* Controleur = Servlet

* Modèle = entités 

* Vue  = JSP

Le Code plus facile à maintenir et à lire avec le MCV

## Servlet principale avec explications

 ```java
   package fr.polytech.nancy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Test() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// comment faire pour transmettre une information à la JSP ?
		String mes = "Variable transmise par la Servlet avec la méthode GET";
		// pour la transmettre à la JSP, on procède comme ceci :
		request.setAttribute("mes", mes);
		
		// on transmet une chaîne de caractère soit jour ou nuit
		// on affiche bonjour si c = jour et bonne nuit si c = nuit
		String c = "nuit";
		request.setAttribute("c", c);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);//toujours à la fin
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
   ```

## Mapping (Web.xml), redirection vers les JSP

 ```xml
   <?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>Testxml</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
</web-app>
   ```
Pour inclure une JSP dans une autre JSP, on utilise :

 ```xml
   <%@ include file = "Menu.jsp"%>
   ```

Nous utilisons Tomcat comme serveur.