
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import Algoritmos.QuickSort.QuickSort;
import Algoritmos.BinaryInsertionSort.BinaryInsertionSort;
import Modelo.Auto;


public class Menu {
    Scanner entrada;
    ArrayList<String[]> metricas = new ArrayList<>();
    /**
     * Devuelve la forma de ordenar la lista, ascendente 1 y descendenre 2
     * 
     * @return int
     */

    public int formaOrdenadar() {
        System.out.println("Elige forma de ordenar");
        System.out.println("1- Ascendente");
        System.out.println("2- Descendente");
        entrada = new Scanner(System.in);
        int forma = entrada.nextInt();
        if (forma > 0 && forma <= 2) {
            return forma;
        } else {
            System.out.println("Elige una forma valida");
            formaOrdenadar();
        }
        return forma;
    }

    /**
     * devuelve que dato se tomara en cuenta para ordenar la lista, nombre 1, anio 2
     * 
     * @return int
     */
    public int elegirColumna() {
        System.out.println("Elige columna ordenar");
        System.out.println("1- Nombre");
        System.out.println("2- Año");
        entrada = new Scanner(System.in);
        int columna = entrada.nextInt();
        if (columna > 0 && columna <= 2) {
            return columna;
        } else {
            System.out.println("Seleccione una columna valida");
            elegirColumna();
        }
        return columna;
    }

    /**
     * le envia a cada algoritmo la lista, la forma en la cual se va ordenar la
     * lista y el dato que se tomara en cuenta para ordenarla, almacenamos en un ArrayList los valores de nombre del algoritmo,
     * comparaciones, intercambios y tiempo total, 
     * generamos un archivo csv para ver la lista ordenada de cada algoritmo
    */
    public void ejecutarAlgoritmos() {
        DAO list = new DAO();
        LinkedList<Auto> lista = new LinkedList<>();
        int columna, forma;
        String comparaciones, intercambios, tiempoTotalS;
        long tiempoInicio, tiempoFinal, tiempoTotal;
        columna = elegirColumna();
        forma = formaOrdenadar();

        lista = list.iniciarCarga();
        tiempoInicio = System.currentTimeMillis();
        QuickSort qSort = new QuickSort(lista);
        qSort.recQSort(0, lista.size() - 1, columna, forma);
        tiempoFinal= System.currentTimeMillis();
        tiempoTotal = tiempoFinal-tiempoInicio;
        //generarCSV("QuickSort_Ordenado.csv", lista);
        comparaciones = Integer.toString(qSort.getComparaciones());
        intercambios = Integer.toString(qSort.getIntercambios());
        tiempoTotalS = Long.toString(tiempoTotal);
        metricas.add(new String[] {"QuickSort", comparaciones, intercambios, tiempoTotalS});
        
        lista = list.iniciarCarga();
        tiempoInicio = System.currentTimeMillis();
        BinaryInsertionSort brSort = new BinaryInsertionSort(lista);
        brSort.binaryInsertionSort(lista.size(), columna, forma);
        tiempoFinal= System.currentTimeMillis();
        tiempoTotal = tiempoFinal-tiempoInicio;
        comparaciones = Integer.toString(brSort.getComparaciones());
        intercambios = Integer.toString(brSort.getIntercambios());
        tiempoTotalS = Long.toString(tiempoTotal);
        metricas.add(new String[]{"BinaryInsertionSort", comparaciones, intercambios, tiempoTotalS});

        generarMetricas();
    }

    /**
     *  
     * Genera el archivo donde se muestra la lista ordena de cada algoritmo con los objetos de tipo Auto
     * @param lista lista ordenada 
     * @param archivo nombre del archivo donde se mostrara ordenada la lista
     * @exception FileNotFoundException no se encuentra el archivo
     */
    public void generarCSV(String archivo,LinkedList<Auto> lista){
        try {
            File file = new File(archivo);
            PrintWriter writer = new PrintWriter(file);
            // Escribir encabezados
            writer.println("Car_Name,Year,Selling_Price,Present_Price,Kms_Driven,Fuel_Type,Seller_Type,Transmission,Owner");
            // Escribir datos
            for (Auto auto : lista) {
                writer.println(auto.getNombre() + "," + auto.getAnio() + "," + auto.getPrecioVenta() + "," + auto.getPrecioActual()+","+
                auto.getKilometraje()+","+auto.getTipoCombustible()+","+auto.getTipoVendedor()+","+
                auto.getTransmision()+","+auto.getPropietarios());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera un archivo csv con las metricas de cada algoritmo leyendo un el arraylist metricas
     */

    public void generarMetricas() {
    
        try {
            FileWriter writer = new FileWriter("Metricas.csv");
            writer.append("Nombre");
            writer.append(",");
            writer.append("Comparaciones");
            writer.append(",");
            writer.append("Intercambios");
            writer.append(",");
            writer.append("Tiempo de Ejecucion");
            writer.append("\n");
            for (String[] row : metricas) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(row[i]);
                    if (i < row.length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
