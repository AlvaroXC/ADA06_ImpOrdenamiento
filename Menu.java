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
   public void ejecutarAlgoritmos(){
        int columna, forma;
        columna = elegirColumna();
        forma = formaOrdenadar();


        QuickSort qSort= new QuickSort(lista);
        qSort.recQSort(0, lista.size()-1,columna,forma);
        System.out.println("Intercambios: "+qSort.getIntercambios()+" Comparaciones "+qSort.getComparaciones());
        qSort.generarCSV();

        BinaryInsertionSort brSort = new BinaryInsertionSort(lista);
        brSort.binaryInsertionSort(lista.size(),forma,columna);
        brSort.generarCSV();
    }

    /**
     * 
     * @param qSort
     */

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
