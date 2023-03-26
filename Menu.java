import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    private LinkedList<Auto> lista = new LinkedList<>();
    Scanner entrada;

    /**
     * Constructor de la clase Menu que recibe una LinkedList y la asocia otra para
     * @param lista
     */
    public Menu(LinkedList <Auto> lista){
        this.lista = lista;
    }

    /**
     * Devuelve la forma de ordenar la lista, ascendente 1 y descendenre 2
     * @return int 
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
     * devuelve que dato se tomara en cuenta para ordenar la lista, nombre 1, anio 2
     * @return int 
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


    /**
     * le envia a cada algoritmo la lista, la forma en la cual se va ordenar la lista y el dato que se tomara
     * en cuenta para ordenarla y generamos un archivo csv para ver la lista ordenada
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
        brSort.binaryInsertionSort(lista.size(),columna,forma);
        brSort.generarCSV();
    }



}
