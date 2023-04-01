package src.Algoritmos;
import java.util.LinkedList;
import src.Modelo.Auto;
/**
 * Clase que implementa el algoritmo MergeSort para ordenar una lista de Autos.
 * Guarda el número de intercambios y comparaciones realizados durante el proceso de ordenamiento.
 */
public class MergeSort {
private LinkedList<Auto> a;
private int intercambios;
private int comparaciones;
/**
 * Constructor de la clase MergeSort.
 *
 * @param a lista de datis a ordenar
 */
public MergeSort(LinkedList<Auto> a) {
    this.a = a;
    intercambios = 0;
    comparaciones = 0;
}


public int getIntercambios() {
    return intercambios;
}

public int getComparaciones() {
    return comparaciones;
}

/**
 * Método que combina dos sublistas ordenadas en una sola lista ordenada.
 *
 * @param l inicio de la primera sublista
 * @param m fin de la primera sublista e inicio de la segunda sublista
 * @param r fin de la segunda sublista
 * @param columna columna por la que se ordenarán los datos del dataSet (1 para nombre, 2 para año)
 * @param orden 1 si se ordenará de manera ascendente, -1 si se ordenará de manera descendente
 */
public void merge(int l, int m, int r, int columna, int orden) {
    LinkedList<Auto> L = new LinkedList<Auto>(a.subList(l, m + 1));
    LinkedList<Auto> R = new LinkedList<Auto>(a.subList(m + 1, r + 1));

    int i = 0, j = 0, k = l;

    // Compara los elementos de las dos sublistas y los junta en orden.
    while (i < L.size() && j < R.size()) {
        if ((columna == 1 && (orden == 1 ? L.get(i).getNombre().toLowerCase().compareTo(R.get(j).getNombre().toLowerCase()) <= 0 : L.get(i).getNombre().toLowerCase().compareTo(R.get(j).getNombre().toLowerCase()) > 0))
                || (columna == 2 && (orden == 1 ? L.get(i).getAnio() <= R.get(j).getAnio() : L.get(i).getAnio() > R.get(j).getAnio()))) {
            a.set(k++, L.get(i++));
        } else {
            a.set(k++, R.get(j++));
        }
        comparaciones++;
        intercambios++;
    }

    // Agrega los elementos restantes de la sublista izquierda.
    while (i < L.size()) {
        a.set(k++, L.get(i++));
        intercambios++;
    }

    // Agrega los elementos restantes de la sublista derecha.
    while (j < R.size()) {
        a.set(k++, R.get(j++));
        intercambios++;
    }
}

/**
 * Método que divide la lista en sublistas más pequeñas y las combina usando el método merge.
 *
 * @param l inicio de la sublista
 * @param r fin de la sublista
 * @param columna columna por la que se ordenarán los datos del dataSet (1 para nombre, 2 para año)
 * @param orden 1 si se ordenará de manera ascendente, -1 si se ordenará de manera descendente
 */
public void mergeSort(int l, int r, int columna, int orden) {
    if (l < r) {
        int m = (l + r) / 2;
        mergeSort(l, m, columna, orden);
        mergeSort(m + 1, r, columna, orden);
        merge(l, m, r, columna, orden);
    }
}
}
