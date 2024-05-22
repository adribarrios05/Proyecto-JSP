<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="racing.PilotoService"%>
<%@page import="racing.Piloto"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String nombre = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    String fecha_nac = request.getParameter("fecha_nac");
    String nacionalidad = request.getParameter("nacionalidad");
    String equipo = request.getParameter("equipo");
    String categoria = request.getParameter("categoria");
    String urlImg = nombre+"-"+apellidos;

    //Usuario de la base de datos
    String dbuser = "adri";
        //Contraseña de la base de datos
    String dbpassword = "adri";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/racing", dbuser, dbpassword);
    PilotoService pserv = new PilotoService(pool.getConnection());
    Piloto piloto = new Piloto(nombre, apellidos, fecha_nac, nacionalidad, equipo, categoria, urlImg);
    long affectedRows = pserv.create(piloto);
    response.sendRedirect("piloto.jsp");
%>