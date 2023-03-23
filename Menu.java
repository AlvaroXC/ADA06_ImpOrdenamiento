import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    private LinkedList<Auto> lista = new LinkedList<>();
    Scanner entrada;

    public Menu(LinkedList <Auto> lista){
        this.lista = lista;
    }

    /**
     * 
     * @return
     */

    int formaOrdenadar(){
        System.out.println("Elige forma de ordenar");
        System.out.println("1- Ascendente");
        System.out.println("2- Descendente");
        entrada= new Scanner(System.in);
        int forma = entrada.nextInt();
        if(forma>0 && forma<=2){
            return forma;
        }else{
            System.out.println("Elige una forma valida");
            formaOrdenadar();
        }
        return forma;
    }

    /**
     * 
     * @param salida
     */
   public void elegirAlgoritmo(String salida){
       int numAlgoritmo=0;
        if(salida.contains("QuickSort")){
            numAlgoritmo=1;
        }
        else if(salida.contains("Binary")){
            numAlgoritmo=2;
        }

        int columna, forma;

        switch (numAlgoritmo) {
            case 1:
                columna = elegirColumna();
                forma = formaOrdenadar();
                QuickSort qSort= new QuickSort(lista.size());
                cargarArrayQuick(qSort);
                qSort.recQSort(0, lista.size()-1,columna,forma);
                qSort.generarCSV(salida);
                break;
            case 2:
                columna = elegirColumna();
                forma = formaOrdenadar();
                BinaryInsertionSort brSort = new BinaryInsertionSort();
                Auto array[] = cargarArrayBinary();
                brSort.binaryInsertionSort(array, lista.size(),forma,columna);
                brSort.generarCSV(array, salida);
                break;
                
            default:
                System.out.println("Algoritmo no especificado");
                break;
        }
    }

    /**
     * 
     * @param qSort
     */
    public void cargarArrayQuick(QuickSort qSort){
        for (int i = 0; i < lista.size(); i++) {
            qSort.insert(lista.get(i));
        }
    } 

    /**
     * 
     * @return
     */
    public Auto[] cargarArrayBinary(){
        Auto []array= new Auto[lista.size()];
        int elements=0;
        for(int i=0; i<lista.size(); i++){
            array[elements]=lista.get(i);
            elements++;
        }
        return array;
    }

    /**
     * 
     * @return
     */
    public int elegirColumna(){
        System.out.println("Elige columna ordenar");
        System.out.println("1- Nombre");
        System.out.println("2- Año");
        entrada= new Scanner(System.in);
        int columna = entrada.nextInt();
        if(columna>0 && columna<=2){
            return columna;
        }else{
            System.out.println("Seleccione una columna valida");
            elegirColumna();
        }
        return columna;
    }
}
