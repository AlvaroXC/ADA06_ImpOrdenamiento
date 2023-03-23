import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DAO {

    public static void main(String[] args) {
        String archivo = args[0];
        String salida = args[1];
        iniciarCarga(archivo,salida);
    }

    /**
     * 
     * @param archivo
     * @param salida
     */
    public static void iniciarCarga(String archivo, String salida){
        LinkedList <Auto> lista = new LinkedList<>();

        try{
            File file = new File(archivo);
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
            menu.elegirAlgoritmo(salida);

        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }
    }


}
