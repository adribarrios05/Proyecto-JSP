package racing;

public class Piloto {
    private long codigo;
    private static int idCont = 0;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String nacionalidad;
    private String equipo;
    private String categoria;
    private String urlImage;

    public Piloto(String nombre, String apellidos, String fechaNacimiento, String nacionalidad, String equipo, String categoria, String urlImage) {
        this.codigo = ++idCont;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
        this.categoria = categoria;
        this.urlImage = urlImage;
    }

    public Piloto(long codigo, String nombre, String apellidos, String fechaNacimiento, String nacionalidad, String equipo, String categoria, String urlImage) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
        this.categoria = categoria;
        this.urlImage = urlImage;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
