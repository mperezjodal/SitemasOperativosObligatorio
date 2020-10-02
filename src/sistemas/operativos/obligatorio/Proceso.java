package sistemas.operativos.obligatorio;
/*
PROGRAMA el conjunto de instrucciones
PROCESO es una instancia en particular de dicho programa
*/

public class Proceso {
    private String nombre; 
    private Programa elPrograma;
    private int cantInstruccionesSinEjecutar;
    private int indiceProximaInstruccionAEjecutar;
    private String estado;
    
    
    public Proceso(Programa unPrograma, String nom){
        this.nombre = nom;
        this.elPrograma = unPrograma;
        this.indiceProximaInstruccionAEjecutar = 0;
        this.cantInstruccionesSinEjecutar = this.elPrograma.getNumInstrucciones();
        this.estado = "En Cola";
    }

    public String getEstado() {
        return this.estado;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public Programa getPrograma(){
        return this.elPrograma;
    }
    public String getNombrePrograma(){
        return this.elPrograma.getNombre();
    }
    public String getNombreProxInstruccion(){
        return this.elPrograma.getNombreInstruccion(this.indiceProximaInstruccionAEjecutar);
    }
    public boolean proxInstruccionUsaRecurso(){
        return this.elPrograma.instruccionUsaRecurso(this.indiceProximaInstruccionAEjecutar);
    }
    public String getNombreRecursoProximaInstruccion(){
        return this.elPrograma.getNombreRecursoDeInstruccion(this.indiceProximaInstruccionAEjecutar);
    }
    public int getCiclosInstruccion(){
        return this.elPrograma.getCiclosInstruccion(this.indiceProximaInstruccionAEjecutar);
    }
    public void avanzar(){
        this.indiceProximaInstruccionAEjecutar++;
        this.cantInstruccionesSinEjecutar--;
        if(this.seCompletoElProceso()){
            this.estado = "Completado";
        }
    }
    public boolean seCompletoElProceso(){
        if(this.cantInstruccionesSinEjecutar==0){
            return true;
        }
        else{
            return false;
        }
    }
}


























