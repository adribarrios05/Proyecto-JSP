package racing;

public class Equipo {
    private long codigo;
    private static int idCont = 0;
    private String nombre;
    private String sede;
    private int pais;

    public Equipo(long codigo, String nombre, String sede, int pais){
        this.codigo = codigo;
        this.nombre = nombre;
        this.sede = sede;
        this.pais = pais;
    }

    public Equipo(String nombre, String sede, int pais){
        this.codigo = ++idCont;
        this.nombre = nombre;
        this.sede = sede;
        this.pais = pais;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getIdCont() {
        return idCont;
    }

    public static void setIdCont(int idCont) {
        Equipo.idCont = idCont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "";
    }

}
