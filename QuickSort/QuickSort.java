import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * La clase implementa el algoritmo de ordenamineto Quick Sort
 * en donde se utiliza una LinkedList que almacena objetos de tipo Auto, la cual se ordena por 
 * anio o por nombre, ambos de forma ascendente o descendente y tambien puede generar
 * un csv en donde se muestra el resultado del ordenamiento
 * 
 */

public class QuickSort{
    LinkedList <Auto> lista = new LinkedList<>();        
    private int comparaciones;
    private int intercambios;
               

    /**
     * 
     * @param lista
     */
    public QuickSort( LinkedList <Auto> lista){
      this.lista= lista;     
      comparaciones=0;
      intercambios=0;
    }


    /**
     * Muestra el nombre y el anio de todos los objetos de la lista 
     */
    public void display() {
      for(int j=0; j<lista.size(); j++)   
         System.out.print(lista.get(j).getNombre()+" "+lista.get(j).getAnio() + "\n"); 
      System.out.println("");
    }

    /**
     * Hace el intercambio de datos entre los nodos de la lista para ordenarla
     * @param i
     * @param j
     */
    void swap(int i, int j){
        Auto temp = lista.get(i);
        Auto tempJ= lista.get(j);
        lista.set(i, tempJ);
        lista.set(j, temp);
        intercambios++;
    }


    /**
     * Toma el ultimo elemento de la lista para hacer las comparaciones e ir ordenandola 
     * de forma ascendente segun el anio del objeto
     * 
     * @param low
     * @param high
     * @return int 
     */
    int partition(int low, int high){
        
        int pivot = lista.get(high).getAnio();
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++){
            if (lista.get(i).getAnio()<(pivot)){
                i++;
                swap(i,j);
            }
            comparaciones++;
        }
        swap(i + 1, high);
        return (i + 1);
    }

    /**
     * Toma el ultimo elemento de la lista para hacer las comparaciones e ir ordenandola 
     * de forma descendente segun el anio del objeto 
     * 
     * @param low
     * @param high
     * @return
     */
    int partitionDescendente(int low, int high){
        
        int pivot = lista.get(high).getAnio();
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++){
            if (lista.get(j).getAnio()>(pivot)){
                i++;
                swap(i, j);
            }
            comparaciones++;
        }
        swap(i + 1, high);
        return (i + 1);
    }

    /**
     * Obtiene el total de comparaciones que hizo del algoritmo
     * @return int
     */
    public int getComparaciones() {
        return comparaciones;
    }

    /**
     * Obtiene el total de intercambios que hizo el algoritmo
     * @return
     */
    public int getIntercambios() {
        return intercambios;
    }

    /**
     * Toma el ultimo elemento de la lista para hacer las comparaciones e ir ordenandola 
     * de forma ascendente segun el nombre del objeto
     * 
     * @param low
     * @param high
     * @return
     */
    int partitionString(int low, int high){
        String pivot = lista.get(high).getNombre().toLowerCase();
        int i = (low-1);
        for(int j = low; j <= high - 1; j++){
            if ((lista.get(j).getNombre().toLowerCase()).compareTo(pivot)<0){
                i++;
                swap(i, j);
            }
            comparaciones++;
        }
        swap(i + 1, high);
        return (i + 1);
    }

    /**
     * Toma el ultimo elemento de la lista para hacer las comparaciones e ir ordenandola 
     * de forma descendente segun el nombre del objeto
     * 
     * @param low
     * @param high
     * @return int
     */
    int partitionStringDescendente(int low, int high){
        String pivot = lista.get(high).getNombre().toLowerCase();
        int i = (low-1);
        for(int j = low; j <= high - 1; j++){
            if ((lista.get(j).getNombre().toLowerCase()).compareTo(pivot)>0){
                i++;
                swap(i, j);
            }
            comparaciones++;
        }
        swap(i + 1, high);
        return (i + 1);
    }
    
    /**
     * Se designa cual sera el dato del objeto a comparar y la forma de ordenarla
     * 
     * @param low
     * @param high
     * @param opcion dato que se usara para las comparaciones 1 nombre y 2 anio
     * @param orden forma en la cual se ordenara, ascendente 1 y descendente 2 
     */
    void recQSort(int low, int high, int opcion, int orden){
        if (low < high){
            int pi;
            
            if(opcion==1 && orden==1){
                pi = partitionString(low, high);
                recQSort(low, pi - 1, opcion,orden);
                recQSort(pi + 1, high,opcion,orden);
            }
            else if(opcion==1 && orden==2){
                pi = partitionStringDescendente(low, high);
                recQSort(low, pi - 1, opcion,orden);
                recQSort(pi + 1, high,opcion,orden);
            }
            else if(opcion==2 && orden==1){
                pi = partition(low, high);
                recQSort(low, pi - 1, opcion,orden);
                recQSort(pi + 1, high,opcion,orden);

            }else{
                pi = partitionDescendente(low, high);
                recQSort(low, pi - 1, opcion,orden);
                recQSort(pi + 1, high,opcion,orden);
            }
    
        }
    }


    /**
     * Genera el archivo donde se muestra la lista ordena con los objetos de tipo Auto
     * @exception FileNotFoundException no se encuentra el archivo
    */
    public void generarCSV(){
        try {
            File file = new File("QuickSort_Ordenado.csv");
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
}