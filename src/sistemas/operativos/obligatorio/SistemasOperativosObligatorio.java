package sistemas.operativos.obligatorio;
import java.util.Scanner;

/*COLORARIO:
    Usuario: una persona que puede ordenarle a la computadora que ejecute un programa
    Programa: conjunto de instrucciones ejecutadas en determinado orden
    Intruccion: las "lineas" que conforman un programa
    Recurso: algo que las instrucciones pueden usar, EJ: una impresora

    Proceso: una instancia (en ejecucion) especifica de un programa
             DIFERENTES procesos pueden ser diferentes instancias de un mismo programa

*/
public class SistemasOperativosObligatorio {
    Scanner getInput = new Scanner(System.in);
    
    private static int ciclosDeTolerancia = 10; 
    
    private static Usuario u1 = new Usuario("u1");
    private static Usuario u2 = new Usuario("u2");
    private static Usuario u3 = new Usuario("u3");
    
    private static Recurso impresora = new Recurso("Impresora", 5);
    
    private static Instruccion ins_A = new Instruccion("A", impresora);
    private static Instruccion ins_B = new Instruccion("B", 10);
    private static Instruccion ins_C = new Instruccion("C", 7);
    
    private static Programa progra_1 = new Programa("Programa 1", 3);
    private static Programa progra_2 = new Programa("Programa 2", 1);
    private static Programa progra_3 = new Programa("Programa 3", 3);
    
    
    //private static Programa[] colaProcesos;

    //private int tiempoTotal;
    static int masMasCiclico(int cantEnCola, int i){
        int toReturn;
        if(i+1 == cantEnCola){
            toReturn = 0;
        }
        else{
            toReturn = i + 1;
        }
        return toReturn;
    };
    
    static boolean todosTrue(boolean[] boolArray){
        boolean toReturn = true;
        
        for(int i = 0; i < boolArray.length; i++){
            if(!boolArray[i]){
                toReturn = false;
            }
        }
        
        return toReturn;
    }
    
    public static void main(String[] args) {
        progra_1.agregarInstruccion(ins_A);
        progra_1.agregarInstruccion(ins_A);
        progra_1.agregarInstruccion(ins_A);
        
        
        progra_2.agregarInstruccion(ins_B);
        
        
        progra_3.agregarInstruccion(ins_C);
        progra_3.agregarInstruccion(ins_C);
        progra_3.agregarInstruccion(ins_C);
        
        Proceso pro1 = new Proceso(progra_1, "pro1");
        Proceso pro2 = new Proceso(progra_2, "pro2");
        Proceso pro3 = new Proceso(progra_3, "pro3");
        Proceso pro4 = new Proceso(progra_1, "pro4");
        
        Proceso[] colaProcesos = {pro1, pro2, pro3, pro4};
        boolean[] completados = {false, false, false, false};
        
        boolean[] yaSeMostro = {false, false, false, false};
        
        int procesosEnCola = colaProcesos.length;
        boolean seTermino = false;
        
        int ciclosRestantesParaEsteProceso = ciclosDeTolerancia; 
        
        for(int i = 0; !seTermino; i = masMasCiclico(procesosEnCola, i) ){
            
            if(!completados[i]){
                System.out.println("Se le entrego el procesador a:.............Programa: " + colaProcesos[i].getNombrePrograma() 
                        + "...Instancia: " + colaProcesos[i].getNombre());
            
                int ciclosProxInst = colaProcesos[i].getCiclosProximaInstruccion();
                while(ciclosRestantesParaEsteProceso >= ciclosProxInst && !completados[i]){

                    System.out.println("                INSTRUCCION EJECUTADA:  " + colaProcesos[i].getNombreProxInstruccion()
                            + "  Programa: " + colaProcesos[i].getNombrePrograma() + "...Instancia: " + colaProcesos[i].getNombre());

                    
                    ciclosRestantesParaEsteProceso -= colaProcesos[i].getCiclosProximaInstruccion();
                    colaProcesos[i].avansar();
                    completados[i] = colaProcesos[i].seCompletoElProceso();
                    
                    if(!colaProcesos[i].seCompletoElProceso()){
                        ciclosProxInst = colaProcesos[i].getCiclosProximaInstruccion();
                    }
                }
                
                
                
                if(completados[i]){
                    System.out.println("EJECUCION COMPLETADA:......................Programa: " + colaProcesos[i].getNombrePrograma() 
                        + " - Instancia: " + colaProcesos[i].getNombre());
                }else{
                    System.out.println("TIMEOUT - El proceso demoro demaciado:.....Programa: " 
                            + colaProcesos[i].getNombrePrograma() 
                            + "...Instancia: " + colaProcesos[i].getNombre());
                }
            }
            
            /*
            if(colaProcesos[i].seCompletoElProceso()){
                completados[i] = true;
            }*/
            ciclosRestantesParaEsteProceso = ciclosDeTolerancia; 
            seTermino = todosTrue(completados);
        }
    }
    
}
