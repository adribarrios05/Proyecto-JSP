package views;

import users.User;
import java.util.ArrayList;

public class homeView {
    private ArrayList<User> users;
    private User user;

    public homeView(ArrayList<User> users, User user){
        this.users = users;
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder userList = new StringBuilder();
        navbarView navbar = new navbarView(user);
        sideMenuView menu = new sideMenuView();
        for (User u : users) {
            userList.append(String.format(
                "<tr>"+
                "    <td>%d</td>"+
                "    <td>%s</td>"+
                "    <td>%s</td>"+
                "    <td>%s</td>"+
                "</tr>", u.getId(),
                u.getUsername(),
                u.getEmail(),
                u.getPassword()));
        }

        return navbar.toString() + """
          <div class="container-fluid">
            <div class="row">"""+
            menu.toString()
            +"""
              <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                  <h1 class="h2">Inicio</h1>
                </div>
          
              
          
                <h2>Listado de usuarios</h2>
                <div class="table-responsive small">
                  <table class="table table-striped table-sm">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">Correo electrónico</th>
                        <th scope="col">Contraseña</th>
                      </tr>
                    </thead>
                    <tbody>
                      """ + userList.toString() + """
                    </tbody>
                  </table>
                </div>
              </main>
            </div>
          </div>
                """;
    }
}