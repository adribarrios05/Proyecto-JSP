package views;

public class anadirPilotoView {
    public anadirPilotoView(){

    }

    @Override
    public String toString() {
        return """
            <div class="container">
                <h1 class="mt-5">Añadir Nuevo Piloto</h1>
                <form action="anadirPiloto.jsp" method="post">
                    <div class="form-floating">
                        <input type="text" class="form-control" name="nombre" id="floatingInput1">
                        <label for="floatingInput1">Nombre</label>
                    </div>
                    <div class="form-floating">
                        <input type="text" class="form-control" name="apellidos" id="floatingInput2">
                        <label for="floatingInput2">Apellidos</label>
                    </div>
                    <div class="form-floating">
                        <input type="date" class="form-control" name="fecha_nac" id="floatingInpu3">
                        <label for="floatingInput3">Fecha de nacimiento</label>
                    </div>
                    <div class="form-floating">
                        <input type="text" class="form-control" name="nacionalidad" id="floatingInpu3">
                        <label for="floatingInput4">Nacionalidad</label>
                    </div>
                    <div class="form-floating">
                        <input type="text" class="form-control" name="equipo" id="floatingInpu3">
                        <label for="floatingInput5">Equipo</label>
                    </div>
                    <div class="form-floating">
                        <input type="text" class="form-control" name="categoria" id="floatingInpu3">
                        <label for="floatingInput6">Categoria</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Añadir Piloto</button>
                </form>
            </div>
                """;
    }
}
