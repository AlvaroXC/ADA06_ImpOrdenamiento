import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class BinaryInsertionSort {
    private LinkedList<Auto> a = new LinkedList<>();
    private int intercambios;
    private int comparaciones;

    public BinaryInsertionSort(LinkedList<Auto> a){
        this.a= a;
        intercambios=0;
        comparaciones=0;
    }
    
    public int getComparaciones() {
        return comparaciones;
    }
    public int getIntercambios() {
        return intercambios;
    }

    /**
     * 
     * @param a
     * @param item
     * @param low
     * @param high
     * @param orden
     * @return
     */
    public int binarySearchAnio(Auto item, int low, int high, int orden){
        if(orden==1){
            while (low <= high) {
                int mid = low + (high - low) / 2; //divide el arreglo en dos
                //item.getAnio() == a[mid].getAnio()
                if (item.getAnio()==a.get(mid).getAnio())
                    return mid + 1;
                else if (item.getAnio()>a.get(mid).getAnio())
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }else{
            while (low <= high) {
                int mid = low + (high - low) / 2; //divide el arreglo en dos
                if (item.getAnio() == a.get(mid).getAnio())
                    return mid + 1;
                else if (item.getAnio()<a.get(mid).getAnio())
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        comparaciones++;

        return low;
    }

    /**
     * 
     * @param a
     * @param item
     * @param low
     * @param high
     * @param orden
     * @return
     */
    public int binarySearchNombre(Auto item, int low, int high, int orden){
        if(orden==1){
            while (low <= high) {
                int mid = low + (high - low) / 2; //divide el arreglo en dos
                if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase())==0))
                    return mid + 1;
                else if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase()))>0)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }else{
            while (low <= high) {
                int mid = low + (high - low) / 2; //divide el arreglo en dos
                if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase())==0))
                    return mid + 1;
                else if ((item.getNombre().toLowerCase().compareTo(a.get(mid).getNombre().toLowerCase()))<0)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        comparaciones++;
        return low;
    }

    /**
     * 
     * @param a
     * @param n
     * @param columna
     * @param orden
     */

    public void binaryInsertionSort(int n,  int columna,int orden) {
        int i, loc=0, j;
        Auto selected;
    
        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = a.get(i);
    
            if(columna==1){
                loc = binarySearchNombre(selected, 0, j,orden);
            }else{
                loc = binarySearchAnio(selected, 0, j,orden);

            }
            // encuentra la posicion donde debe ser insertado el elemento
    
            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                a.set(j+1, a.get(j));
                //a[j + 1] = a[j];
                j--;
                intercambios++;
            }
            a.set(j+1, selected);
            //a[j + 1] = selected;
        }
    }

    /**
     * 
     * @param a
     * @param salida
     */
    public void generarCSV(){
        try {
            File file = new File("BinaryInsertionSort_Ordenado.csv");
            PrintWriter writer = new PrintWriter(file);
            // Escribir encabezados
            writer.println("Car_Name,Year,Selling_Price,Present_Price,Kms_Driven,Fuel_Type,Seller_Type,Transmission,Owner");
            // Escribir datos
            for (Auto auto : a) {
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