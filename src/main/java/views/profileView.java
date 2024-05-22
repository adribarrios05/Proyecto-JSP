package views;

import users.User;

public class profileView {
    private User user;
    private String confirmacion;
    private String error;

    public profileView(User user, String confirmacion, String error){
        this.user = user;
        this.confirmacion = confirmacion;
        this.error = error;
    }

    @Override
    public String toString() {
        navbarView navbar = new navbarView(user);
        sideMenuView menu = new sideMenuView();

        StringBuilder sb = new StringBuilder();
        sb.append(navbar.toString());
        sb.append("""
            <div class="container-fluid">
                <div class="row">""");
        sb.append(menu.toString());
        sb.append("""
                    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                        <form method="POST" action="change-profile.jsp" class="p-3 border rounded shadow-sm">
                            <h4>Tus datos</h4>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="username" id="floatingInput" value=\"""").append(user.getUsername()).append("""
                                    \" placeholder=\"Usuario\" style=\"color:#666666;\" readonly>
                                <label for=\"floatingInput\">Usuario</label>
                            </div>
                            <div class=\"form-floating mb-3\">
                                <input type=\"text\" class=\"form-control\" name=\"email\" id=\"floatingPassword\" value=\"""").append(user.getEmail()).append("""
                                    \"placeholder=\"Your surname\">
                                <label for=\"floatingPassword\">Correo</label>
                            </div>""");

                        if (confirmacion != null && !confirmacion.isEmpty()) {
                            sb.append("<h4 class=\"confirmacion text-success\">").append(confirmacion).append("</h4>");
                        } else if (error != null && !error.isEmpty()) {
                            sb.append("<h4 class=\"error text-danger\">").append(error).append("</h4>");
                        }

                        sb.append("""
                            <div class="text-end">
                                <button class="btn btn-primary" type="submit">Cambiar</button>
                            </div>
                        </form>
                    </main>
                </div>
            </div>
        """);

        return sb.toString();
    }
}
