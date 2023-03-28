
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;
import Algoritmos.QuickSort.QuickSort;
import Algoritmos.BinaryInsertionSort.BinaryInsertionSort;
import Modelo.Auto;


public class Menu {
    Scanner entrada;

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
     * lista y el dato que se tomara en cuenta para ordenarla,
     * generamos un archivo csv para ver la lista de cada algoritmo y otro archivo csv de sus metricas de los mismos
    */
    public void ejecutarAlgoritmos() {
        DAO list = new DAO();
        LinkedList<Auto> lista = new LinkedList<>();
        int columna, forma;
        long tiempoInicio, tiempoFinal, tiempoTotal;
        columna = elegirColumna();
        forma = formaOrdenadar();

        lista = list.iniciarCarga();
        tiempoInicio = System.currentTimeMillis();
        QuickSort qSort = new QuickSort(lista);
        qSort.recQSort(0, lista.size() - 1, columna, forma);
        tiempoFinal= System.currentTimeMillis();
        tiempoTotal = tiempoFinal-tiempoInicio;
        generarCSV("QuickSort_Ordenado.csv", lista);
        generarMetricas("MetricaQuick.csv",qSort.getComparaciones(), qSort.getIntercambios(), tiempoTotal);
        

        lista = list.iniciarCarga();
        tiempoInicio = System.currentTimeMillis();
        BinaryInsertionSort brSort = new BinaryInsertionSort(lista);
        brSort.binaryInsertionSort(lista.size(), columna, forma);
        tiempoFinal= System.currentTimeMillis();
        tiempoTotal = tiempoFinal-tiempoInicio;
        generarCSV("BinaryInsertionSort_ordenado.csv", lista);
        generarMetricas("MetricaBinary.csv",brSort.getComparaciones(), brSort.getIntercambios(), tiempoTotal);
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


    public void generarMetricas(String archivo,int comparaciones, int intercambios, long tiempoTotal){
        try {
            File file = new File(archivo);
            PrintWriter writer = new PrintWriter(file);
            // Escribir encabezados
            writer.println("Comparaciones, Intercambios, Tiempo de Ejecucion");
            writer.println(comparaciones+","+ intercambios+","+tiempoTotal );
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
