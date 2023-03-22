import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.FileWriter;
// import java.io.IOException;
import java.util.LinkedList;


public class QuickSortApp{


    public static void main(String[] args){
        iniciarCarga();
        // int maxSize = 100;             // array size
        // QuickSort<String> qSort = new QuickSort<String>(maxSize);

        // qSort.display();                 // display items
        
        // qSort.recQSort(0,11);
 
        // qSort.display();                // display items
    }

    public static void iniciarCarga(){
        LinkedList <String> lista = new LinkedList<>();
        //QuickSort <String> qSort = new QuickSort<>(lista.size());
        String linea;
        try{
            BufferedReader leer = new BufferedReader(new FileReader("covid_worldwide.csv"));
            while((linea=leer.readLine())!=null){   
                lista.add(linea);
            }
            System.out.println();
            leer.close();

        }catch(Exception e){
        }
    }
}