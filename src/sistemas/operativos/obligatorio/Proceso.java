package sistemas.operativos.obligatorio;
/*
PROGRAMA el conjunto de instrucciones
PROCESO es una instancia en particular de dicho programa
*/

public class Proceso {
    private String nombre; 
    private Programa elPrograma;
    private int cantElementosEnLaCola;
    
    private int indiceProximaInstruccionAEjecutar;
    
    
    public Proceso(Programa unPrograma, String nom){
        this.nombre = nom;
        this.elPrograma = unPrograma;
        
        this.indiceProximaInstruccionAEjecutar = 0;
        this.cantElementosEnLaCola = this.elPrograma.getNumInstrucciones();
        
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
    public int getCiclosProximaInstruccion(){
        return this.elPrograma.getCiclosProxInstruccion(this.indiceProximaInstruccionAEjecutar);
    }
    public void avansar(){
        this.indiceProximaInstruccionAEjecutar++;
    }
    public boolean seCompletoElProceso(){
        if(this.indiceProximaInstruccionAEjecutar == this.cantElementosEnLaCola){
            return true;
        }
        else{
            return false;
        }
    }
}


























