package views;

public class loginView {
    public loginView(){

    }

    @Override
    public String toString() {
        return """
            <main class="form-signin w-100 m-auto">
                <form method="POST" action="login.jsp">
                    <h1 class="h3 mb-3 fw-normal">Por favor inicie sesión</h1>

                    <div class="form-floating">
                    <input type="text" class="form-control" name="username" id="floatingInput" placeholder="juan">
                    <label for="floatingInput">usuario</label>
                    </div>
                    <div class="form-floating">
                    <input type="password" class="form-control" name="password" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">contraseña</label>
                    </div>

                    <div class="form-check text-start my-3">
                    <a href="register.jsp">
                        Quiero registrarme
                    </a>
                    </div>
                    <button class="btn btn-primary w-100 py-2" type="submit">Iniciar sesión</button>
                    <p class="mt-5 mb-3 text-body-secondary">&copy; 2024</p>
                </form>
            </main>
                """;
    }
}
