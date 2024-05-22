package views;

public class registrationView {
    public registrationView(){

    }

    @Override
    public String toString() {
        return """
          <main class="form-signin w-100 m-auto">
            <form method="POST" action="doregistration.jsp">
              <h1 class="h3 mb-3 fw-normal">Por favor regístrese</h1>

              <div class="form-floating">
                <input type="text" class="form-control" name="usuario" id="floatingInput1">
                <label for="floatingInput1">Usuario</label>
              </div>
              <div class="form-floating">
                <input type="text" class="form-control" name="correo" id="floatingInput2">
                <label for="floatingInput2">Correo electrónico</label>
              </div>
              <div class="form-floating">
                <input type="password" class="form-control" name="contrasena" id="floatingInpu3">
                <label for="floatingInput3">Contraseña</label>
              </div>
          
              <div class="form-check text-start my-3">
                <a href="login.jsp">
                  Quiero iniciar sesión
                </a>
              </div>
              <button class="btn btn-primary w-100 py-2" type="submit">Regístrame</button>
              <p class="mt-5 mb-3 text-body-secondary">&copy; 2024</p>
            </form>
          </main>
                """;
    }
}
