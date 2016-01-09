/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HEXCONVERTER;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author USER
 */
public class HEX_STR_CONVERTER extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>HEXADECIMAL/DECIMAL CO</title></head>");
            out.println("<body>");
 //           out.println("Hello from HEXCONVERTER.HEX_STR_CONVERTER to");

            //    out.println(request.getParameter("hex"));
           //  String hexNumber = request.getParameter("hex");
         //    out.println("hexNumber ");
            // String DecNumberstr = request.getParameter("Dec");
           // int DecNumber = Integer.parseInt(DecNumberstr);
              //  if ( request.getParameter("hex") != null ){
          //   int decimal = Integer.parseInt(hexNumber, 16);
           //  out.println("Decimal value is :"+decimal);
              //  }
          //      if ( request.getParameter("Dec") != null ){
          //  String hexadecimal = Integer.toHexString(DecNumber);
           //  out.println("Hexadecimal value is :"+hexadecimal);
            //    }
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
