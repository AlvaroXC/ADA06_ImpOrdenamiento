package src.Algoritmos;

import java.util.LinkedList;
import src.Modelo.Auto;

    /**
     * Clase que implementa el algoritmo de ordenamiento Radix Sort para ordenar objetos de tipo Auto según una columna especificada.
     */
public class RadixSort {

    private LinkedList<Auto> a;
    private int intercambios;
    private int comparaciones;
		
		/**
         * Constructor de la clase RadixSort.
         * @param a Lista de objetos Auto a ordenar.
         */

    public RadixSort(LinkedList<Auto> a) {
        this.a = a;
        intercambios = 0;
        comparaciones = 0;
    }
		/**
         * Retorna el número de intercambios realizados durante la ejecución del algoritmo.
         * @return Número de intercambios.
         */

    public int getIntercambios() {
        return intercambios;
    }
  		/**
         * Retorna el número de comparaciones realizadas durante la ejecución del algoritmo.
         * @return Número de comparaciones.
         */
    public int getComparaciones() {
        return comparaciones;
    }

	 	/**
         * Método que realiza el ordenamiento Radix Sort.
         * @param columna Columna a utilizar para ordenar los objetos (1 para Nombre, 2 para Año).
         * @param orden Orden en el que se deben ordenar los objetos (1 para ascendente, -1 para descendente).
         */

    public void radixSort(int columna, int orden) {

        int n = a.size();

        // Encuentra el valor máximo en la columna especificada
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (columna == 1) {
                if (a.get(i).getNombre().length() > maxVal) {
                    maxVal = a.get(i).getNombre().length();
                }
            } else if (columna == 2) {
                if (a.get(i).getAnio() > maxVal) {
                    maxVal = a.get(i).getAnio();
                }
            }
        }

        // Hace el conteo de los dígitos
        for (int digit = 1; maxVal / digit > 0; digit *= 10) {

            LinkedList<Auto>[] buckets = new LinkedList[10];
            for (int i = 0; i < 10; i++) {
                buckets[i] = new LinkedList<Auto>();
            }

            // Coloca los objetos en su correspondiente cubeta
            for (int i = 0; i < n; i++) {
                int bucketIdx = 0;
                if (columna == 1) {
                    if (a.get(i).getNombre().length() >= digit) { // Agregamos esta validación para evitar el error IndexOutOfBounds
                        if (orden == 1) {
                            bucketIdx = (a.get(i).getNombre().toLowerCase().charAt(a.get(i).getNombre().length() - digit) - 'a');
                        } else {
                            bucketIdx = 9 - (a.get(i).getNombre().toLowerCase().charAt(a.get(i).getNombre().length() - digit) - 'a');
                        }
                    }
                } else if (columna == 2) {
                    if (orden == 1) {
                        bucketIdx = (a.get(i).getAnio() / digit) % 10;
                    } else {
                        bucketIdx = 9 - ((a.get(i).getAnio() / digit) % 10);
                    }
                }
                buckets[bucketIdx].add(a.get(i));
            }

            // Une las cubetas en una sola lista
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    a.set(idx++, buckets[i].get(j));
                    intercambios++;
                }
            }
        }
    }
}