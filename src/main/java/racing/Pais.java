package racing;

public class Pais {
    private long codigo;
    private static int idCont = 0;
    private String nombre;

    public Pais(long codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Pais(String nombre){
        this.codigo = ++idCont;
        this.nombre = nombre;
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
        Pais.idCont = idCont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
