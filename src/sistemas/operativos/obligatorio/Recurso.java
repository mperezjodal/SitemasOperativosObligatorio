package sistemas.operativos.obligatorio;


public class Recurso {
    private String nombre;
    private int ciclos;
    
    public Recurso(String nombre, int ciclos) {
        this.nombre = nombre;
        this.ciclos = ciclos;
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
    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }
    
    
}
