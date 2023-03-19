public class BinaryInsertionSortApp{
    
    public static void main (String[] args) {
        int a[] = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};
        int n = a.length, i;
        BinaryInsertionSort bis = new BinaryInsertionSort();
        bis.binaryInsertionSort(a, n);
    
        System.out.println("Arreglo ordenado:");
        bis.printArray(a);
    }
}
