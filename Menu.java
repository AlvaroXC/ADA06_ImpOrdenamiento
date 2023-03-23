import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    private LinkedList<Auto> lista = new LinkedList<>();
    Scanner entrada;

    public Menu(LinkedList <Auto> lista){
        this.lista = lista;
    }

    int formaOrdenadar(){
        System.out.println("Elige forma de ordenar");
        System.out.println("1- Ascendente");
        System.out.println("2- Descendente");
        entrada= new Scanner(System.in);
        int forma = entrada.nextInt();
        return forma;
    }

   public void elegirAlgoritmo(){
        System.out.println("Especifica el algoritmo a utilizar");
        System.out.println("1- QuickSort");
        System.out.println("2- Binary Insertion Sort");
        entrada = new Scanner(System.in);
        int numAlgoritmo = entrada.nextInt();
        int columna, forma;

        switch (numAlgoritmo) {
            case 1:
                columna = elegirColumna();
                forma = formaOrdenadar();
                QuickSort qSort= new QuickSort(lista.size());
                cargarArrayQuick(qSort);
                qSort.recQSort(0, lista.size()-1,columna,forma);
                break;
            case 2:
                columna = elegirColumna();
                forma = formaOrdenadar();
                BinaryInsertionSort brSort = new BinaryInsertionSort();
                Auto array[] = cargarArrayBinary();
                brSort.binaryInsertionSort(array, lista.size());
                break;
                
            default:
                break;
        }
    }

    public void cargarArrayQuick(QuickSort qSort){
        for (int i = 0; i < lista.size(); i++) {
            qSort.insert(lista.get(i));
        }
    } 

    public Auto[] cargarArrayBinary(){
        Auto []array= new Auto[lista.size()];
        int elements=0;
        for(int i=0; i<lista.size(); i++){
            array[elements]=lista.get(i);
            elements++;
        }
        return array;
    }

    public int elegirColumna(){
        System.out.println("Elige columna ordenar");
        System.out.println("1- Año");
        System.out.println("2- Nombre");
        entrada= new Scanner(System.in);
        int columna = entrada.nextInt();
        return columna;
    }
}
