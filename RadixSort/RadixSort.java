package Algoritmos.RadixSort;
import java.util.LinkedList;

import Modelo.Auto;

public class RadixSort {
	LinkedList<Auto> lista = new LinkedList<>();
	private int comparaciones;
	private int intercambios;
	public RadixSort(LinkedList<Auto> lista) {
		this.lista = lista;
		comparaciones = 0;
		intercambios = 0;
	}
	
	public void display() {
		for (int j = 0; j < lista.size(); j++)
			System.out.print(lista.get(j).getNombre() + " " + lista.get(j).getAnio() + "\n");
		System.out.println("");
	}
	
	void swap(int i, int j) {
		Auto temp = lista.get(i);
		Auto tempJ = lista.get(j);
		lista.set(i, tempJ);
		lista.set(j, temp);
		intercambios++;
	}
	
	public int getComparaciones() {
		return comparaciones;
	}
	
	public int getIntercambios() {
		return intercambios;
	}
	
	int getMaxAnio() {
		int max = lista.get(0).getAnio();
		for (int i = 1; i < lista.size(); i++)
			if (lista.get(i).getAnio() > max)
				max = lista.get(i).getAnio();
		return max;
	}
	
	void countSort(int exp) {
		int n = lista.size();
		Auto[] output = new Auto[n];
		int i;
		int[] count = new int[10];
		for (i = 0; i < n; i++)
			count[(lista.get(i).getAnio() / exp) % 10]++;
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		for (i = n - 1; i >= 0; i--) {
			output[count[(lista.get(i).getAnio() / exp) % 10] - 1] = lista.get(i);
			count[(lista.get(i).getAnio() / exp) % 10]--;
		}
		for (i = 0; i < n; i++)
			lista.set(i, output[i]);
	}
	
	void radixsort() {
		int m = getMaxAnio();
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(exp);
		}
	}
	
	void recRadixSort(int left, int right, int opcion) {
		if (left  < right) {
			int middle = left + (right - left) / 2;
			recRadixSort(left, middle, opcion);
			recRadixSort(middle + 1, right, opcion);
		}
	}

	/*public void generarCSV() {
		try {
			File file = new File("RadixSort_Ordenado.csv");
			PrintWriter writer = new PrintWriter(file);
			// Escribir encabezados
			writer.println("Car_Name,Year,Selling_Price,Present_Price,Kms_Driven,Fuel_Type,Seller_Type,Transmission,Owner");
			// Escribir datos
			for (Auto auto : lista) {
				writer.println(auto.getNombre() + "," + auto.getAnio() + "," + auto.getPrecioVenta() + ","
						+ auto.getPrecioActual() + "," + auto.getKilometraje() + "," + auto.getTipoCombustible() + ","
						+ auto.getTipoVendedor() + "," + auto.getTransmision() + "," + auto.getPropietarios());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}*/

}
