<%-- 
    Document   : process
    Created on : 12-Jun-2023, 8:34:53 PM
    Author     : pc
--%>

<%--<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="process.jsp" method="get">
            <input type="text" name="p">
            <p> <%= request.getParameter("p")%></p>
            <button type="submit" >submit</button>
            
              <%
   String txt_place =  request.getParameter("p");
  
    String connectionURL = "jdbc:mysql://localhost:3307/wedding";
          // declare a connection by using Connection interface 
    Connection connection= null;
       
     PreparedStatement pstatement = null;
         // Load JBBC driver "com.mysql.jdbc.Driver"
     Class.forName("com.mysql.jdbc.Driver").newInstance();
          int updateQuery = 0;
     
     	 
	
	                 try {
              
              connection = DriverManager.getConnection
              (connectionURL, "root", "Root@123");
              System.out.println("connected");
                            // sql query to insert values in the secified table.
              String queryString = "INSERT INTO location(location_name) VALUES (?)";
              	      /* createStatement() is used for create statement
              object that is used for 
		sending sql statements to the specified database. */
              pstatement = connection.prepareStatement(queryString);
              pstatement.setString(1, txt_place);
			
              updateQuery = pstatement.executeUpdate();
                            if (updateQuery != 0) { %>
	           <br>
	           <table style="background-color: #E3E4FA;" 
                   WIDTH="30%" border="1">
		      <tr><th>Data is inserted successfully 
                    in database.</th></tr>
		   </table>
              <%
              }
            } 
            catch (Exception ex) {
            out.println("Unable to connect to batabase.");
   
               }
            finally {
                // close all the connections.
                pstatement.close();
                connection.close();
            }
	
%>
        </form>
    </body>
</html>
--%>