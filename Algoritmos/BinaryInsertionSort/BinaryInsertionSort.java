package Algoritmos.BinaryInsertionSort;
import java.util.LinkedList;
import Modelo.Auto;

/**
 * La clase implementa el algoritmo de ordenamineto Binary Insertion Sort 
 * en donde se utiliza una LinkedList que almacena datos de tipo Auto, la cual se ordena por 
 * anio o por nombre, ambos de forma ascendente o descendente y tambien puede generar
 * un csv en donde se muestra el resultado del ordenamiento
 * 
 */
public class BinaryInsertionSort {
    private LinkedList<Auto> a = new LinkedList<>();
    private int intercambios;
    private int comparaciones;

    public BinaryInsertionSort(LinkedList<Auto> a) {
        this.a = a;
        intercambios = 0;
        comparaciones = 0;
    }

    /**
     * Obtiene el total de comparaciones del algoritmo
     * @return int 
     */
    public int getComparaciones() {
        return comparaciones;
    }

    /**
     * Obtiene el total de intercambios del algoritmo
     * @return int 
     */
    public int getIntercambios() {
        return intercambios;
    }

    /**
     * Se indica como se va a ordenar la lista si de forma ascendente con orden 1 o de forma
     * descendente con orden 0 segun el anio del objeto Auto. 
     * Se devuelve la posicon donde se debe insertar el item 
     * 
      * @param item dato que se utilizara para comparar
     * @param low 
     * @param high 
     * @param orden forma en la cual se ordenara, ascendete o descendente
     * @return int 
     */
    public int binarySearchAnio(Auto item, int low, int high, int orden) {
        if (orden == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (item.getAnio() == a.get(mid).getAnio())
                    return mid + 1;
                else if (item.getAnio() > a.get(mid).getAnio())
                    low = mid + 1;
                else
                    high = mid - 1;

                comparaciones++;
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (item.getAnio() == a.get(mid).getAnio())
                    return mid + 1;
                else if (item.getAnio() < a.get(mid).getAnio())
                    low = mid + 1;
                else
                    high = mid - 1;

                comparaciones++;
            }
        }

        return low;
    }

    /**
     * Se indica como se va a ordenar la lista si de forma ascendente con orden 1 o de forma
     * descendente con orden 0 segun el nombre del objeto Auto. 
     * Se devuelve la posicon donde se debe insertar el item 
     * 
     * @param item dato que se utilizara para comparar
     * @param low 
     * @param high 
     * @param orden forma en la cual se ordenara, ascendete o descendente
     * @return int 
     */
    public int binarySearchNombre(Auto item, int low, int high, int orden) {
        if (orden == 1) {
            while (low <= high) {
                int mid = low + (high - low) / 2; 
                if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase()) == 0))
                    {comparaciones++;
                        return mid + 1;}
                else if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase())) > 0)
                    {low = mid + 1;
                    comparaciones += 2;}
                else
                    {high = mid - 1;
                    comparaciones+=2;}
                
                
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2; 
                if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase()) == 0))
                    return mid + 1;
                else if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase())) < 0)
                    low = mid + 1;
                else
                    high = mid - 1;

                comparaciones++;
            }
        }
        return low;
    }

    /**
     * Se busca la posicion correcta de cada elemento Auto en la lista, y se inserta alli
     * 
     * @param size tamanio de la lista
     * @param columna dato el cual se utilizara para ordenar la lista
     * @param orden forma en la cual se ordenara, ascendete o descendente
     */

    public void binaryInsertionSort(int size, int columna, int orden) {
        int i, loc = 0, j;
        Auto selected;

        for (i = 1; i < size; ++i) {
            j = i - 1;
            selected = a.get(i);

            if (columna == 1) {
                loc = binarySearchNombre(selected, 0, j, orden);
            } else {
                loc = binarySearchAnio(selected, 0, j, orden);

            }

            while (j >= loc) {
                a.set(j + 1, a.get(j));
                intercambios++;
                j--;
               
            }
            a.set(j + 1, selected);
            intercambios++;

        }
    }




}