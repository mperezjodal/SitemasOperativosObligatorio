package sistemas.operativos.obligatorio;

public class Programa {
    private String nombre;
    
    private Instruccion[] listaInstrucciones;
    private int numInstrucciones;
    //private int numInstruccionesSinEjecutar;
    private int indiceProxInstruccion;
    
    public Programa(String nombre, int numeroDeInstrucciones) {
        this.nombre = nombre;
        this.numInstrucciones = numeroDeInstrucciones;
        //this.numInstruccionesSinEjecutar = numeroDeInstrucciones;
        this.indiceProxInstruccion = 0;
        
        this.listaInstrucciones = new Instruccion[numeroDeInstrucciones];
        for(int i = 0; i < numeroDeInstrucciones; i++){
            this.listaInstrucciones[i] = null;
        }
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public int getNumInstrucciones(){
        return this.numInstrucciones;
    }
    
    public void agregarInstruccion(Instruccion ins){
        this.listaInstrucciones[indiceProxInstruccion] = ins;
        this.indiceProxInstruccion++;
    } 
    
    
    public boolean instruccionUsaRecurso(int indiceInstruccion){
        return !(this.listaInstrucciones[indiceInstruccion].getRecurso() != null);
    }
    public String getNombreInstruccion(int indiceInstruccion){
        return this.listaInstrucciones[indiceInstruccion].getNombre();
    }
    public String getNombreRecursoDeInstruccion(int indiceInstruccion){
        return this.listaInstrucciones[indiceInstruccion].getRecurso().getNombre();
    }
    public int getCiclosProxInstruccion(int indiceInstruccion){
        return this.listaInstrucciones[indiceInstruccion].getCiclos();
    }
}



























