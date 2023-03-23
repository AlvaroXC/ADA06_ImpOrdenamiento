import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class QuickSort{
    private Auto[] theArray;          // ref to array theArray
    private int nElems;               // number of data items

    /**
     * 
     * @param max
     */
    public QuickSort(int max){
      theArray = new Auto[max];      // create array
      nElems = 0;
    }

    /**
     * 
     * @param value
     */

    public void insert(Auto value){
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
    }


    public void display() {
      for(int j=0; j<nElems; j++)    // for each element,
         System.out.print(theArray[j].getNombre()+" "+theArray[j].getAnio() + "\n");  // display it
      System.out.println("");
    }

    /**
     * 
     * @param i
     * @param j
     */
    void swap(int i, int j){
        Auto temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
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
        
        int pivot = theArray[high].getAnio();
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++){
            if (theArray[j].getAnio()<(pivot)){
                i++;
                swap(i, j);
            }
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
        
        int pivot = theArray[high].getAnio();
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++){
            if (theArray[j].getAnio()>(pivot)){
                i++;
                swap(i, j);
            }
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
    int partitionString(int low, int high){
        String pivot = theArray[high].getNombre().toLowerCase();
        int i = (low-1);
        for(int j = low; j <= high - 1; j++){
            if ((theArray[j].getNombre().toLowerCase()).compareTo(pivot)<0){
                i++;
                swap(i, j);
            }
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
        String pivot = theArray[high].getNombre().toLowerCase();
        int i = (low-1);
        for(int j = low; j <= high - 1; j++){
            if ((theArray[j].getNombre().toLowerCase()).compareTo(pivot)>0){
                i++;
                swap(i, j);
            }
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
    public void generarCSV(String salida){
        try {
            File file = new File(salida);
            PrintWriter writer = new PrintWriter(file);
            // Escribir encabezados
            writer.println("Car_Name,Year,Selling_Price,Present_Price,Kms_Driven,Fuel_Type,Seller_Type,Transmission,Owner");
            // Escribir datos
            for (Auto auto : theArray) {
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