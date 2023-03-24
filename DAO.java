import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DAO {

    public static void main(String[] args) {
        iniciarCarga();
    }

    /**
     * 
     * @param archivo
     * @param salida
     */
    public static void iniciarCarga(){
        LinkedList <Auto> lista = new LinkedList<>();

        try{
            File file = new File("cardata.csv");
            Scanner leer = new Scanner(file);

            if(leer.hasNext()){
                leer.nextLine();
            }
            while(leer.hasNextLine()){
                String linea = leer.nextLine();
                StringTokenizer separador= new StringTokenizer(linea,",");
                String nombre= separador.nextToken();
                int anio= Integer.parseInt(separador.nextToken());
                double precioVenta= Double.parseDouble(separador.nextToken());
                double precioActual=Double.parseDouble(separador.nextToken());
                int kilometraje=Integer.parseInt(separador.nextToken());
                String tipoCombustible=separador.nextToken();
                String tipoVendedor=separador.nextToken();
                String transmision=separador.nextToken();
                int propietarios=Integer.parseInt(separador.nextToken());
                Auto auto = new Auto(nombre, anio, precioVenta, precioActual, kilometraje, tipoCombustible, tipoVendedor, transmision, propietarios);
                lista.add(auto);
            }
            leer.close();

            Menu menu = new Menu(lista);
            menu.ejecutarAlgoritmos();

        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }
    }


}
