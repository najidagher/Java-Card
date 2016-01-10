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
  public String convertStringToHex(String str){

	  char[] chars = str.toCharArray();

	  StringBuffer hex = new StringBuffer();
	  for(int i = 0; i < chars.length; i++){
	    hex.append(Integer.toHexString((int)chars[i]));
	  }

	  return hex.toString();
  }


  public String convertHexToString(String hex){

	  StringBuilder sb = new StringBuilder();
	  StringBuilder temp = new StringBuilder();

	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
	  for( int i=0; i<hex.length()-1; i+=2 ){

	      //grab the hex in pairs
	      String output = hex.substring(i, (i + 2));
	      //convert hex to decimal
	      int decimal = Integer.parseInt(output, 16);
	      //convert the decimal to character
	      sb.append((char)decimal);

	      temp.append(decimal);
	  }
	//  System.out.println("Decimal : " + temp.toString());

	  return sb.toString();
  }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>HEXADECIMAL/DECIMAL CO</title></head>");
            out.println("<body>");

             String hexstring = request.getParameter("hex");
             String ascstring = request.getParameter("asc");
             String Decstring = request.getParameter("dec");
             int DecNumber = Integer.parseInt(Decstring);

                if ( request.getParameter("hex") != null ){
               out.println("<table border=0><tr><th>ASCII  </th><th>HEXADECIMAL  </th><th>DECIMAL  </th></tr>");
               String ascaffiche =convertHexToString(hexstring);
               out.println("<tr><th>"+ascaffiche+" </th><th> "+hexstring+" </th>");
               int decimal = Integer.parseInt(hexstring, 16);
               out.println("<th>"+decimal+"</th></tr></table> ");
                }


                if ( request.getParameter("asc") != null ){
               String hexaffiche =convertStringToHex(ascstring);
               out.println("<table border=0><tr><th>ASCII  </th><th>HEXADECIMAL  </th><th>DECIMAL  </th></tr>");
               out.println("<tr><th> "+ascstring+" </th><th> "+hexaffiche+" </th>");
               out.println("<th>  ");
                for(int i=0;i<ascstring.length();i++)
                {
                out.println((int)ascstring.charAt(i));
                 
                }
                 out.println("</th></tr></table> ");
                }

                if ( request.getParameter("dec") != null ){
               out.println("<table border=0><tr><th>ASCII  </th><th>HEXADECIMAL  </th><th>DECIMAL  </th></tr>");
               String hexadecimal = Integer.toHexString(DecNumber);
               char ascidec  =(char)DecNumber;             
               String ascaffiche =convertHexToString(hexstring);
               out.println("<tr><th>"+ascidec+" </th><th> "+hexadecimal+" </th>");
               out.println("<th>"+DecNumber+"</th></tr></table> ");
                }
 
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
