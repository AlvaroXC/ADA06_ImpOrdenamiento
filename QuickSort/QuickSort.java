import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class QuickSort{
    LinkedList <Auto> lista = new LinkedList<>();        // ref to array theArray
    private int comparaciones;
    private int intercambios;
    private int nElems;               // number of data items

    /**
     * 
     * @param max
     */
    public QuickSort( LinkedList <Auto> lista){
      this.lista= lista;     // create array
      comparaciones=0;
      intercambios=0;
      nElems=0;
    }

    /**
     * 
     * @param value
     */

    public void insert(Auto value){
        lista.add(nElems, value);
        nElems++;                      // increment size
    }


    public void display() {
      for(int j=0; j<lista.size(); j++)    //for each element,
         System.out.print(lista.get(j).getNombre()+" "+lista.get(j).getAnio() + "\n");  //display it
      System.out.println("");
    }

    /**
     * 
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
    
    /* toma el ultimo elemento como pivote, 
    coloca el pivote en su posicion correcta del arreglo ordenado,
    coloca todos los valores mas pequeños (menores a los pivotes)
    a la izquierda del pivote y coloca todos los valores mas grandes 
    (mayores a los pivotes) a la derecha del pivote 
    */

    /**
     * 
     * @param low
     * @param high
     * @return
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

    public int getComparaciones() {
        return comparaciones;
    }

    public int getIntercambios() {
        return intercambios;
    }

    /**
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
     * 
     * @param low
     * @param high
     * @return
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
     * 
     * @param low
     * @param high
     * @param opcion
     * @param orden
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
     * 
     * @param salida
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