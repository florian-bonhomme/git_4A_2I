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
		
		// comment faire pour transmettre une information � la JSP ?
		String mes = "Variable transmise par la Servlet avec la m�thode GET";
		// pour la transmettre � la JSP, on proc�de comme ceci :
		request.setAttribute("mes", mes);
		
		// on transmet une cha�ne de caract�re soit jour ou nuit
		// on affiche bonjour si c = jour et bonne nuit si c = nuit
		String c = "nuit";
		request.setAttribute("c", c);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);//toujours � la fin
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
