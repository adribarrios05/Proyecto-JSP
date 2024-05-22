<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="users.UsersService"%>
<%@page import="users.User"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- Enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //Usuario de la base de datos
        String dbuser = "adri";
        //Contraseña de la base de datos
        String dbpassword = "adri";
        //Pool de conexiones a la base de datos
        ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/racing", dbuser, dbpassword);
        UsersService users = new UsersService(pool.getConnection());
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = (User)session.getAttribute("user");
        User newUserData = new User(user.getId(),user.getUsername(), email, password);
        if(users.update(newUserData)==1){
            session.setAttribute("user", newUserData);
            response.sendRedirect("profile.jsp?confirmacion=Usuario añadido correctamente");
        }
        else{
            response.sendRedirect("profile.jsp?error=No ha sido posible cambiar la inforamción");
        }


    %>

    <!-- Bootstrap JavaScript y dependencias -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>