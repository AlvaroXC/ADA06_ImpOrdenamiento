import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BinaryInsertionSort {
 
//  implementacion iterativa 
    public int binarySearch(Auto a[], Auto item, int low, int high){
        while (low <= high) {
            int mid = low + (high - low) / 2; //divide el arreglo en dos
            if (item.getAnio() == a[mid].getAnio())
                return mid + 1;
            else if (item.getAnio() > a[mid].getAnio())
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public void binaryInsertionSort(Auto a[], int n) {
        int i, loc, j;
        Auto selected;
    
        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = a[i];
    
            // encuentra la posicion donde debe ser insertado el elemento
            loc = binarySearch(a, selected, 0, j);
    
            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = selected;
        }
        generarCSV(a);
    }

    public void generarCSV(Auto a[]){
        try {
            File file = new File("BinaryInsertionSort_ordenado.csv");
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