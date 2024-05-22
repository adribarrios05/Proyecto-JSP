package views;

import java.util.ArrayList;

import racing.Piloto;
import users.User;

public class PilotoView {
    private ArrayList<Piloto> pilotos;
    private User user;

    public PilotoView(ArrayList<Piloto> pilotos, User user){
        this.pilotos = pilotos;
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder userList = new StringBuilder();
        navbarView navbar = new navbarView(user);
        sideMenuView menu = new sideMenuView();
        for (Piloto piloto : pilotos) {
            userList.append(String.format(
                """
                <div class="col">
                    <div class="card">
                        <img src="assets/img/Predeterminado.jpg" class="card-img-top" alt="">
                        <div class="card-body">
                            <h5 class="card-title">%s %s</h5>
                            <p class="card-text text-muted">Fecha de nacimiento: %s</p>
                            <p class="card-text text-muted">Nacionalidad: %s</p>
                            <p class="card-text text-muted">Equipo: %s</p>
                            <p class="card-text text-muted">Categoría: %s</p>
                            <div class="d-flex justify-content-between">
                                <a href="updatePiloto.jsp?id=%d" class="btn btn-primary">Editar</a>
                                <button class="btn btn-danger" onclick="confirmarEliminar(%d)">Eliminar</button>
                            </div>
                        </div>
                    </div>
                </div>"""
                        ,
                piloto.getNombre(), piloto.getApellidos(), piloto.getFechaNacimiento(), piloto.getNacionalidad(), piloto.getEquipo(), piloto.getCategoria(), piloto.getCodigo(), piloto.getCodigo()));
        }

        return navbar.toString() + """
            <div class="container-fluid">
                <div class="row">"""+
                menu.toString()
                +"""
                    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                        <h1 class="h3 mb-3">Gestión de pilotos</h1>
                        <div class="row row-cols-1 row-cols-md-3 g-4">"""+
                            userList.toString()+"""
                            <div class="col">
                                <div class="card h-100">
                                    <div class="card-body d-flex align-items-center justify-content-center">
                                    <a href="addPiloto.jsp" class="btn btn-outline-primary btn-lg" style="width: 100%;">Añadir piloto</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>
                </div>
            </div>

            <script>
                function confirmarEliminar(codigo) {
                    if (confirm("¿Estás seguro de que quieres eliminar este piloto?")) {
                        window.location.href = "eliminarPiloto.jsp?id=" + codigo;
                    }
                }
            </script>
                """;
    }
}