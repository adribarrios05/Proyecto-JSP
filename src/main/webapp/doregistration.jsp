<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="users.AuthService"%>
<%@page import="users.User"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String username = request.getParameter("usuario");
    String email = request.getParameter("correo");
    String password = request.getParameter("contrasena");

    //Usuario de la base de datos
    String dbuser = "adri";
        //Contraseña de la base de datos
    String dbpassword = "adri";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/racing", dbuser, dbpassword);
    AuthService auth = new AuthService(pool.getConnection());
    User user = auth.register(username, email, password);
    response.sendRedirect("login.jsp");
%>