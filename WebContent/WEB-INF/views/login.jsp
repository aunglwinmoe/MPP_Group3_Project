<%@ page import="java.sql.*"%>
<%
    String username = request.getParameter("userName");    
    String pwd = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicledb",
            "root", "root");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from user where username='" + username + "' and password='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("userName", username);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("menu.html");
    } else {
    	 session.setAttribute("errMsg", "Try Again!");
         //out.println("welcome " + userid);
         //out.println("<a href='logout.jsp'>Log out</a>");
         response.sendRedirect("index.html");
         
    }
%>