import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.FileWriter;
// import java.io.IOException;
import java.util.LinkedList;

public class DAO {
    public static void main(String[] args) {
        iniciarCarga();
    }

    public static void iniciarCarga(){
        LinkedList <Auto> lista = new LinkedList<>();
        String linea;
        try{
            BufferedReader leer = new BufferedReader(new FileReader("cardata.csv"));
            while((linea=leer.readLine())!=null){
                String [] fila = linea.split(",");
                Auto auto = new Auto(fila[0].toString(), Integer.parseInt(fila[1]), Double.parseDouble(fila[2]), Double.parseDouble(fila[3]), Integer.parseInt(fila[4]), 
                fila[5].toString(), fila[6].toString(), fila[7].toString(), Integer.parseInt(fila[8]));
                lista.add(auto);
            }
            
            for(int i=0; i<lista.size(); i++){
                System.out.println(lista.get(i).getAnio()+" "+lista.get(i).getNombre());
            }
            leer.close();

        }catch(Exception e){
            System.out.println(e);;
        }
    }

}
