package racing;

public class Categoria {
    private long codigo;
    private static int idCont = 0;
    private String nombre;
    private String tipo;

    public Categoria(long codigo, String nombre, String tipo){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Categoria(String nombre, String tipo){
        this.codigo = ++idCont;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public static int getIdCont() {
        return idCont;
    }

    public static void setIdCont(int idCont) {
        Categoria.idCont = idCont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "";
    }
}
