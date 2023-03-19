public class BinaryInsertionSort {
 
//  implementacion iterativa 
    public int binarySearch(int a[], int item, int low, int high){
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item == a[mid])
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public void binaryInsertionSort(int a[], int n) {
        int i, loc, j, k, selected;
    
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
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
}