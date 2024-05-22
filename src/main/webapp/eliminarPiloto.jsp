<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="racing.PilotoService"%>
<%@page import="racing.Piloto"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    long codigo = Long.parseLong(request.getParameter("id"));

    //Usuario de la base de datos
    String dbuser = "adri";
        //Contraseña de la base de datos
    String dbpassword = "adri";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/racing", dbuser, dbpassword);
    PilotoService pserv = new PilotoService(pool.getConnection());
    boolean res = pserv.delete(codigo);
    response.sendRedirect("piloto.jsp");
%>