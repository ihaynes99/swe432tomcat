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
     public static String firstVar = "";
     public static String operation = "";
     public static String secondVar = "";
     //static final String ValSep = ";";

  @Override
   protected void doGet  (HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException
   {
	   
	   PrintWriter out = response.getWriter();
	    Object attributeValue = request.getAttribute("Request-Attribute");
       out.println ("<HTML>");
       out.println ("<BODY>");
      // out.println("<p>hehehe test</p>");
       out.println("<LABEL for = echo>Echo: "+attributeValue+" "+attributeValue+" "+attributeValue+"");

       out.println ("</BODY>");
       out.println ("</HTML>");
       out.flush();
       out.close();
	   
	   
     //  String firstVar = "";
      // String operation = "";
      // String secondVar = "";

       /*firstVar = (String) request.getSession().getAttribute("FirstVarNm");
       operation = (String) request.getSession().getAttribute("operators");
       secondVar = (String) request.getSession().getAttribute("SecondVarNm");

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

       }*/

     

       //request.getSession().setAttribute("FirstVarNm", session.getAttribute("FirstVarNm"));

       //session.setAttribute("operators", operation);
       //session.setAttribute("SecondVarNm", session.getAttribute("SecondVarNm"));



       //doPost(req,res);
   }
     @Override
     public void doPost (HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException
     {

        // doGet(request,response);
         String efirstVar = (String) request.getAttribute("FirstVarNm");
         String eoperation = (String) request.getAttribute("operators");
         String esecondVar = (String) request.getAttribute("SecondVarNm");

          boolean or = false;
          boolean and = false;
          boolean not = false;
          boolean xor = false;



         /* switch (operation)
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

          }*/

         PrintWriter out = response.getWriter ();
         out.println ("<HTML>");
         out.println ("<BODY>");
         out.println("<p>hehehe test</p>");
         out.println("<LABEL for = echo>Echo: "+efirstVar+" "+eoperation+" "+esecondVar+"");

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
