package servlet;

import java.io.PrintWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "HelloServletForward",
        urlPatterns = {"/HelloServletForward"}
    )

public class HelloServletForward extends HttpServlet
{
 
     //static final String ValSep = ";";

  @Override
   protected void doGet  (HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
   {
	   
	 
   }
     @Override
     public void doPost (HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException
     {

         String firstVar = (String) request.getParameter("FirstVarNm");
         String operation = (String) request.getParameter("operators");
         String secondVar = (String) request.getParameter("SecondVarNm");

          boolean or = false;
          boolean and = false;
          boolean not = false;
          boolean xor = false;



          switch (operation)
          {
              case "~":
              case "not":
                  operation = "~";
                  not = true;
                  break;
              case "||":
              case "or":
                  operation = "||";
                  or = true;
                  break;
              case "&&":
              case "and":
                  operation = "&&";
                  and = true;
                  break;
              case "xor":
                  operation = "xor";
                  xor = true;
                  break;

          }

         PrintWriter out = response.getWriter ();
         out.println ("<HTML>");
         out.println ("<BODY>");
         out.println("<LABEL for = echo>Echo: "+firstVar+" "+operation+" "+secondVar+"");

         out.println("<table>");
         out.println("<tr>");
         out.println("<td>row:");
         out.println("<td> "+firstVar+"");
         out.println("<td> "+secondVar+"");
         out.println("<td> result");
         out.println("</tr>");
         if (and)
         {
             out.println("<tr>");
             out.println("<td> 1.");
             out.println("<td> true");
             out.println("<td> true");
             out.println("<td> true");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 2.");
             out.println("<td> true");
             out.println("<td> false");
             out.println("<td> false");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 3.");
             out.println("<td> false");
             out.println("<td> true");
             out.println("<td> false");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 4.");
             out.println("<td> false");
             out.println("<td> false");
             out.println("<td> false");
             out.println("</tr>");

         }
         else if(or)
         {
             out.println("<tr>");
             out.println("<td> 1.");
             out.println("<td> true");
             out.println("<td> true");
             out.println("<td> true");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 2.");
             out.println("<td> true");
             out.println("<td> false");
             out.println("<td> true");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 3.");
             out.println("<td> false");
             out.println("<td> true");
             out.println("<td> true");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 4.");
             out.println("<td> false");
             out.println("<td> false");
             out.println("<td> false");
             out.println("</tr>");
         }
         else if (xor)
         {
             out.println("<tr>");
             out.println("<td> 1.");
             out.println("<td> true");
             out.println("<td> true");
             out.println("<td> false");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 2.");
             out.println("<td> true");
             out.println("<td> false");
             out.println("<td> true");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 3.");
             out.println("<td> false");
             out.println("<td> true");
             out.println("<td> true");
             out.println("</tr>");

             out.println("<tr>");
             out.println("<td> 4.");
             out.println("<td> false");
             out.println("<td> false");
             out.println("<td> false");
             out.println("</tr>");
         }
         out.println("</table>");
         out.println ("</BODY>");
         out.println ("</HTML>");
         out.flush();
         out.close();

     }
}
