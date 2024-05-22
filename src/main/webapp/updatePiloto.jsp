<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="users.User"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="views.modificarPilotoView"%>
<%@page import="racing.Piloto"%>
<%@page import="racing.PilotoService"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <script src="assets/js/color-modes.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar piloto</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">

    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/sign-in.css" rel="stylesheet">
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = (User)session.getAttribute("user");
        if(user==null){
            response.sendRedirect("login.jsp");
        }
        long codigo = Long.parseLong(request.getParameter("id"));
        //Usuario de la base de datos
        String dbuser = "adri";
        //Contraseña de la base de datos
        String dbpassword = "adri";
        //Pool de conexiones a la base de datos
        ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/racing", dbuser, dbpassword);
        PilotoService pserv = new PilotoService(pool.getConnection());
        Piloto piloto = pserv.requestById(codigo);
        modificarPilotoView view = new modificarPilotoView(piloto);
        out.println(view);
    %>
    <script src="assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>