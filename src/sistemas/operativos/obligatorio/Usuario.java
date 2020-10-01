package sistemas.operativos.obligatorio;

public class Usuario {
    private String nombre;
    private int numeroDeUsuario;
    private static int proximoNumeroDeUsuario = 0;
    
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.numeroDeUsuario = this.proximoNumeroDeUsuario;
        this.proximoNumeroDeUsuario ++;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setNumeroDeUsuario(int numero){
        this.numeroDeUsuario = numero;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getNumeroDeUsuario(){
        return this.numeroDeUsuario;
    }
}