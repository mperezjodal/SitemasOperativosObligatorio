package sistemas.operativos.obligatorio;


public class Instruccion {
    private String nombre;
    private int ciclos;
    private Recurso recurso;

    public Instruccion(String nombre, int ciclos) {
        this.nombre = nombre;
        this.ciclos = ciclos;
        this.recurso = null;
    }
    public Instruccion(String nombre, Recurso recurso) {
        this.nombre = nombre;
        this.ciclos = recurso.getCiclos();
        this.recurso = recurso;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiclos() {
        return ciclos;
    }

    public Recurso getRecurso() {
        return recurso;
    }
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    public boolean usaRecurso(){
        if(this.recurso == null){
            return false;
        }
        else{
            return true;
        }
    }
    
}
