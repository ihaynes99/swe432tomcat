package servlet;

import java.io.PrintWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
    )

public class HelloServlet extends HttpServlet
{
    static String Servlet = "HelloServletForward";
   // static String firstVar;
   // static String operator;
   // static String secondVar;
   //static String RfFile = "persist.txt";
    //static final String ValSep = ";";

  @Override
   protected void doGet  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException
   {
	    req.setAttribute("Request-Attribute", "Value of Attribute ");
        HttpSession session = req.getSession(false);
        res.setContentType ("text/html");
        PrintWriter out = res.getWriter ();

        out.println ("<HTML>");
        out.println ("<HEAD>");
        out.println ("<TITLE>SWE 432 HW 8</TITLE>");
        out.println ("</HEAD>");

        out.println ("<BODY>");
        out.println ("<HR>");
        out.println ("<H1> SWE 432 HW 8 By: Pooja Ramesh & Scott Haynes</H1>");
        out.println ("<HR>");
		out.println ("<p> Collaboration Summary: Scott wrote the second servlet to POST the results from the GET request that Pooja wrote in the first servlet and she forwarded the servlet to the second servlet</p>");

        out.println("<form method = \"POST\" action = \"https://swe432class.herokuapp.com/HelloServletForward\">"); //calls do-post method
        out.println(" <LABEL for = FirstVarNm>First Variable Name:");
        out.println(" <INPUT type = text id = FirstVarNm name = FirstVarNm>");

        out.println(" <LABEL for = operators>Choose a operator:");
        out.println(" <SELECT name = operators id= operators>");
        out.println(" <OPTION value = and>&amp;&amp;");
        out.println(" <OPTION value = or>||");
        out.println(" <OPTION value = xor>^");
        out.println("</SELECT>");
        out.println("<LABEL for = SecondVarNm>Second Variable Name:");
        out.println(" <INPUT type = text id = SecondVarNm name = SecondVarNm>");
        out.println("<BR>");
        out.println("<BR>");

        out.println("<INPUT type = submit name = bttn1 value = Submit>");
        out.println("</form>");
    /*    out.println("<br>");
        out.println("<br>");
        out.println("<LABEL for = CollabSum5>Collabaration Summary Assign5: Pooja worked on the doGet method (accepting user input and passing it) while Scott worked on the doPost ensuring that the truth table was printed out. Pooja also typed out this collaboration summary");
        out.println("<br>");
        out.println("<br>");
        out.println("<LABEL for = CollabSum7>Collabaration Summary Assign7: Pooja worked on ensuring that the list of previous attempts during the session are displayed correctly while Scott ensured that the data was saved. Pooja also typed this collaboration summary");
*/


        out.println ("</BODY>");

        out.println ("</HTML>");


      

        out.flush();
        out.close ();
		
		//req.setAttribute("Request-Attribute", "Value of Attribute ");
      //  RequestDispatcher rd = req.getRequestDispatcher("/HelloServletForward");
      //  rd.forward(req, res);

    }
     @Override
     public void doPost (HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException
     {
        

          if (request.getParameter("FirstVarNm") != null && request.getParameter("operators") != null && request.getParameter("SecondVarNm") != null)
          {
              RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/servlet2");
          dispatcher.forward(request,response);
          }
		 

     }
}
