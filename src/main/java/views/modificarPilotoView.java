package views;

import racing.Piloto;

public class modificarPilotoView {
    private Piloto piloto;

    public modificarPilotoView(Piloto piloto){
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return String.format("""
        <div class="container">
            <h1 class="h3 mb-3">Editar Piloto</h1>
            <form action="modificarPiloto.jsp?" method="post">
                <input type="hidden" name="codigo" value="%d">
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="%s" required>
                </div>
                <div class="mb-3">
                    <label for="apellidos" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" id="apellidos" name="apellidos" value="%s" required>
                </div>
                <div class="mb-3">
                    <label for="fecha_nac" class="form-label">Fecha de Nacimiento</label>
                    <input type="date" class="form-control" id="fecha_nac" name="fecha_nac" value="%s" required>
                </div>
                <div class="mb-3">
                    <label for="nacionalidad" class="form-label">Nacionalidad</label>
                    <input type="text" class="form-control" id="nacionalidad" name="nacionalidad" value="%s" required>
                </div>
                <div class="mb-3">
                    <label for="equipo" class="form-label">Equipo</label>
                    <input type="text" class="form-control" id="equipo" name="equipo" value="%s" required>
                </div>
                <div class="mb-3">
                    <label for="categoria" class="form-label">Categoría</label>
                    <input type="text" class="form-control" id="categoria" name="categoria" value="%s" required>
                </div>
                <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            </form>
        </div>
        """,
            piloto.getCodigo(),
            piloto.getNombre(),
            piloto.getApellidos(),
            piloto.getFechaNacimiento(),
            piloto.getNacionalidad(),
            piloto.getEquipo(),
            piloto.getCategoria()
        );
    }
}
